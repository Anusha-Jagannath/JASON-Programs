package com.stock;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockPortfolio {
	

	public static double calculateStockValue(String name, double noOfShares, double price, Map<String, Double> map) {
		System.out.println("Name: " + name + " No of shares: " + noOfShares + " Price: " + price);
		map.put(name, price * noOfShares);
		return price * noOfShares;

	}

	public static void writeJson(final Map<String, Double> map) {
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
}