package testers;

import java.util.Random;

import classes.ArrayQueue;
import classes.SLLQueue;
import interfaces.Queue;

public class LLQTest {

	private static Queue<Integer> linkedQ;
	private static Random ra = new Random();
	public static void llQtest() {
		linkedQ = new SLLQueue<Integer>();
		for(int i=0; i<5; i++) {
			linkedQ.enqueue(ra.nextInt(9));
		}
		System.out.println("the first element is: " + linkedQ.first());
		int currSize = linkedQ.size();
		for(int i=0; i<currSize; i++) {
			System.out.println("Linked list dequeue: " + linkedQ.dequeue());
		}
		
	}
	
	public static void main(String[] args) {
		llQtest();
		llAtest();
	}
	
	public static void llAtest() {
		linkedQ = new ArrayQueue<Integer>();
		for(int i=0; i<5; i++) {
			linkedQ.enqueue(ra.nextInt(9));
		}
		System.out.println("the first element is: " + linkedQ.first());
		int currSize = linkedQ.size();
		for(int i=0; i<currSize; i++) {
			System.out.println("Linked list dequeue: " + linkedQ.dequeue());
		}
		
	}
}
