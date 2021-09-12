package com.stock;

import java.util.Map;

public interface ICommercial {
   
	double valueOf(String name,double noOfShares,double price);
	void buy(int amount,String symbol);
	void sell(int amount,String symbol);
	void save(String filename);
	void printReport();
}
