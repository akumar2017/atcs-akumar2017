/**
The Queue interface is a data structure where objects are added to the end and taken from the beginning.
@author Akash Kumar
@version 10/14/16
*/

public interface Queue<E>
{
	/**
	Adds a new item to the end of the queue
	@param item the object being added
	*/
	void offer(E item);

	/**
	Removes and returns the first item in the queue
	@return the value of the first item
	*/	
	E poll();

	/**
	Returns the object held in the beginning of the queue
	@return the object held in the beginning of the queue
	*/
	E peek();

	/**
	Returns whether or not the queue is empty
	@return Whether or not the queue is empty
	*/
	boolean isEmpty();

	/**
	Returns a string representation of the queue
	@return A string representation of the queue
	*/
	String toString();
}