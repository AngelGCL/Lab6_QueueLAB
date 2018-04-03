package classes;

import interfaces.Queue;
/** 
A partial implementation of the Queue using a singly linked list with references 
to the first and to the last node.
**/
public class SLLQueue<E> implements Queue<E> {
    // inner class for nodes in singly linked lists
	
	protected static class SNode<T>{
		private T element; 
		private SNode<T> next; 
		public SNode() { 
			element = null; 
			next = null; 
		}
		public SNode(T data, SNode<T> next) { 
			this.element = data; 
			this.next = next; 
		}
		public SNode(T data)  { 
			this.element = data; 
			next = null; 
		}
		public T getElement() {
			return element;
		}
		public void setElement(T data) {
			this.element = data;
		}
		public SNode<T> getNext() {
			return next;
		}
		public void setNext(SNode<T> next) {
			this.next = next;
		}
		public void clean() { 
			element = null; 
			next = null; 
		}
	}
	
	private SNode<E> first, last;   // references to first and last node
	private int size; 
	
	public SLLQueue() {           // initializes instance as empty queue
		first = last = null; 
		size = 0; 
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public E first() {
		if (isEmpty()) 
			return null;
		
		return first.getElement(); 
	}
	public E dequeue() {
		E etr = first();
		if (isEmpty()) 
			return null;
		
		else {
			SNode<E> next = first.getNext();
			first.clean();
			first = next;
		}
		size--;
		return etr;
	}
	
	public void enqueue(E e) {
		if (size == 0) { 
			first = last = new SNode<>(e);
			first.setNext(last);
		}
		else { 
			SNode<E> node = last;
			last = new SNode<>(e);
			node.setNext(last);
		}
		size++; 
	}
}
