package model;

import java.io.Serializable;

public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1089L;
	
	private int idProduc;
	private String nameProduct;
	private String  descProduct;
	private int idCat;
	private int stock;
	private double price;
	
	public Product() {
		super();
	}

	public Product(String nameProduct, String descProduct, int idCat, double price) {
		super();
		this.nameProduct = nameProduct;
		this.descProduct = descProduct;
		this.idCat = idCat;
		this.price = price;
	}

	public int getIdProduc() {
		return idProduc;
	}

	public void setIdProduc(int idProduc) {
		this.idProduc = idProduc;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getDescProduct() {
		return descProduct;
	}

	public void setDescProduct(String descProduct) {
		this.descProduct = descProduct;
	}

	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [idProduc=" + idProduc + ", nameProduct=" + nameProduct + ", descProduct=" + descProduct
				+ ", idCat=" + idCat + ", stock=" + stock + ", price=" + price + "]";
	}
	
}
