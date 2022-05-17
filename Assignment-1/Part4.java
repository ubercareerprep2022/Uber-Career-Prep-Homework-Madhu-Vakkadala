// Singly linked list
public class Main {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		Node one = new Node(0);
		Node two = new Node(1);
		Node three = new Node(2);
		Node four = new Node(3);
		Node five = new Node(4);
		Node six = new Node(5);
		
		list.push(one);
		System.out.println("List size: " + list.size()); 	// 1
		list.push(two);
		list.push(three);
		list.push(four);
		System.out.println("List size: " + list.size());	// 4

		list.printList(); // 0, 1, 2, 3
		
		System.out.println("Popped val: " + list.pop().value); 	// 3
		System.out.println("List size: " + list.size());	// 3
		
		
		list.remove(5); // node doesn't exist
		System.out.println("List size after remove fails: " + list.size());	// 3
		list.remove(1);
		System.out.println("List size after remove: " + list.size());	// 2
		list.printList(); // 0, 2
		

		list.insert(0, five);
		list.printList(); // 4, 0, 2
		list.insert(7, six);
		list.printList(); // 4, 0, 2
		System.out.println("List size: " + list.size());	// 3
		list.insert(3, six);
		list.printList(); // 4, 0, 2, 5
		
		System.out.println("Element at 0: " + list.elementAt(0).value);	// 4
		System.out.println("Element at 1: " + list.elementAt(1).value);	// 0
		System.out.println("Element at 2: " + list.elementAt(2).value);	// 2
		System.out.println("Element at 3: " + list.elementAt(3).value);	// 5
		System.out.println("Element at 4: " + list.elementAt(4));	// null
		System.out.println(list.hasCycle()); // false
		
	}

	static class Node {
		   int value;
		   Node next;
		  
		   Node(int v) {
		       value = v;
		       next = null;
		   }
		   
	}
	
	static class LinkedList {
		Node head;
		
		void push(Node node) {
			if (head == null) {
				head = node;
				return;
			}
			
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = node;
		}
		
		Node pop() {
			Node curr = head;
			while (curr.next.next != null) {
				curr = curr.next;
			}
			Node toReturn = curr.next;
			curr.next = null;
			return toReturn;
		}
		
		int size() {
			Node curr = head;
			int count = 0;
			while (curr.next != null) {
				curr = curr.next;
				count++;
			}
			return count + 1;
		}
		
		void insert(int index, Node node) {
			if (index == 0) {
				node.next = head;
				head = node;
				return;
			}
			if (index > size()) {
				return;
			}
			int count = 0;
			Node curr = head;
			while (count < index - 1) {
				curr = curr.next;
				count++;
			}
			Node temp = curr.next;
			curr.next = node;
			node.next = temp;
		}
		
		void remove(int index) {
			if (index == 0) {
				head = head.next;
			}
			if (index > size()) {
				return;
			}
			int count = 0;
			Node curr = head;
			while (count < index - 1) {
				curr = curr.next;
				count++;
			}
			curr.next = curr.next.next;
		}
		
		Node elementAt(int index) {
			if (index == 0) {
				return head;
			}
			if (index > size()) {
				return null;
			}
			int count = 0;
			Node curr = head;
			while (count < index) {
				curr = curr.next;
				count++;
			}
			return curr;
		}
		
		void printList() {
			Node curr = head;
			String list = "";
			list += curr.value + " ";
			while (curr.next != null) {
				curr = curr.next;
				list += curr.value + " ";
			}
			System.out.println(list);
		}
		
		boolean hasCycle() {
			Node one = head;
			Node two = head;
			
			while (one != null && two != null) {
				one = one.next;
				two = two.next.next;
				
				if (one == two) {
					return true;
				}
			}
			return false;
		}
	}
}
