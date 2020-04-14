package model;

public class Category {
	private int idCat;
	private String nameCat;
	private String descCat;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String nameCat, String descCat) {
		super();
		this.nameCat = nameCat;
		this.descCat = descCat;
	}
	public int getIdCat() {
		return idCat;
	}
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	public String getNameCat() {
		return nameCat;
	}
	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	public String getDescCat() {
		return descCat;
	}
	public void setDescCat(String descCat) {
		this.descCat = descCat;
	}
	@Override
	public String toString() {
		return "Category [idCat=" + idCat + ", nameCat=" + nameCat + ", descCat=" + descCat + "]";
	}
	
	
	
}
