package springboot.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "account_name")
	private String accountName;

	@NotNull
	@Column(name = "account_pass")
	private String accountPass;

	@NotNull
	@Column(name = "id_person")
	private int idPerson;
	
	@ManyToOne
	@JoinColumn(name = "id_role", nullable = false)
	private Role role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPass() {
		return accountPass;
	}

	public void setAccountPass(String accountPass) {
		this.accountPass = accountPass;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Account(int id, String accountName, String accountPass, int idPerson, Role role) {
		super();
		this.id = id;
		this.accountName = accountName;
		this.accountPass = accountPass;
		this.idPerson = idPerson;
		this.role = role;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
