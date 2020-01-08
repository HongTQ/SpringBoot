package springboot.demo.service;

public interface JwtService {
	public String generateTokenLogin(String username);
	public String getAccountNameFromToken(String token);
	Boolean validateTokenLogin(String token);
}
