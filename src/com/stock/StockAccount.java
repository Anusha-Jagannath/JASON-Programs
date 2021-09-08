package com.stock;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockAccount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.create account\n2.Buy sales\n3.sell sales\n4.Display value\n5 Display report\n6.Exit");
		int option = sc.nextInt();

		switch (option) {
		case 1:
			createAccount();
			break;
		}

		double totalShares = 0;
		Map<String, Double> map = new HashMap<>();
		JSONParser jsonParser = new JSONParser();
		try {
			Reader reader = new FileReader(
					"/Users/anushajs/eclipse-workspace/Yml-training/JSON-Programs/data/stock.json");
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			System.out.println(jsonObject);
			JSONArray array = (JSONArray) jsonObject.get("stock");
			System.out.println(array);
			Iterator<JSONObject> iterator = array.iterator();
			while (iterator.hasNext()) {
				JSONObject jsonObject2 = (JSONObject) iterator.next();
				System.out.println(jsonObject2);
				String name = (String) jsonObject2.get("name");
				double noOfShares = (double) jsonObject2.get("noOfShares");
				double price = (double) jsonObject2.get("sharePrice");
				totalShares += calculateStockValue(name, noOfShares, price, map);
//				System.out.println("Name: " + name + " No of shares: " + noOfShares + " Price: " + price);
//				map.put(name, price * noOfShares);
			}
			System.out.println("Total value is " + totalShares);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		writeJson(map);

	}

	private static double calculateStockValue(String name, double noOfShares, double price, Map<String, Double> map) {
		System.out.println("Name: " + name + " No of shares: " + noOfShares + " Price: " + price);
		map.put(name, price * noOfShares);
		return price * noOfShares;

	}

	private static void writeJson(final Map<String, Double> map) {
		JSONArray array = new JSONArray();
		for (Entry<String, Double> entry : map.entrySet()) {
			JSONObject object = new JSONObject();
			object.put("name", entry.getKey());
			object.put("totalPrice", entry.getValue());
			array.add(object);
		}
		JSONObject mainObject = new JSONObject();
		mainObject.put("results", array);
		try {
			FileWriter writer = new FileWriter(
					"/Users/anushajs/eclipse-workspace/Yml-training/JSON-Programs/data/stockresult.json");
			writer.write(mainObject.toJSONString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(mainObject);
		System.out.println(map);
	}

	public static void createAccount() {
		String account;
		Scanner sc = new Scanner(System.in);
		account = sc.nextLine();

	}

}