package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 *
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		this.head.next=tail;
		this.tail.prev=head;
		this.size=0;

	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element )
	{
		// TODO: Implement this method
		if(element == null)
		{
			throw new NullPointerException();
		}
		else {
			LLNode<E> newElement = new LLNode<E>(element);
			this.tail.prev.next= newElement;
			newElement.prev=tail.prev;
			newElement.next=tail;
			this.tail.prev=newElement;
			this.size++;
			return true;
		}
	}

	/** Get the element at position index
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index)
	{
		// TODO: Implement this method.
		int i=0;
		if(index <0 || index >= this.size)
			throw new IndexOutOfBoundsException();
		else {
			LLNode<E> node=this.head.next;
			while(i<index) {
				node=node.next;
				i++;
			}
			return node.data;

		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element )
	{
		// TODO: Implement this method
		if(index <0 || index > this.size)
			throw new IndexOutOfBoundsException();
		if(element == null)
			throw new NullPointerException();

			int i=0;
			LLNode<E> node1=this.head.next;
			if(index==0)
				node1=this.head;
			LLNode<E> newElement = new LLNode<E>(element);
			while(i<index-1) {
				node1=node1.next;
				i++;
			}
			LLNode<E> node2=node1.next;
			node1.next=newElement;
			newElement.prev=node1;

			newElement.next=node2;
			node2.prev=newElement;

			this.size++;

	}


	/** Return the size of the list */
	public int size()
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 *
	 */
	public E remove(int index)
	{
		// TODO: Implement this method
		if(index <0 || index >= this.size)
			throw new IndexOutOfBoundsException();
		int i=0;
		LLNode<E> node=this.head.next;
		while(i<index) {
			node=node.next;
			i++;
		}
		node.prev.next=node.next;
		node.next.prev=node.prev;
		node.next=null;
		node.prev=null;
		this.size--;
		return node.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element)
	{
		// TODO: Implement this method
		if(index <0 || index >= this.size)
			throw new IndexOutOfBoundsException();
		if(element == null)
			throw new NullPointerException();
		this.add(index, element);
		return this.remove(index+1);
	}
}

class LLNode<E>
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e)
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
