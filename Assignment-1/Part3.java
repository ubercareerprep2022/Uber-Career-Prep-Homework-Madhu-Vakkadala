import java.util.*;

public class Main {

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(42);

		System.out.println("Top of stack: " + s.top()); // 2
		System.out.println("Size of stack: " + s.size()); // 1
		System.out.println("Is Empty: " + s.isEmpty()); // false
		System.out.println("Pop stack: " + s.pop()); // 2
		System.out.println("Size of stack: " + s.size()); // 0
		System.out.println("Top of stack: " + s.top()); // -1
		System.out.println("Is Empty: " + s.isEmpty()); // true
		
		
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println("Front of queue: " + q.front()); // 1
		System.out.println("Rear of queue: " + q.rear()); // 3
		System.out.println("Size of queue: " + q.size()); // 3
		System.out.println("Is Empty: " + q.isEmpty()); // false
		q.dequeue();
		System.out.println("Front of queue: " + q.front()); // 2
		System.out.println("Rear of queue: " + q.rear()); // 3
		System.out.println("Size of queue: " + q.size()); // 2
		q.dequeue();
		q.dequeue();
		System.out.println("Front of queue: " + q.front()); // -1
		System.out.println("Rear of queue: " + q.rear()); // -1
		System.out.println("Size of queue: " + q.size()); // 0
		System.out.println("Is Empty: " + q.isEmpty()); // true
	}

	static class Stack {
		ArrayList<Integer> stack = new ArrayList<Integer>();

		void push(int val) {
			stack.add(val);
		}

		int pop() {
			if (stack.size() == 0) {
				return -1;
			}

			int index = stack.size() - 1;

			int toReturn = stack.get(index);
			stack.remove(index);

			return toReturn;
		}

		boolean isEmpty() {
			return stack.isEmpty();
		}

		int size() {
			return stack.size();
		}

		int top() {
			if (stack.size() == 0) {
				return -1;
			}
			return stack.get(stack.size() - 1);
		}
	}

	static class Queue {
		ArrayList<Integer> queue = new ArrayList<Integer>();

		void enqueue(int val) {
			queue.add(val);
		}

		void dequeue() {
			if (queue.size() == 0) {
				return;
			}
			queue.remove(0);
		}

		boolean isEmpty() {
			return queue.isEmpty();
		}

		int size() {
			return queue.size();
		}

		int front() {
			if (queue.size() == 0) {
				return -1;
			}
			return queue.get(0);
		}

		int rear() {
			if (queue.size() == 0) {
				return -1;
			}
			return queue.get(queue.size() - 1);
		}

	}
}
