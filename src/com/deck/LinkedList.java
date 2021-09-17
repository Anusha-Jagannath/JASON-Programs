package com.deck;

public class LinkedList {

public Node head;
	
	private class Node {
		String data;
		Node next;

		Node(String data) {
			this.data = data;
			next = null;
		}
	}
	
	/*
	 * method to add data of type string into the LinkedList
	 * @param string type data
	 */
	public void add(final String data) {

		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;

		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	
	/*
	 * method to print the contents of Linked List
	 */
	public void print() {
		Node temp = head;
		if (temp == null) {
			System.out.println("Linked list is empty");
			return;
		}
		while (temp.next != null) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
}
