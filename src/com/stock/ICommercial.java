package com.stock;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;

public interface ICommercial {
   
	double valueOf(String name,double noOfShares,double price);
	void buy(int amount,String symbol) throws FileNotFoundException, IOException, ParseException;
	void sell(int amount,String symbol);
	void save(String filename);
	void printReport();
}
