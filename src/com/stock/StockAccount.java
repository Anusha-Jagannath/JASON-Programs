package com.stock;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class StockAccount implements ICommercial {

	List<Stock> list = new ArrayList<>();
	String filename;

	StockAccount(String filename) {
		this.filename = filename;
	}

	@Override
	public double valueOf(String name, double noOfShares, double price) {
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
		JSONObject jsonobject = new JSONObject();
		JSONArray array = (JSONArray) jsonobject.get("stock");
		Scanner sc = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Stock Name : ");
		String stockName = scanner.nextLine();
		
		System.out.println("Enter Stock symbol : ");
		String stockSymbol = scanner.nextLine();
		
		System.out.println("Enter number of shares: ");
		int noOfShares = sc.nextInt();
		
		System.out.println("Enter share price: ");
		double sharePrice = sc.nextDouble();
		jsonobject.put("name", stockName);
		jsonobject.put("symbol", stockSymbol);
		jsonobject.put("noOfShare", noOfShares);
		jsonobject.put("sharePrice", sharePrice);
		array.add(jsonobject);
		jsonobject.put("stock", array);
		try {
			FileWriter writer = new FileWriter(
					"/Users/anushajs/eclipse-workspace/Yml-training/JSON-Programs/data/stock.json");
			writer.write(jsonobject.toJSONString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printReport() {
		JSONParser jsonparser = new JSONParser();
		try {
			Reader reader = new FileReader(
					"/Users/anushajs/eclipse-workspace/Yml-training/JSON-Programs/data/stock.json");
			JSONObject jsonObject = (JSONObject) jsonparser.parse(reader);
			JSONArray array = (JSONArray) jsonObject.get("stock");
			System.out.println(array);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}

	}

}
