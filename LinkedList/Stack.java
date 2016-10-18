/**
The Stack interface is a data structure where objects are added	to the top and taken from the top.
@author Akash Kumar
@version 10/20/16
*/

public interface Stack<E>
{
	/**
	Adds a new item to the top of the stack
	@param item the object being added
	*/
	void push(E item);
	
	/**
	Removes and returns the first item in the Stack
	@return the value of the first item
	*/	
	E pop();
	
	/**
	Returns the object held on the top of the stack
	@return the object on the top of the stack
	*/
	E peek();
	
	/**
	Returns whether or not the stack is empty
	@return Whether or not the stack is empty
	*/
	boolean isEmpty();
	
	/**
	Returns a string representation of the stack
	@return A string representation of the stack
	*/
	String toString();
}