package LinkedList;

import java.lang.reflect.Method;
import java.util.*;

public class DuplicationElimination {
	public static void main(String[] args){

	}
	
	public class Node{
		int data;
		Node next = null;
		
		public Node(int d){
			data = d;
		}
		
		void appendToTail(int d){
			Node end = new Node(d);
			Node n = this;
			while (n.next!= null){
				n = n.next;
			}
			n.next = end;
		}
		
		Node deleteNote(Node head, int d){
			Node n = head;
			
			if (n.data == d){
				return head.next;
			}
			
			while (n.next != null) {
				if (n.next.data == d){
					n.next = n.next.next;
					return head;
				}
				n = n.next;
			}
			
			return head;
		}
		
		void removeDuplicateWithoutBuffer(Node head){
			if (head.next == null){
				return;
			}
			
			Node current = head;
			
			while (current.next != null){
				// Remove all future nodes that have the same value
				Node runner = current;
				while (runner.next != null){
					if (current.data == runner.next.data){
						runner.next = runner.next.next;
					} else {
						runner = runner.next;
					}
				}
				current = current.next;
			}
		}
		
		// use a hash table to store the data, if it was previously stored
		// 
		void DeleteDupsWithBuffer(Node head){
			Hashtable ht = new Hashtable();
			Node previous = null;
			while (head != null){
				if (ht.containsKey(head.data)){
					// If the data is in the hashtable
					// point the previous node to next node
					previous.next = head.next;
				} else {
					// First iteration always comes here
					// previous is head or "current"
					ht.put(head.data, true);
					previous = head;
				}
				head = head.next;
			}
		}
	}
}
