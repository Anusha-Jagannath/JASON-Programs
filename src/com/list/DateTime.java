package com.list;

import java.util.Scanner;

public class DateTime {

	public void computeTime() {
		LinkedList list = new LinkedList();
		Boolean ch = true;
		while (ch) {
			System.out.println("\n1. Add Date\n2. Delete date\n3. Print date\n4. Exit");
			Scanner scanner = new Scanner(System.in);
			Scanner scanner2 = new Scanner(System.in);
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println("Enter share date");
				String data = scanner2.nextLine();
				list.add(data);
				break;
			case 2:
				String deleted = (String) list.deleteAtEnd();
				System.out.println("Deleted company share date is " + deleted);
				break;
			case 3:
				list.print();
				break;

			case 4:
				ch = false;
				break;
			default:
				System.out.println("Invalid choice");

			}
		}
	}
}
