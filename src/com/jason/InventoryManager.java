package com.jason;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InventoryManager {

	/*
	 * method to read inventory.json file
	 */
	public void inventoryFactory(Map<String, Double> map) {
		JSONParser jsonParser = new JSONParser();
		try {
			Reader reader = new FileReader(
					"/Users/anushajs/eclipse-workspace/Yml-training/JSON-Programs/data/inventory.json");
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			System.out.println(jsonObject);
			JSONArray array = (JSONArray) jsonObject.get("inventory");
			System.out.println(array);
			Iterator<JSONObject> iterator = array.iterator();
			while (iterator.hasNext()) {
				JSONObject jsonObject2 = (JSONObject) iterator.next();
				System.out.println(jsonObject2);
				String name = (String) jsonObject2.get("name");
				System.out.println(name);
				double price = (double) jsonObject2.get("pricePerKg");
				double weight = (double) jsonObject2.get("weight");
				System.out.println("Name: " + name + " price: " + price + " Weight: " + weight);
				map.put(name, price * weight);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	/*
	 * method to store data to result.json file
	 */

	public void inventoryManage(Map<String, Double> map) {
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
					"/Users/anushajs/eclipse-workspace/Yml-training/JSON-Programs/data/result.json");
			writer.write(mainObject.toJSONString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(mainObject);
		System.out.println(map);

	}

}
