import java.util.Scanner;
import java.io.*;
/**
@author Akash Kumar
@version 12/15/16
*/
public class Questions
{
	/**
	The Binary Tree in which all the questions and answers are stored
	*/
	private BinaryTree<String> tree;

	/**
	The string of all the nodes of the tree
	*/
	private String values;
	
	/**
	Constructor for Questions either populates the binary tree from the save file or, if it is empty, initializes the tree
	*/
	public Questions()
	{
		tree = new BinaryTree<String>();
		readFile();
		if (tree.size() == 1)		
		{
		
			tree.setValue("Is it Alive");
			tree.setLeft(new BinaryTree<String>("Computer"));
			tree.setRight(new BinaryTree<String>("Human"));
		}
	}
	
	/**
	This function contains a while loop that keeps the game running
	*/
	public void play()
	{
		String yesno = "yes";
		while (yesno.equals("yes"))
		{
			run(tree);
			System.out.println("Play Again?");
			Scanner input = new Scanner(System.in);
			yesno = input.nextLine();
		}
		save();
	}
	
	/**
	Populates the binary tree with questions from the String values that was read from the file
	@param b BinaryTree that a value is being worked on
	@return whether or not populating was a success
	*/
	private boolean populate(BinaryTree<String> b)
	{
		String s = "";
		if (values.length() == 0)
		{
			return true;
		}

		if (values.charAt(0) == 41)
		{
			values = values.substring(1);
			return populate(b);
		}

		if (values.charAt(0) == 40)
		{
			values = values.substring(1);
			int i = 0;
			while (values.substring(i, i+1).equals(",") == false && values.substring(i, i+1).equals("(") == false && values.substring(i, i+1).equals(")") == false)
			{
				s = s + values.charAt(i);
				i++;
			}
			b.setLeft(new BinaryTree<String>(s));
			values = values.substring(i);
			if (values.charAt(0) == 40)
			{
				populate(b.left());
			}
			populate(b);
		}
		s="";
		if (values.charAt(0) == 44)
		{
			values = values.substring(1);
			int i = 0;
			while (values.substring(i, i+1).equals(")") == false && values.substring(i, i+1).equals("(") == false && values.substring(i, i+1).equals(")") == false)
			{
				s = s + values.charAt(i);
				i++;
			}
			b.setRight(new BinaryTree<String>(s));
			values = values.substring(i);
			if (values.charAt(0) == 40)
			{
				populate(b.right());
			}
		}
		return true;
	}
	
	/**
	Parses through the text file and converts it all into the String values
	*/
	private void readFile()
	{
		File file = new File("helper.txt");	
		Scanner input = null;
		try
		{
			input = new Scanner(file);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(" Cannot open " + "helper.txt" );
			System.exit(1);
		}
		String s = "";
		while (input.hasNext())
		{
			s = input.nextLine();
		}
		if (s.length() > 0 )
		{
			int i = 0;
			while ( s.charAt(i) != 40 )
			{
				i++;
			}
			String head = s.substring(0,i);
			s = s.substring(i);
			tree.setValue(head);
			values = s;
			populate(tree);
		}
	}
	
	/**
	Runs the game by asking the user questions and navigating the tree according to the answers
	until it gets to a final answer
	@param curr Binary Tree that contains the question or answer to be presented
	@return whether or not the run was successful 
	*/
	public boolean run(BinaryTree<String> curr)
	{
		if (curr.isLeaf())
		{
			System.out.println("Is it a " + curr.value());
			learn(curr);
			return true;
		}
		System.out.println(curr.value());
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();
		if (answer.equals("yes"))
		{
			run(curr.right());
		}
		else
		{
			run(curr.left());
		}
		return true;
	}
	
	/**
	Copies the Binary Tree to the helper text file
	*/
	public void save()
	{
		String s = tree.toString();
		
		PrintWriter outputFile;
  		
  		try
  		{
  			outputFile = new PrintWriter(new FileWriter("helper.txt"));
            outputFile.println(s);
            outputFile.close();
    	}
    	catch(IOException e)
		{
			System.out.println("Error creating file");
			System.exit(1);
		}
	}
	
	/**
	If wrong, it learns the correct answer and a question that can differentiate it from the one it gave and changes the tree
	@param curr node of the tree with the incorrect answer
	*/
	private void learn(BinaryTree<String> curr)
	{
		System.out.println("Is the answer correct?");
		Scanner input = new Scanner(System.in);
		String correct = input.nextLine();
		if (correct.equals("no"))
		{
			curr.setLeft(new BinaryTree<String>(curr.value()));
			System.out.println("What were you thinking of?");
			input = new Scanner(System.in);
			String answer = input.nextLine();
			curr.setRight(new BinaryTree<String>(answer));
			System.out.println("What is a question that could differentiate your answer from the one I gave?");
			input = new Scanner(System.in);
			String question = input.nextLine();
			curr.setValue(question);
		}	
	}	
}