package springboot.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import org.springframework.boot.context.properties.ConfigurationProperties;

@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;

	@Column(name = "first_name")
	@NotBlank(message = "First name not null")
	@Size(min = 1, max = 45)
	private String firstName;

	@Column(name = "last_name")
	@NotBlank(message = "Last name not null")
	@Size(min = 1, max = 45)
	private String lastName;

	@Column(name = "sex")
	@NotNull(message = "Sex not null")
	private boolean sex;

	@Column(name = "birthday")
	@NotBlank(message = "Birthday not null")
	private String birthday;

	@Column(name = "phone")
	@NotBlank(message = "phone not null")
	@Size(min = 9, max = 12)
	private String phone;

	@Column(name = "address")
	@Size(min = 0, max = 200)
	private String address;

	@ManyToMany(cascade = { CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name = "person_career", joinColumns = @JoinColumn(name = "id_person"), inverseJoinColumns = @JoinColumn(name = "id_career"))
	Set<Career> careers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Career> getCareers() {
		return careers;
	}

	public void setCareers(Set<Career> careers) {
		this.careers = careers;
	}

	public Person(@NotNull int id, @NotBlank(message = "First name not null") @Size(min = 1, max = 45) String firstName,
			@NotBlank(message = "Last name not null") @Size(min = 1, max = 45) String lastName,
			@NotNull(message = "Sex not null") boolean sex, @NotBlank(message = "Birthday not null") String birthday,
			@NotBlank(message = "phone not null") @Size(min = 9, max = 12) String phone,
			@Size(min = 0, max = 200) String address, Set<Career> careers) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.careers = careers;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

}
