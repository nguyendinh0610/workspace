package LinkedList;

import java.util.*;

public class LinkedListPartitioning {
	public static void main(String[] args){
		
	}
	
	class Node{
		int data;
		Node next = null;
		
		public Node(int value){
			data = value;
		}
		
		public Node appendToEnd(int d){
			Node current = this;
			Node end = new Node(d);
			while (current.next != null){
				current = current.next;
			}
			current.next = end;
			return end;
		}
		
		public Node appendToFront(Node head, int d){
			Node front = new Node(d);
			front.next = head;
			return front;
		}
		
		// Assumption: the node is always there
		public Node partitionLinkedList(Node head, int i){
			if (head == null){
				return null;
			}
			
			Node newHead = new Node(i);
			
			while (head != null){
				if (head.data < i) {
					newHead = newHead.appendToFront(newHead, head.data);
				} else {
					newHead.appendToEnd(head.data);
				}
				head = head.next;
			}
			
			return newHead;
		}
		
		// Another solution is to maintain 2 linked lists, one before and one after.
		// While traversing, disconnect the currently traversed node, 
		// add it to either of the list after storing it to a temp node
		// Then set the next node to the temp node for traversing
	}
}
