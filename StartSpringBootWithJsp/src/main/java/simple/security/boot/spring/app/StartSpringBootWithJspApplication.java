package simple.security.boot.spring.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class StartSpringBootWithJspApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StartSpringBootWithJspApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(StartSpringBootWithJspApplication.class, args);
	}

}
