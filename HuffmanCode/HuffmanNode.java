import java.lang.Iterable;
import java.util.Iterator;
/**
	The Huffman Node class is a node of a Tree that has points to left and right subtrees.
	It holds a value and letters. This class has accessors, modifiers and functions that
	return information about the tree
	@author Akash Kumar
	@version 1/23/17
*/
public class HuffmanNode implements Comparable<HuffmanNode>
{
	/**
		Value held in this node
	*/
	protected int value;
	
	/**
		Letters held in this node
	*/
	protected String letters;
	
	/**
		Pointer to the left branch subtree
	*/
	protected HuffmanNode left;
	
	/**
		Pointer to the right branch subtree
	*/
	protected HuffmanNode right;
	
	/**
		Constructor that creates a new Binary Tree with given values
		@param v Value of this node of the tree
		@param l Left branch
		@param r Right branch
	*/
	public HuffmanNode(Integer v, HuffmanNode l,HuffmanNode r)
	{
		value = v;
		left = l;
		right = r;
	}
	
	/**
		Overrides the Comparable Class to be used in the Priority Queue
	*/
	public int compareTo(HuffmanNode other)
	{
		return value - other.value;
	}
	
	/**
		Constructor that creates a new Binary Tree with a stored value but not right or left branch
		@param v The value stored by this node
	*/
	public HuffmanNode(int v)
	{
		this(v, null, null);
	}
	
	/**
		Constructor for HuffmanNode that takes in a value and letters
		@param v Value
		@param s Letters
	*/
	public HuffmanNode(int v, String s)
	{
		value = v;
		letters = s;
	}
	
	/**
		Constructor that calls the first Constructor with all null values
	*/
	public HuffmanNode()
	{
		this(null, null, null);
	}
	
	/**
		Returns the letters that the node holds
		@return letters
	*/
	public String letters()
	{
		return letters;
	}
	
	/**
		Returns the left branch of the tree
		@return left branch of the tree
	*/
	public HuffmanNode left()
	{
		return left;
	}
	
	/**
		Returns the right branch of the tree
		@return right branch of the tree
	*/
	public HuffmanNode right()
	{
		return right;
	}
	
	/**
		Returns the value this node of the tree holds
		@return value this node of the tree holds
	*/
	public int value()
	{
		return value;
	}
	
	/**
		Sets the left branch of the tree to a new Binary Tree
		@param new Tree
	*/
	public void setLeft(HuffmanNode t)
	{
		left = t;
	}
	
	/**
		Sets the right branch of the tree to a new Binary Tree
		@param new Tree
	*/
	public void setRight(HuffmanNode t)
	{
		right = t;
	}
	
	/**
		Sets the value that this tree node is holding
		@param new value
	*/
	public void setValue(int v)
	{
		value = v;
	}
	

	/**
		Determines whether or not the tree is a leaf
		@return Whether or not it is a leaf
	*/
	public boolean isLeaf()
	{
		return (left == null && right == null);			
	}
	
	/**
		Returns a string representation of the binary tree
		@return String representation of the binary tree
	*/
	public String toString()
	{
		if (isLeaf())
		{		
			return  "" + letters + " : " +  value;
		}
		if (left == null)
			return letters + " : " + value + "(" + "EMPTY, " + right.toString() + ")";
		else if (right == null)
			return  letters + " : " + value + "(" + left.toString() + ", EMPTY" + ")";
		else
			return  letters + " : " + value + "(" + left.toString() + ", " + right.toString() + ")";
	}
}