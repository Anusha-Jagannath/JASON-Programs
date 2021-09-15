package com.list;

public class LinkedList<T> {

	private Node head;

	private class Node {
		T data;
		Node next;

		Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/*
	 * method to insert data at the end
	 * 
	 * @param data
	 */
	public boolean add(final T data) {
		boolean isAdded = false;
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			isAdded = true;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			isAdded = true;
		}
		return isAdded;
	}

	/*
	 * method to delete node at the end
	 */

	public T deleteAtEnd() {
		Node temp = head;
		Node cur = temp;
		if (head == null) {
			System.out.println("Deletion not possible");
			return null;
		} else if (head.next == null) {
			head = null;
			return head.data;

		} else {
			while (temp.next != null) {
				cur = temp;
				temp = temp.next;
			}
			cur.next = null;
		}
		return temp.data;
	}

	/*
	 * method to delete data from the head
	 */

	public T deleteAtHead() {
		Node temp = head;
		if (head == null) {
			System.out.println("List is empty");
			return null;
		} else if (head.next == null) {
			temp = null;

		} else {
			head = head.next;
			temp.next = null;
		}
		return temp.data;
	}

	/*
	 * method to display linkedlist
	 */
	public void print() {
		Node temp = head;
		System.out.println("\nLinked list is");
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
	}

}
