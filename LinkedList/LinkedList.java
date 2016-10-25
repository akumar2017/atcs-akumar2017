import java.util.Iterator;
import java.util.NoSuchElementException;
/**
The Linked List class contains a series of ListNodes that together
function like a List. A Linked List must contain values all of a
certain type. This class implements Stack, Queue, and Iterable,
giving it the functionality of all three.
@author Akash Kumar
@version 10/25/16
*/
public class LinkedList<E> implements Stack<E>, Queue<E>, Iterable<E>
{
	/**
	A pointer to the first ListNode in the LinkedList
	*/
	public ListNode<E> head;
	
	/**
	A pointer to the last ListNode in the LinkedList
	*/
	public ListNode<E> tail;
	
	/**
	The length of the LinkedList (the number of ListNodes)
	*/
	private int size;
	
	/**
	Default Constructor which initializes head and tail pointers to null and sets size to zero
	*/
	public LinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	Constructor that begins a new Linked List with an existing Node as the head
	@param h Node that will be the head of the new Linked List
	*/
	public LinkedList(ListNode<E> h)
	{
		this();
		add(h.getItem());
	}

	/**
	Copy Constructor that makes a copy of an existing Linked List
	@param list Linked List to be copied
	*/
	public LinkedList(LinkedList<E> list)
	{
		ListNode<E> node = list.head;
		while (node != null)
		{
			add(node.getItem());
			node = node.getNext();
		}
	}
	
	/**
	Returns the size of the Linked List
	@return size of the Linked List
	*/
	public int size()
	{
		return size;
	}		
		
	/**
	Adds a new item to a specific spot in the Linked List
	@param index where the item should be added
	@param item the thing of type E being added
	@return whether or not there is a successful addition
	*/	
	public boolean add(int index, E item)
	{
		//Makes sure the index is within the size of the Linked List
		if (index > size || index < 0 )
		{		
			throw new IndexOutOfBoundsException("Index " + index + " is not within the size: " + size + " of Linked List");
		}
		//Checks if the Linked List is empty
		if (tail == null || index == size)
		{
			return add(item);
		}
		ListNode<E> holder = head;
		int num = 0;
		//Finds the List Node before the spot where the item is added
		while (num < index - 1)
		{
			holder = holder.getNext();
			num+=1;
		}
		if (index > 0)
		{			
			ListNode<E> l = new ListNode<E>(item, holder.getNext()); 
			holder.setNext(l);		
		}
		else
		{
			//basically if the index is 0
			ListNode<E> l = new ListNode<E>(item, head); 
			head = l;
		}
		size+=1;
		return true;
	}
	
	/**
	Creates and returns an iterator
	@return The Iterator
	*/
	public Iterator<E> iterator()
	{
		return new LinkedListIterator<E>(head);
	}
	
	/**
	Adds an item to the end of the Linked List
	@param item the thing to be added
	@return whether or not the addition was successful	
	*/
	public boolean add(E item)
	{
		ListNode<E> l = new ListNode<E>(item); 
		if (tail == null)
		{
			head = l;
			tail = l;
			size+=1;
			return true;
		}
		tail.setNext(l);
		tail = l;
		size+=1;
		return true;
	}
	
	/**
	Removes the ListNode and item within the ListNode from a given index
	@param index the place that will be removed
	@return the value previously at the index
	*/
	public E remove(int index)
	{
		//Makes sure proper index was used
		if (index > size || index < 0 )
		{
			throw new IndexOutOfBoundsException("Index " + index + " is outside the size " + size + " of the Linked List");
		}
		ListNode<E> node = head;
		E returner;
		//If you are trying to remove the head
		if (index == 0)
		{
			removeFirst();
		}
		int num = 0;
		//Gets to the List Node before the one to be removed
		while (num < index - 1)
		{
			node = node.getNext();
			num+=1;
		}
		returner = node.getNext().getItem();
		node.setNext(node.getNext().getNext());
		//Case for if the tail is being removed
		if (index == size - 1)
		{
			tail = node;
		}
		size -= 1;
		return returner;	
	}
	
	/**
	Removes the first instance of a given value
	@param item the desired value to be removed
	@return whether or not a removal is successful
	*/
	public boolean remove(E item)
	{
		if (! contains(item))
			return false;
		remove(indexOf(item));
		return true;
				
	}
			
	/**
	Checks to see if a given value is in the Linked List
	@param object the item that is being checked for
	@return whether or not the item is contained within the Linked List
	*/
	public boolean contains(E object)
	{
		return indexOf(object) != -1;
	}
		
	/**
	Returns the index of the first instance of an object
	@param object the item that is being checked for
	@return the index of the object if it is in the List or -1 if it is not in the List
	*/
	public int indexOf (E object)
	{
		ListNode<E> node = head;
		int num = 0;
		while (num < size)
		{
			if (object == null)
			{
				 if (node.getItem() == null)
					return num;	
			}
			else
			{
				if (object.equals(node.getItem()))
					return num;
			}
			node = node.getNext();
			num +=1;
		}
		return -1;
	}
	
	/**
	Empties the LinkedList
	*/
	public void clear()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	/**		
	Returns the item at a given index
	@param index The spot to be gotten
	@return the item at the given spot
	*/
	public E get(int index)		
	{
		if (index > size || index < 0 )
		{
			throw new IndexOutOfBoundsException("Index " + index + " is not within the size: " + size + " of Linked List");
		}
		ListNode<E> node = head;
		int num = 0;
		while (num < index)
		{
			node = node.getNext();
			num+=1;
		}
		return node.getItem();
	}
	
	/**  
	Inserts an item at a given location regardless of what is already there
	@param o the item to be placed
	@param i the spot for the item
	@return the item that was previously in that spot
	*/
	public E set(int i , E o)
	{
		add(i, o);
		E holder = get(i+1);
		remove(i + 1);
		return holder;
	}

	/**  
	Identifies whether the Linked List is empty
	@return whether or not it is empty
	*/	
	public boolean isEmpty()
	{
		return (head == null);
	}		

	/** 
	Returns a string representation of the Linked List
	@return the string representation of the Linked List
	*/	
	public String toString()
	{
		ListNode<E> node = head;
		String s = "";
		while (node != null)
		{
			s += node.toString();
			s+= "\n";
			node = node.getNext();
		}
		return s;
	
	}
	
	/**
	Adds an item to the beginning of the linked List
	@param item the value to be pushed
	*/
	public void push(E item)
	{
		addFirst(item);	
	}
	
	/**
	Removes and returns the head of the Linked List
	@return the value of the head
	*/
	public E pop()
	{
		return removeFirst();
	}
	
	/**
	Returns what is first in the Linked List, but does not change anything
	@return head node
	*/
	public E peek()
	{
		return get(0);
	}
	
	/**
	Adds an item to the end of the Linked List
	@param item the thing being added
	*/
	public void offer(E item)
	{
		addLast(item);
	}
	
	/**
	Removes and returns the head of the Linked List
	@return the value of the head
	*/	
	public E poll()
	{
		return removeFirst();
	}
	
	/**
	adds an item to the beginning of the Linked List
	@param item the object being added to the Linked List
	*/
	public void addFirst(E item)
	{
		add(0, item);
	}
	
	/**
	Adds an item to the end of the Linked List
	@param item the object being added to the end of the Linked List
	*/
	public void addLast(E item)
	{
		add(item);
	}
	
	/**
	Removes and returns the first element in the Linked List
	@return the item that was removed from the List
	*/
	public E removeFirst()
	{
		E returner;
		//Makes sure the Linked List isn't empty
		if (head == null)
		{
			throw new NoSuchElementException("Linked List is empty");
		}
		returner = head.getItem();
		head = head.getNext();	
		size -= 1;
		if (size == 0)
			tail = null;
		return returner;
	}

	/**
	Removes the last object in the Linked List and returns it
	@return the item being removed
	*/
	public E removeLast()
	{
		//Makes sure the Linked List isn't empty
		if (head == null)
		{
			throw new NoSuchElementException("Linked List is empty");
		}
		return remove(size - 1);
	}	
}		
