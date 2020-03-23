package linkedList;

public class LinkedListTests {
	public static void main(String[] args) {
		// Creates a list of Integer objects, add some elements, and prints the list.
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.add(7);
		list.add(9);
		System.out.println(list);
		list.add(8,6);
		System.out.println(list);
		testExceptions();
		
		// As you implement the LinkedList class methods, write your testing 
		// code below. If you want, you can use private testing methods.
		// testExceptions();
	}
	
	// Exception testing method.
	private static void testExceptions() {
	    // Creates a list of Integer objects
		LinkedList<Integer> list = new LinkedList<Integer>();
			
		// After we will implement the getFirst() method, the statement below
		// should cause the program to crash.
		// To prevent it, we wraped the method call with try/catch code. 
	    list.getFirst(); // Tries to get an element from the list, which is empty
	    list.getLast();
	    
	    // Adds three elements to the list, and prints it
		list.add(3);
		list.add(7);
		list.add(9);
		System.out.println(list);
			
		// After we will implement the add method, the statement below
		// should cause the program to crash.
		// To prevent it, we wraped the method call with try/catch code. 
		list.add(8,-2);	// Tries to insert an element in index -2.
					
		// After we will implement the add method, the statement below
		// should cause the program to crash.
		// To prevent it, we wraped the method call with try/catch code. 
		list.add(8,10); // Tries to insert an element in index 10.
	}
}
