package linkedList;

/** 
 * Represents a generic node in a generic linked list.
 */
public class Node<T> {
	T object;            // The T object that this node refers to
	Node<T> next;   // The Node object that this node refers to
	
	
	/** 
	 * Constructs a generic node that refers to the given element.
	 * @param object - the element.
	 */
	public Node(T object) {
		this.object = object;
		this.next = null;
	}
	
	
	/** 
	 * Returns a textual representation of the element that this node refers to,
	 * by calling the toString() method of the element.
	 */
	public String toString() {
		return object.toString();
	}
}