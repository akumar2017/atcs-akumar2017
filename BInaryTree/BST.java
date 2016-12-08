/**
The Binary Search Tree Class can find a given item within the tree using a key
@author Akash Kumar
@version 12/10/16
*/
public class BST<E extends Comparable<E>>
{
	/**
	The first item added to the tree
	*/
	private BinaryTree<E> root; 
	
	/**
	Constructor for the BST class which sets the root to null
	*/
	public BST()
	{
		root = null;
	}
	
	/**
	Adds a new item to the BinaryTree, 
	@param item thing being added
	@return whether or not it was added and false if it already exists
	*/
	public boolean add(E item)
	{
		if (root == null)
		{	
			root = new BinaryTree<E>(item);
		}
		return add(item, root);
	}
	
	/**
	Recursive helper function for add. It uses compareTo to determine where the item being added should go.
	@param item thing being added
	@param tree tree to which the item is being added
	*/
	private boolean add(E item, BinaryTree<E> tree)
	{
		if (item.compareTo(tree.value()) > 0 && tree.right() == null)
		{
			tree.setRight(new BinaryTree<E>(item));
			return true;
		}

		if (item.compareTo(tree.value()) < 0 && tree.left() == null)
		{
			tree.setLeft(new BinaryTree<E>(item));
			return true;
		}

		if (item.compareTo(tree.value()) == 0)
		{
			return false;
		}

		if (item.compareTo(tree.value()) > 0)
		{
			return add(item, tree.right());
		}

		if (item.compareTo(tree.value()) < 0)
		{
			return add(item, tree.left());
		}
		return true;
	}
	
	/**
	Returns a string representation of the binary search tree
	@return string representation of the binary search tree
	*/
	public String toString()
	{
		return root.toString();
	}
	
	/**
	Finds and returns an item in the Binary Tree
	@param item item to be found
	@return the BinaryTree that contains the item	
	*/
	public BinaryTree<E> find(E item) 
	{
		return finderHelper(item, root);
	}
	
	/**
	Helper function for find to recursively compare the item to	the tree nodes until it finds where it should be
	@param item item to be found
	@return the tree where the item is held
	*/
	private BinaryTree<E> finderHelper(E item, BinaryTree<E> tree)
	{
		if (item.equals(tree.value()))
		{
			return tree;
		}

		if (item.compareTo(tree.value()) > 0 && tree.right() == null)
		{
			return null;
		}

		if (item.compareTo(tree.value()) < 0 && tree.left() == null)
		{
			return null;
		}

		if (item.compareTo(tree.value()) > 0)
		{
			return finderHelper(item, tree.right());
		}

		else
		{
			return finderHelper(item, tree.left());
		}
	}

	/**
	Tester for the Binary Search Tree class
	*/
	public static void main(String [] args)
	{
		BST<Integer> search = new BST<Integer>();
		search.add(2);
		search.add(6);
		search.add(9);
		System.out.println(search);
		System.out.println(search.find(6));
	}
}