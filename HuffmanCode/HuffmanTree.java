import java.util.PriorityQueue;
import java.util.HashMap;
/**
	This HuffmanTree class starts by making a map of the occurences of each letter in
	a given string. It uses that map to create HuffmanNodes for each letter and then it
	puts those nodes in a priority queue. It uses that to make the tree that will eventually solve
	the Huffman Code. To create the tree, it combines the first two nodes in the queue,	makes that
	the parent node of the two first nodes, and puts that parent node back into the queue. Once
	the tree is finished, it can be used to find letters given only bits of 0s and 1s.
	@author Akash Kumar
	@version 1/23/17
*/
public class HuffmanTree
{
	/**
		Top of my tree
	*/
	private HuffmanNode root;
	
	/**
		The phrase being encrypted
	*/
	private String phrase;
	
	/**
		Constructor that takes in string to encode
		@param input Message being encoded
	*/
	public HuffmanTree(String input)
	{
		phrase = input;
		root = createTree(createNodes(createMap(input)));
	}
	
	/**
		Default constructor that creates a default string to encode
	*/
	public HuffmanTree()
	{
		phrase = "the chicken crossed the road";
		root = createTree(createNodes(createMap(phrase)));
	}
	
	/**
		Creates and returns HashMap with occurrences of every letter
		@param input Message being encoded
		@return HashMap containing the letter and occurences
	*/
	private HashMap<String, Integer> createMap(String input)
	{
		HashMap<String, Integer> occur = new HashMap<String, Integer>();
		for (int i = 0; i < input.length(); i++)
		{
			if (occur.containsKey("" + input.charAt(i)))
			{
				occur.put("" + input.charAt(i),occur.get("" + input.charAt(i)) +1);
			}
			else
			{
				occur.put("" + input.charAt(i),1);
			}
		}
		return occur;
		
	}
	
	/**
		Creates HuffmanNodes from the HashMap and puts them into a Priority Queue
		@param occur HashMap with letters and occurences
		@return PriorityQueue with the HuffmanNodes
	*/
	private PriorityQueue<HuffmanNode> createNodes(HashMap<String,Integer> occur)
	{
		String[] keys = occur.keySet().toArray(new String[0]);
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>();
		for (int i = 0; i < keys.length; i++)
		{
			q.add(new HuffmanNode(occur.get(keys[i]), keys[i] ));
		}
		return q;
	}
	
	/**
		Uses the priority Queue with the HuffmanNodes in it to create the Huffman Tree.
		It polls and combines the first two nodes, makes that the parent node of the two
		first nodes, and puts that parent node back into the queue.
		@param q PriorityQueue that will be used to make the Tree
		@returns HuffmanNode root of the HuffmanTree created
	*/
	private HuffmanNode createTree(PriorityQueue<HuffmanNode> q)
	{
		while (q.toArray().length > 1)
		{
			HuffmanNode first = q.poll();
			HuffmanNode second = q.poll();
			HuffmanNode parent = new HuffmanNode(first.value() + second.value(), first.letters() + second.letters());
			parent.setLeft(first);
			parent.setRight(second);
			q.offer(parent);		
		}
		return q.poll();
	}
	
	/**
		Turns the input into a string of 1s and 0s based on binary tree
		@return String of bits
	*/
	public String encode()
	{
		String code = "";
		for (int i = 0; i < phrase.length(); i++)
		{
			code += findCode("" + phrase.charAt(i), root);
		}
		return code;
	}
	
	/**
		Recursive helper method to encode
		@param letter letter being converted to bits
		@param curr HuffmanNode where the code is focused
		@return String bit representation of the letter
	*/
	private String findCode(String letter, HuffmanNode curr)
	{
		if (curr.isLeaf())
		{
			return "";
		}
		if (curr.left().letters().contains(letter))
		{
			return "0" + findCode(letter, curr.left());
		}
		else
		{
			return "1" + findCode(letter,curr.right());
		}
		
	}
	
	/**
		Turns string of bits into letters
		@param bits The string of 0s and 1s
		@return the phrase
	*/
	public String decode(String bits)
	{
		return decodeHelper(bits, root);
	}
	
	/**
		Recursive helper function that turns bits into letters
		@param bits The string of 0s and 1s
		@param curr The huffman node that it is currently on
		@return String original phrase of letters
	*/
	private String decodeHelper(String bits, HuffmanNode curr)
	{
		if (curr.isLeaf())
		{
			if (bits.length() > 0)
			{
				return curr.letters() + decodeHelper(bits, root);
			}
			else
				return curr.letters();		
		}
		else if (("" + bits.charAt(0)).equals("0"))
		{
			return decodeHelper(bits.substring(1), curr.left());
		}
		else
		{
			return decodeHelper(bits.substring(1), curr.right());
		}
	}
}