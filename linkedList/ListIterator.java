package linkedList;

/** 
 * An iterator for generic linked lists.
 */
public class ListIterator<E> {
	
	private Node<E> current; // The node that this iterator is positioned at
	
	/** 
	 * Returns a new iterator, positioned at the given list element.
	 * @param e  the list element that the iterator starts at.
	 */
	public ListIterator(Node<E> node) {
		this.current = node;
	}
	
	/** 
	 * Returns true if we are not at the end of this list, false otherwise.
	 * @return true if we are not at the end of this list, false otherwise.
	 */
	public boolean hasNext() {
		return (current != null);
	}
	
	/** 
	 * Returns the element that this iterator is positioned on,
	 * and advances the iterator to the next element.
	 * Should be called only if hasNext() is true.
	 * @return the element that this iterator is positioned on
	 * @throws IllegalStateException if the iterator is at the end of the list
	 */
	public E next() {
		if (!hasNext()) {
			throw new IllegalStateException();
		}
		Node<E> currentNode = current;
		current = current.next;
		return currentNode.e;
	}
}
