package model;

public enum Role {
	
	ADMIN("Admin",1), USER("User",2),INVITED("Invited",4), SELLER("Seller",7); 
	
	private String nameRole;
	private int idRole;
	

	private Role(String nameRole, int idRole) {
		this.nameRole = nameRole;
		this.idRole = idRole;
	}


	public String getNameRole() {
		return nameRole;
	}


	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}


	public int getIdRole() {
		return idRole;
	}


	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}


	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", nameRole=" + nameRole + "]";
	}
	
	
}
