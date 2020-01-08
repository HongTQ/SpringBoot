package springboot.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "career")
public class Career {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id")
	private int idCareer;

	@Column(name = "name")
	@NotBlank(message = "Name career not null")
	@Size(min = 1, max = 45)
	private String nameCareer;

	@JsonIgnore // Không só sẽ bị lặp dữ liệu
	@ManyToMany(mappedBy = "careers", cascade = { CascadeType.REMOVE })
	Set<Person> persons;

	public int getIdCareer() {
		return idCareer;
	}

	public void setIdCareer(int idCareer) {
		this.idCareer = idCareer;
	}

	public String getNameCareer() {
		return nameCareer;
	}

	public void setNameCareer(String nameCareer) {
		this.nameCareer = nameCareer;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public Career(@NotNull int idCareer,
			@NotBlank(message = "Name career not null") @Size(min = 1, max = 45) String nameCareer,
			Set<Person> persons) {
		super();
		this.idCareer = idCareer;
		this.nameCareer = nameCareer;
		this.persons = persons;
	}

	public Career() {
		super();
		// TODO Auto-generated constructor stub
	}

}
