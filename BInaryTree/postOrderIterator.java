import java.util.NoSuchElementException;
import java.util.Iterator;

/**
The postOrderIterator Class for BinaryTree. It goes through the binary tree using the Left, Right, Root algorithm in the constructor and places
the values in the correct order in a queue which gets iterated through.
@author Akash Kumar
@version 12/5/16
*/
public class postOrderIterator<E> implements Iterator<E>
{
	/**
	Queue that holds the final values for the iterator after it has gone through the BinaryTree
	*/
	private Queue<E> set;
	
	
	/**
	Constructor that calls sort automatically which means the sequence of values is determined in the constructor and placed in the queue
	@param head binary tree that is being iterated through
	*/
	public postOrderIterator(BinaryTree head)
	{
		set = new LinkedList<E>();
		sort(head);
	}
	
	/**
	Sorts through the Tree and places the values in a queue
	@param tree BinaryTree being sorted
	*/
	public void sort(BinaryTree<E> tree)
	{
		if (tree.left() != null)
			sort(tree.left());

		if (tree.right() != null)
			sort(tree.right());
		
		set.offer(tree.value());		
	}
	
	/**
	Determines whether or not the iterator has finished traversing the queue
	@return whether or not the iterator has finished traversing the Binary Tree
	*/
	public boolean hasNext()
	{
		return !(set.isEmpty());
	}
	
	/**
	Returns the next object in the queue (aka next object in the binary tree)
	@return next object in the queue
	*/
	public E next()
	{
		if (!hasNext())
		{
			throw new NoSuchElementException("End of Linked List");
		}
		return set.poll();
	}
}