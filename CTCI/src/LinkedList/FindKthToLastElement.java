package LinkedList;

import java.util.*;

public class FindKthToLastElement {
	public static void main(String[] args){
		
	}
	
	class Node{
		int data;
		Node next = null;
		
		public Node(int value){
			data = value;
		}
		
		public void appendToEnd(int d){
			Node end = new Node(d);
			Node n = this;
			while (n.next != null){
				n = n.next;
			}
			n.next = end;
		}
		
		public Node findNodeFromkthElement(Node head, int k){
			// Return null if head is null
			if (head == null || k < 0){
				return null;
			}
			
			if (k == 0){
				// Return the last element
				while (head.next != null){
					if (head.next == null){
						return head;
					}
				}
			} else {
				Node current = head;
				Node runner = head;
				// Make sure the gap is k
				// if not return null
				for (int gap = 0; gap < k - 1; gap++){
					if (runner.next != null){
						runner = runner.next;
					} else {
						return null;
					}
				}
				
				// Run until the runner is null
				while (runner.next != null){
					current = current.next;
					runner = runner.next;
				}
				
				// Return the current
				return current;
			}
			
			return null;
		}
	}
	
}
