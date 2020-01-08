package simple.security.boot.spring.app.dto;

public class UserProfileDto {
	
	private int id;
	private String name;
	private String phone;
	private String gmail;
	private String address;
	private String birthday;
	private String userName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserProfileDto(int id, String name, String phone, String gmail, String address, String birthday,
			String userName) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.gmail = gmail;
		this.address = address;
		this.birthday = birthday;
		this.userName = userName;
	}
	public UserProfileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
