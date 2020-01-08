package springboot.demo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import springboot.demo.common.rest.CustomAccessDeniedHandler;
import springboot.demo.common.rest.JwtAuthenticationTokenFilter;
import springboot.demo.common.rest.RestAuthenticationEntryPoint;

@Configuration // xác định lớp WebSecurityConfig của ta là một lớp dùng để cấu hình.
@EnableWebSecurity // sẽ kích hoạt việc tích hợp Spring Security.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
		JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
		jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
		return jwtAuthenticationTokenFilter;
	}

	@Bean
	public RestAuthenticationEntryPoint restServicesEntryPoint() {
		return new RestAuthenticationEntryPoint();
	}

	@Bean
	public CustomAccessDeniedHandler customAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().ignoringAntMatchers("/");
		
		http.authorizeRequests().antMatchers("/login**","/public/js/**","/js/**").permitAll();

		http.antMatcher("/api/**").httpBasic()
				.authenticationEntryPoint((AuthenticationEntryPoint) restServicesEntryPoint()).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/persons/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				.antMatchers(HttpMethod.GET, "/api/careers/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				.antMatchers(HttpMethod.POST, "/api/persons/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers(HttpMethod.POST, "/api/careers/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers(HttpMethod.DELETE, "/api/persons/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers(HttpMethod.DELETE, "/api/careers/**").access("hasRole('ROLE_ADMIN')").and()
				.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
				.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());

	}
}
