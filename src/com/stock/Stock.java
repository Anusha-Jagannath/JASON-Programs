package com.stock;

public class Stock {
	private String name;
	private double noOfShares;
	private double sharePrice;
	public Stock(String name, double noOfShares, double sharePrice) {
		super();
		this.name = name;
		this.noOfShares = noOfShares;
		this.sharePrice = sharePrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getNoOfShares() {
		return noOfShares;
	}
	public void setNoOfShares(double noOfShares) {
		this.noOfShares = noOfShares;
	}
	public double getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	@Override
	public String toString() {
		return "Stock [name=" + name + ", noOfShares=" + noOfShares + ", sharePrice=" + sharePrice + "]";
	}
	
	
	

}
