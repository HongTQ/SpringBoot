package springboot.demo.common.exception;

public class NotFoundException extends RuntimeException{
	public static final long serialVersionUID = 1L;
	
	public NotFoundException(String str) {
		super(str);
	}
}
