package com.jason;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to JASON programs");
		Map<String, Double> map = new HashMap<>();
		InventoryManager inventory = new InventoryManager();
		inventory.inventoryFactory(map);
		inventory.inventoryManage(map);
	}
}
