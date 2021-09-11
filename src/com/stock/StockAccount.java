package com.stock;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StockAccount implements ICommercial {

	@Override
	public double valueOf(String name,double noOfShares,double price) {
		System.out.println("Name: " + name + " No of shares: " + noOfShares + " Price: " + price);
		return price * noOfShares;		
	}

	@Override
	public void buy(int amount, String symbol) {
		
	}

	@Override
	public void sell(int amount, String symbol) {
		
	}

	@Override
	public void save(String filename) {
		
		
	}

	@Override
	public void printReport() {
		
		
	}

}
