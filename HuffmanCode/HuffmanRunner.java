/**
	Runner to test the HuffmanNode and HuffmanTree classes
	@author Akash Kumar
	@version 1/23/17
*/
public class HuffmanRunner
{
	public static void main(String[] args)
	{
		HuffmanTree tree = new HuffmanTree();
		String bits = tree.encode();
		System.out.println("Decoded: " + tree.decode(bits));
	}
}