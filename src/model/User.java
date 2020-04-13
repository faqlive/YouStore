package model;

import java.time.LocalDate;

public class User {
	
	private int id;
	private String name;
	private String mail;
	private byte[] pass;
	private LocalDate dateup;
	private Role role;
	
	/**
	 * Beans User, 
	 * 
	 * Constructor vacio define el Role IVITED como predeterminado para 
	 * evitar problemas de acceso y de seguridad indeseados.
	 * */
	public User() {
		super();
		this.role = Role.INVITED;
	}
	
	public User(String name, String mail, byte[] pass) {
		super();
		this.name = name;
		this.mail = mail;
		this.pass = pass;
		this.dateup = LocalDate.now();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public byte[] getPass() {
		return pass;
	}
	public void setPass(byte[] pass) {
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDate getDateup() {
		return dateup;
	}
	public void setDateup(LocalDate dateup) {
		this.dateup = dateup;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mail=" + mail + ", dateup=" + dateup + ", role=" + role + "]";
	}

	
}
