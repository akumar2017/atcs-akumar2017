/**
Netflix class to recommend shows/movies to users based on Approach B
@version 10/9/16
@author Akash Kumar
*/
import java.io.*;
import java.util.Scanner;
import java.lang.String;

public class Netflix
{
	//Initializes String and Vectors
	public String[] names; 
	public Vector<Vector> master; 
	public Vector<Integer> scores;
	//Sets user 27 to receive recommendations (can be adjusted to whatever you want)
	public int user = 27;
	
	public static void main(String[] args)
	{
		Netflix list = new Netflix();
		list.compatibility();
		Vector<String> recommendations = new Vector<String>();
		//Adds highest rated things from most compatible user that have not been watched
		while(recommendations.size() < 3)
		{
			int check = list.getMostCompatible();
			for (int i = 0; i < (list.haveNotWatched(check)).size() && i < 3; i++)
			{
				recommendations.add(list.names[list.haveNotWatched(check).get(i)]);
			}
		}
		//Prints recommendations
		System.out.println(recommendations.toString());
	}
	
	/**
	Constructor that sets variables to null initially and reads CSV file
	*/
	public Netflix()
	{
		master = null;
		scores = null;
		readCSV();	
	}
	
	/**
	Reads Sheet1.CSV file and adds data to Vectors
	*/
	public void readCSV()
	{
		String pathname = "Sheet1.csv";
		File file = new File(pathname);	
		Scanner input = null;
		//try and catch to check if file is found
		try
		{
			input = new Scanner(file);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(" Cannot open " + pathname );
			System.exit(1);
		}
		//Splits data by commas and adds them to vectors
		names = input.nextLine().split(",");
		String[] arr2;
		master = new Vector<Vector>();

		while(input.hasNextLine())
		{
			Vector<Integer> rate = new Vector<Integer>();
			arr2 = input.nextLine().split(",");
			for(int place = 0; place < arr2.length; place++)
			{
				rate.add(Integer.parseInt(arr2[place]));
			}
			master.add(rate);	 		
		}
	}
	
	/**
	Changes ratings of 0-5 to ratings I want
	@param int num that is the rating from the file
	@return int that is the new converted rating
	*/
	public int alterRatings(int num)
	{
		if(num == 1)
		{
			return -5;
		}
		
		else if(num == 2)
		{
			return -3;
		}
		
		else if(num == 3)
		{
			return 1;
		}
		
		else if(num == 4)
		{
			return 3;
		}
		
		else if(num == 5)
		{
			return 5;
		}
		
		else if(num == 0)
		{
			return 0;
		}
		return 0;
	}
	
	/**
	Checks the compatibility between two users
	*/
	@SuppressWarnings("unchecked")
	public void compatibility()
	{
		//creates a integer Vector for compatibility scores
		scores = new Vector<Integer>();
		//creates a integer vector for the user that is getting recommendations
		Vector<Integer> person = master.get(user);
		//Checks compatibility with every other user in the file
		for(int k = 0; k < master.size(); k++)
		{
			int score = 0;
			Vector<Integer> check = master.get(k);
			//System.out.println(k); (for testing)
			//Approach B way of checking compatibility
			for(int a = 0; a < check.size(); a++)
			{
				score += alterRatings(person.get(a)) * alterRatings(check.get(a));
			}
			scores.add(score);
		}  	
	}
	
	/**
	Gets the most compatible user to the user getting recommendations
	@return int of the most compatible user
	*/
	public int getMostCompatible()
	{
		//Parses through compatibility scores Vector for highest score
		int most = 0;

		for(int i = 1; i < scores.size(); i++)
		{
			if(scores.get(i) > most)
			{
				most = i;
			}
		}

		int minValue = Integer.MIN_VALUE;
		scores.set(most, minValue);
		return most;
	}
	
	/**
	Returns the haveNotWatched Vector for a particular user
	@param int index of user
	@return Vector<Integer> of unwatched material
	*/
	public Vector<Integer> haveNotWatched(int index)
	{
		Vector<Integer> arr = new Vector<Integer>();

		for(int i = 0; i < master.get(index).size(); i++)
		{
			int score = (int)((master.get(user)).get(i));
			int score2 = (int)((master.get(index)).get(i));
			if(score == 0 && score2 == 5)
			{
				arr.add(i);
			}	
		}

		return arr;
	}
}
