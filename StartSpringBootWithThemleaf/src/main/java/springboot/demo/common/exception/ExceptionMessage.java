package springboot.demo.common.exception;

public class ExceptionMessage {
	private String key;
	private String message;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ExceptionMessage(String key, String message) {
		super();
		this.key = key;
		this.message = message;
	}
	public ExceptionMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
