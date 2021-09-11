package com.stock;

public class Stock {
	private String name;
	private String symbol;
	private double noOfShares;
	private double sharePrice;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public Stock(String name,String symbol, double noOfShares, double sharePrice) {
		super();
		this.name = name;
		this.symbol = symbol;
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
