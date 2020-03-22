package linkedList;

import java.util.NoSuchElementException;



/**
 * Represents a generic linked list, and list-oriented operations.
 * The list can hold objects of any type.
 */
public class LinkedList<E> {
	
	// The following constant is used for localizing the line separator character,
	// which may be different in different host platforms.
	static final String nl =  System.getProperty("line.separator");

	private Node<E> first;  // Points to the first node in the list (just after the dummy node)
	private Node<E> last;   // Points to the last node in the list
	private int size;       // Number of list elements
	
	/** 
	 * Creates a list with 0 elements.
	 */
	public LinkedList() {
		// Starts with a dummy node, to avoid handling empty lists.
		Node<E> dummy = new Node<E>(null);
		this.first =  dummy;
		this.last = first;
		this.size = 0;
	}
	
	/** 
	 * Adds the given element to the end of this list.
	 * @param e  the node to add
	 */
	public void add(E e) {
	    Node<E> newNode = new Node<E>(e);
		last.next = newNode;
		last = newNode;
		if (size == 0) {
			first.next = newNode;
		}
        size++;
	}

	/** 
	 * Adds the given element to the beginning of this list.
	 * @param e  the element to add to the list.
	 */
	public void addFirst(E e) {

		// Creates a Node object that holds the given data value
		Node<E> newNode = new Node<E>(e);
		// Makes the new node point to the first node in this list 
		newNode.next = first.next;
		// Makes first point to the new node
		first.next = newNode;
		if(size==0)last=newNode;
		size++;
	}
	
	/**
	 * Adds the given element at the n'th location of this list.
	 * The index of the list's first element is 0.
	 * The index of the list's last element is the list's size.
	 * @param  e the element to add
	 * @param  index the index
	 * @throws IllegalArgumentException if index is negative or larger than the list's size
	 */
	public void add(E e, int index) {
//		// In case the index points on the first in the list.
//		if (index==1 || index ==0) {
//			addFirst( e);
//			return;
//		}
//		// If the index is larger than the list size, simply call the normal "add" function
//		// to bind the NODE to the end of the list and ignore the irrelevant size of the index.
//		if(index>size) {
//			add(e);
//			return;
//		}
		try {
		if(index<0||index>size)throw new IllegalArgumentException();
		Node<E> newe = new Node<E>(e);
		Node<E> current = first.next;
		Node<E> prev = first;
		for(int i=0;i<index;i++) {
			current=current.next;
			prev=prev.next;
		}
		newe.next=current;
		prev.next=newe;
		if(index<0)
		size ++;
		}
		catch(IllegalArgumentException e1){
			System.out.println("Error - index is negative or larger than the list's size");
		}
	}
	
	/** 
	 * Returns the index of the given element in this list, or -1 if not found.
	 * @param  e the returned index will be the index of e.
	 * @return the index of the given element in this list
	 */
	public int indexOf (E e) {
		int pos=0;
	    Node<E> current=first.next;
	    //check if each element's data equals to the given data.
	    //if it is, returns it position in the list.
	    while(current!=null) {
	    	if(current.e.equals(e))return pos;
	    	current=current.next;
	    	pos++;
	    }
	    return -1;

	}

	/** 
	 * If the given element exists in this list, removes it and returns true.
	 *  Otherwise, returns false.
	 * @param  e the element to remove.
	 * @return if the given element exists in this list, removes it and
	 * returns true. Otherwise, returns false.
	 */
	 public boolean remove(E e) {
		 Node<E> current=first.next;
	     Node<E> previous=first;
	     while(current!=null) {
	    	 //If a match is found, we will need to skip that element
	    	 //and "chop" its connections and thus remove it from the list.
	    	 if(current.e.equals(e)) {
	    		 if(current==last)last=previous;
	    		 current=current.next;
	    		 previous.next=current;
	    		 size--;
	    		 return true;
	    	 }
	    	 current=current.next;
	    	 previous=previous.next;
	     }
	     return false;
	}

	/** 
	 * Returns the first element in this list.
	 * @return the first element in this list.
	 * @throws NoSuchElementException if the list is empty
	 */
	public E getFirst() {
		try { if(size==0) 
		throw new NoSuchElementException();
		Node<E> f= this.first;
		return  f.next.e; // skips the dummy
		}catch(NoSuchElementException e) {
			System.out.println("Error - the list is empty");
		}
		return null;
	}
	
	/** 
	 * Returns the last element in this list.
	 * @return the last element in this list.
	 * @throws NoSuchElementException if the list is empty
	 */
	public E getLast() {
		try {
			if(size==0)throw new NoSuchElementException();
		return last.next.e;
		}catch(NoSuchElementException e) {
			System.out.println("Error - the list is empty");
		}
		return null;
	}
	
	/** 
	 * Returns the size of this list.
	 * @return the size of this list.
	 */
	public int size() {
	    return size;
	}
	
	/** 
	 * Returns an itertaor on this list.
	 * @return an itertaor on this list.
	 */
	public ListIterator<E> iterator() {
	    return new ListIterator<E>(first.next);
	}
	
	/**
	 * A textual representation of the elements of this list.
	 * Each element is displayed in a separate line.
	 */
	public String toString() {
	    if (size == 0) return "()";
	    StringBuilder str = new StringBuilder();
	    ListIterator<E> itr = this.iterator();
	    while (itr.hasNext()) {
	        str.append(itr.next().toString() +  nl);
	    }
	    return str.toString();
	}
	
	// The main method of this class can be used for testing the
	// LinkedList methods. Clients of the class will normally not use it.
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
			
		// After you'll implement the getFirst() method, the statement below
		// should cause the program to crash.
		// To prevent it, wrap the method call with try/catch code. 
	    list.getFirst(); // Tries to get an element from the list, which is empty
	    list.getLast();
	    
	    // Adds three elements to the list, and prints it
		list.add(3);
		list.add(7);
		list.add(9);
		System.out.println(list);
			
		// After you'll implement the add(e,index) method, the statement below
		// should cause the program to crash.
		// To prevent it, wrap the method call with try/catch code. 
		list.add(8,-2);	// Tries to insert an element in index -2.
					
		// After you'll implement the add(e,index) method, the statement below
		// should cause the program to crash.
		// To prevent it, wrap the method call with try/catch code. 
		list.add(8,10); // Tries to insert an element in index 10.
	}
}
