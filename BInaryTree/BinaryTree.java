import java.lang.Iterable;
import java.util.Iterator;
/**
The BinaryTree class is a node of a Tree Structure. The node has a left and right subtree and also holds a value.
@author Akash Kumar
@version 12/7/16
*/
public class BinaryTree<E> implements Iterable<E>
{
	/**
	Value held in this node of the tree
	*/
	protected E value;
	
	/**
	Pointer to the left branch subtree
	*/
	protected BinaryTree<E> left;
	
	/**
	Pointer to the right branch subtree
	*/
	protected BinaryTree<E> right;
	
	/**
	Constructor that creates a new BinaryTree with given values
	@param v value of this node of the tree
	@param l left branch
	@param r right branch
	*/
	public BinaryTree(E v, BinaryTree<E> l, BinaryTree<E> r)
	{
		value = v;
		left = l;
		right = r;
	}
	
	/**
	Constructor that creates a new BinaryTree with a stored value but no left or right branch
	@param v value stored by this node
	*/
	public BinaryTree(E v)
	{
		this(v, null, null);
	}
	
	/**
	Constructor that calls the first constructor with all null values
	*/
	public BinaryTree()
	{
		this(null, null, null);
	}
	
	/**
	Returns the left branch of the tree
	@return left branch of the tree
	*/
	public BinaryTree<E> left()
	{
		return left;
	}
	
	/**
	Returns the right branch of the tree
	@return right branch of the tree
	*/
	public BinaryTree<E> right()
	{
		return right;
	}
	
	/**
	Returns the value this node of the tree is holding
	@return value this node of the tree is holding
	*/
	public E value()
	{
		return value;
	}
	
	/**
	Determines whether or not this tree is a leaf (which means it has no subtrees)
	@return whether or not it is a leaf
	*/
	public boolean isLeaf()
	{
		return (left == null && right == null);			
	}
	
	/**
	Sets the left branch of the tree to a new Binary Tree
	@param new Tree
	*/
	public void setLeft(BinaryTree t)
	{
		left = t;
	}
	
	/**
	Sets the right branch of the tree to a new Binary Tree
	@param new Tree
	*/
	public void setRight(BinaryTree t)
	{
		right = t;
	}
	
	/**
	Sets or changes the value that this node is holding
	@param new value
	*/
	public void setValue(E v)
	{
		value = v;
	}
	
	/**
	Return the maximum path length to a leaf from this node in the tree
	@return longest route to a leaf
	*/		
	public int height()
	{
		if (isLeaf())
		{
			return 0;
		}

		if (left == null)
			return (1 + right.height());

		else if (right == null)
			return (1 + left.height());

		else
			return 1 + Math.max(left.height(), right.height());
	}
	
	/**
	Returns the total number of subtrees of this node including the current one
	@return total number of subtrees
	*/
	public int size()
	{
		if (isLeaf())
		{
			return 1;
		}	

		if (left == null)
			return (1 + right.size());

		else if (right == null)
			return (1 + left.size());

		else
			return (1 + left.size() + right.size());
	}
	
	/**
	Returns true if adding a node would increase its height.
	@return whether or not the tree is full
	*/
	public boolean isFull()
	{
		if ((left == null && right != null) || (right == null && left != null))
		{
			return false;
		}

		if (isLeaf())
		{
			return true;
		}

		if (left.height() != right.height())
		{
			return false;
		}

		else
			return (left.isFull() && right.isFull());
	}
	
	/**
	Returns a string representation of the binary tree
	@return string representation of the binary tree
	*/
	public String toString()
	{
		if (isLeaf())
		{		
			return  "" + this.value();
		}

		if (left == null)
			return value + "(" + "EMPTY, " + right.toString() + ")";

		else if (right == null)
			return  this.value + "(" + left.toString() + ", EMPTY" + ")";

		else
			return  this.value + "(" + left.toString() + ", " + right.toString() + ")";
	}
	
	/**
	Returns true if the difference of heights of subtrees at every node is not more than one.
	@return whether or not the tree is balanced 
	*/
	public boolean isBalanced()
	{

		if (isLeaf())
		{
			return true;
		}

		if (!(right.height() - left.height() < 2 && right.height() - left.height() > -2))
			return false;

		return left.isBalanced() && right.isBalanced();
	}
	
	/**
	Returns true if tree has minimal height and any holes appear in the last level to the right.
	@return if the tree is complete
	*/
	public boolean isComplete()
	{
		if (isLeaf())
		{
			return true;
		}

		if (left == null)
			return false;

		if (right == null)
			return left.height()== 0;

		if (left.height() - right.height() == 1)
		{
			if (left.isComplete() && right.isFull())
			{
				return true;
			}
		}

		else if (left.height() - right.height() == 0)
		{
			if (left.isFull() && right.isComplete())
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	Creates a new Iterator that goes through the binary tree using the Left, Root, Right algorithm.
	@return a new inOrderIterator
	*/
	public inOrderIterator<E> inOrderIterator()
	{
		return new inOrderIterator<E>(this);
	}
	
	/**
	Creates a new Iterator that goes through the binary tree using the Root, Left, Right algorithm.
	@return a new preOrderIterator
	*/
	public preOrderIterator<E> preOrderIterator()
	{
		return new preOrderIterator<E>(this);
	}
	
	/**
	Creates a new Iterator that goes through the Binary tree using the Left, Right, Root algorithm.
	@return a new postOrderIterator
	*/
	public postOrderIterator<E> PostOrderIterator()
	{
		return new postOrderIterator<E>(this);
	}
	
	/**
	Chooses one of the preceding iterators to return. (required because this class implements iterable)
	@return a new inOrderIterator
	*/
	public inOrderIterator<E> iterator()
	{
		return new inOrderIterator<E>(this);
	}	
}