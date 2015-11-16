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
		this.size=0;
		this.head=new LLNode<E>(null);		
		this.tail=new LLNode<E>(null);
		head.next=tail;
		tail.prev=head;		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element==null) throw new NullPointerException();
		
		/*LLNode<E> newNode=new LLNode<E>(element);
		tail.prev.next=newNode;
		newNode.prev=tail.prev;
		newNode.next=tail;
		tail.prev=newNode;
		size++;*/
			add(size,element);
		return true;
		
	}

	public LLNode<E> getNode(int index)
	{
		LLNode<E> getNode = new LLNode<E>(null);		
        if (index < size / 2) {
            getNode = head.next;
            for (int j = 0; j < index; j++)
            {
                getNode = getNode.next;
                //System.out.println(getNode.data);
            }
        } else {
            getNode = tail;
            for (int j = size; j > index; j--)
            {
                getNode = getNode.prev;
                //System.out.println(getNode.data);
            }
        }
        return getNode;
	}
	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index > size-1) throw new IndexOutOfBoundsException();
	       return getNode(index).data;		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element==null) throw new NullPointerException();
		if (index<0 || index > size) throw new IndexOutOfBoundsException();
        LLNode<E> indexNode = getNode(index);
        LLNode<E> newNode=new LLNode<E>(element);
        newNode.prev = indexNode.prev;
        newNode.next = indexNode;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
        size++;
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
		 if (index < 0 || index > size-1) throw new IndexOutOfBoundsException();
	        LLNode<E> w = getNode(index);
	        
	        w.prev.next = w.next;
	        w.next.prev = w.prev;
	        size--;
	        return w.data;
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
		if(element==null) throw new NullPointerException();
		if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException();
        LLNode<E> u = getNode(index);
        E y = u.data;
        u.data = element;
        return y;
		
	}  
	public String toString()
	{
		String str="";
		for(int i=0;i<size;i++)
		{
			str+=this.get(i)+" ";
		}
		return str;
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
	public LLNode(E e,LLNode<E> prev,LLNode<E> next)
	{
		this.data=e;
		this.prev=prev;
		this.next=next;
	}
	
	public String toString()
	{		
		return data.toString();
	}

}

