/**
ListNode class contains an value that is stored and a pointer to another ListNode. These nodes can be linked together in a LinkedList
@author Akash Kumar
@version 10/25/16
*/
public class ListNode<E>
{
	/**
	The value that the ListNode holds
	*/
	private E item;
	
	/**
	The next ListNode that this one will point to
	*/
	private ListNode<E> next;
	
	/**
	Constructor for ListNode that takes in a value to hold and another ListNode that it will point to
	@param obj the value the ListNode will hold, n the pointer to the ListNode
	@param pointer The next ListNode this one will point to
	*/
	public ListNode(E obj, ListNode<E> n)
	{
		item = obj;
		next = n;
	}
	
	/**
	Constructor for ListNode that takes in a value to hold, but no ListNode to point to
	@param object The value the ListNode will hold
	*/
	public ListNode(E item)
	{
		this(item, null);
	}
	
	/**
	Returns the value contained in the ListNode
	@return The value it holds
	*/
	public E getItem()
	{
		return item;
	}
	
	/**
	Returns the pointer to the next ListNode
	@return next ListNode
	*/
	public ListNode<E> getNext()
	{
		return next;
	}
	
	/**
	Sets the object that the ListNode holds to a given value
	@param obj the new value for the ListNode to hold	
	*/
	public void setItem(E obj)
	{
		item = obj;
	}
	
	/**
	Sets the next ListNode that this ListNode will point to
	@param pointer The new ListNode for this ListNode to point to
	*/
	public void setNext(ListNode<E> node)
	{
		next = node;
	}
	
	/**
	Creates a String representation of the ListNode
	@return the String representation of the ListNode
	*/
	public String toString()
	{
		if (item != null)
			return item.toString();
		return "null";
	}
}
