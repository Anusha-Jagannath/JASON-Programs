package com.stock;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockManagement {
	public static void main(String[] args) {
		double totalShares = 0;
		List<Stock> list = new ArrayList<>();
		StockPortfolio stockportfolio = new StockPortfolio();
		//reading json file
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
				String symbol = (String) jsonObject2.get("symbol");
				double noOfShares = (double) jsonObject2.get("noOfShares");
				double price = (double) jsonObject2.get("sharePrice");
				Stock stocks = new Stock(name,symbol,noOfShares,price);
				stocks.setName(name);
				stocks.setSymbol(symbol);
				stocks.setNoOfShares(noOfShares);
				stocks.setSharePrice(price);
				totalShares += stockportfolio.calculateStockValue(name, noOfShares, price, map);
			}
			System.out.println("Total value is " + totalShares);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		stockportfolio.writeJson(map);
		
       
	}

}