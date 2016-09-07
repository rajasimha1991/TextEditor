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
		this.size = 0;
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		// TODO: Implement this method
		LLNode<E> new_node = new LLNode<E>(element);
		new_node.next = tail;
		new_node.prev = tail.prev;
		tail.prev.next = new_node;
		tail.prev = new_node;
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("check the index");
		LLNode<E> current = head.get_next();
		for(int i=0; i<index; i++){
			current = current.next;
		}
		return current.get_data();
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
		if(index < 0 || index > size) throw new IndexOutOfBoundsException("check the index");
		if(element == null) throw new NullPointerException(); 
		if(index==0) add(element);
		else{
		LLNode<E> new_node = new LLNode<E>(element);
		LLNode<E> current = head.next;
		for(int i=0; i<index-1; i++){
			current = current.next;
		}
		new_node.next = current.next;
		new_node.prev = current.next.prev;
		current.next.prev = new_node;
		current.next = new_node;
		size++;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
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
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("check the index");
		LLNode<E> current = head.next;
		for(int i=0; i<index; i++){
			current = current.next;
		}
		current.prev.next = current.next;
		current.next.prev = current.prev;
		current.next = null;
		current.prev = null;
		size--;
		return current.data;
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
		if(index < 0 || index >= size) throw new IndexOutOfBoundsException("check the index");
		if(element == null) throw new NullPointerException("check the element");
		LLNode<E> current = head.next;
		for(int i=0 ;i<index; i++){
			current = current.next;
		}
		current.data = element;
		return current.data;
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
	
	public LLNode(E e, LLNode<E> prev_node) 
	{
		this(e);
		this.next = prev_node.next;
		this.prev = prev_node;
		
	}
	
	public E get_data()
	{
		return data;
	}
	
	public LLNode<E> get_next()
	{
		return next;
	}
	
	public LLNode<E> get_prev()
	{
		return prev;
	}
	
	public void set_next(LLNode<E> next_node )
	{
		next = next_node;
	}
	
	public void set_prev(LLNode<E> prev_node )
	{
		prev = prev_node;
	}

}


