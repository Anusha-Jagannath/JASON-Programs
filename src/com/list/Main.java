package com.list;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
      
		Boolean ch = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.Company share\n2.Stock symbol\n3.date and time\n4.Exit");
		int option = scanner.nextInt();
		switch(option) {
		case 1:CompanyShares shares = new CompanyShares();
		       shares.computeShares();
		       break;
		case 2:StackSymbol symbol = new StackSymbol();
		       symbol.computeSymbol();
		       break;
		case 3:DateTime time =new DateTime();
		       time.computeTime();
		       break;
		case 4:ch = false;
		       break;
		 default:System.out.println("Invalid choice");
		}
		
	}

}
