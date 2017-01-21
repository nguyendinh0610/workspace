package LinkedList;

import java.util.*;

public class RemoveMiddleNode {
	public static void main(String[] args){
		
	}
	
	class Node{
		int data;
		Node next = null;
		
		public Node(int value){
			data = value;
		}
		
		public void appendToEnd(int value){
			Node end = new Node(value);
			Node current = this;
			while(current.next != null){
				current = current.next;
			}
			current.next = end;
		}
		
		public void removeMiddleNode(Node n){
			// The approach will not work if the node is at the end.
			if (n == null || n.next == null){
				return;
			}
			
			// Copy the next node to this node 
			// and remove the next node.
			Node next = n.next;
			n.data = next.data;
			n.next = n.next;
		}
	}

}
