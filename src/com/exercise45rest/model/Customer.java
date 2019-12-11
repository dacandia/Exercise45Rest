package com.exercise45rest.model;

public class Customer {
	private int idCustomer;
	private String nameCustomer;
	private String addressCustomer;
	private int ageCustomer;
	private double heightCustomer;
	private double weightCustomer;
	private boolean isSingle;
	
	public Customer() {}
	
	public Customer(int idCustomer, String nameCustomer, String addressCustomer, int ageCustomer, double heightCustomer, double weightCustomer, boolean isSingle) {
		this.idCustomer = idCustomer;
		this.nameCustomer = nameCustomer;
		this.addressCustomer = addressCustomer;
		this.ageCustomer = ageCustomer;
		this.heightCustomer = heightCustomer;
		this.weightCustomer = weightCustomer;
		this.isSingle = isSingle;
	}
	
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public int getIdCustomer() {
		return this.idCustomer;
	}
	
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public String getNameCustomer() {
		return this.nameCustomer;
	}
	
	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}
	public String getAddressCustomer() {
		return this.addressCustomer;
	}
	
	public void setAgeCustomer(int ageCustomer) {
		this.ageCustomer = ageCustomer;
	}
	public int getAgeCustomer() {
		return this.ageCustomer;
	}
	
	public void setHeightCustomer(double heightCustomer) {
		this.heightCustomer = heightCustomer;
	}
	public double getHeightCustomer() {
		return heightCustomer;
	}
	
	public void setWeightCustomer(double weigthCustomer) {
		this.weightCustomer = weigthCustomer;
	}
	public double getWeightCustomer() {
		return this.weightCustomer;
	}
	
	public void setIsSingle(boolean isSingle) {
		this.isSingle = isSingle;
	}
	public boolean getIsSingle() {
		return this.isSingle;
	}
}
