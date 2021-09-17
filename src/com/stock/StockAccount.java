package com.stock;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.list.CompanyShares;

/*StockAccount.java implements a data type that
* might be used by a financial institution to keep track of customer information.
*/
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

	/*
	 * method to buy the stock from the company
	 */
	@Override
	public void buy(int amount, String symbol) throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		Reader reader = new FileReader(
				"/Users/anushajs/eclipse-workspace/Yml-training/JSON-Project/data/inventory.json");
		Scanner in = new Scanner(System.in);
		System.out.println("Select the stock you want to buy");
		JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
		JSONArray stocks = (JSONArray) jsonObject.get("inventory");
		Iterator<JSONObject> itr = stocks.iterator();
		int count = 1;
		while (itr.hasNext()) {
			System.out.println(count + ":");
			JSONObject stock = itr.next();
			System.out.println("Stock Name: " + stock.get("stockName"));
			System.out.println("Stock Symbol: " + stock.get("stockSymbol"));
			System.out.println("Share price: " + stock.get("sharePrice"));
			System.out.println("Number Of Shares: " + stock.get("numberOfShares"));
			System.out.println();
			count++;
		}

		int stockChoice = in.nextInt();
		while (stockChoice >= count) {
			System.out.println("Invalid option");
			stockChoice = in.nextInt();
		}

		System.out.println("Enter the amount to buy");
		int amount1 = in.nextInt();
		JSONObject selectedStock = (JSONObject) stocks.get(stockChoice - 1);
		while (amount1 > (long) selectedStock.get("numberOfShares") || amount1 <= 0) {
			System.out.println("Enter a valid amount");
			amount1 = in.nextInt();
		}

	}

	/*
	 * method to sell the stock
	 */
	@Override
	public void sell(int amount, String symbol) {
		Scanner in = new Scanner(System.in);
		System.out.println("Select the stock you want to Sell");
		System.out.println("Enter the amount to sell");
		int amount1 = in.nextInt();
	}

	/*
	 * saves the data to json file
	 */
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

	/*
	 * prints the report
	 */
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
