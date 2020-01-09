package rest.api.spring.security.jwt.simple.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Size(min = 0, max = 45)
	private String name;

	@NotNull
	@Size(min = 0, max = 11)
	private String phone;

	@Temporal(TemporalType.DATE)
	@NotNull
	private Date birthday;

	@Email
	@NotNull
	@Size(min = 0, max = 100)
	private String email;

	@Size(max = 200)
	private String address;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_user", nullable = false)
	private User user;

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Person(int id, @NotNull @Size(min = 0, max = 45) String name, @NotNull @Size(min = 0, max = 11) String phone,
			@NotNull Date birthday, @Email @NotNull @Size(min = 0, max = 100) String email,
			@Size(max = 200) String address, User user) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
		this.user = user;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

}
