import java.io.*;
import java.util.Scanner;
import java.lang.String;

public class Netflix
{
	public String[] names; 
	public Vector<Vector> master; 
	public Vector<Integer> scores; 
	public int user = 35;

	public static void main(String[] args)
	{
		Netflix list = new Netflix();
		list.compatability();
		Vector<String> recomendations = new Vector<String>();
		while(recomendations.size() < 3)
		{
			int check = list.getMostCompatible();
			for (int i = 0; i < (list.haveNotWatched(check)).size() && i < 3; i++)
			{
				recomendations.add(list.names[list.haveNotWatched(check).get(i)]);
			}
		}
		System.out.println(recomendations.toString());
	}
	
	public Netflix()
	{
		master = null;
		scores = null;
		readCSV();	
	}
	
	public void readCSV()
	{
		String pathname = "Sheet1.csv";
		File file = new File(pathname);	
		Scanner input = null;
		try
		{
			input = new Scanner(file);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(" Cannot open " + pathname );
			System.exit(1);
		}
		 
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
	
	public void compatability()
	{
		scores = new Vector<Integer>(); 
		Vector<Integer> person = master.get(user);
		for(int k = 0; k < master.size(); k++)
		{
			int score = 0;
			Vector<Integer> check = master.get(k);
			System.out.println(k);
			for(int a = 0; a < check.size(); a++)
			{
				score += alterRatings(person.get(a)) * alterRatings(check.get(a)); 
			}
			scores.add(score);
		}  	
	}
	
	public int getMostCompatible()
	{
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
	
	public Vector<Integer> haveNotWatched(int indx)
	{
		Vector<Integer> arr = new Vector<Integer>();
		for(int i = 0; i < master.get(indx).size(); i++)
		{
			int score = (int)((master.get(user)).get(i));
			int score2 = (int)((master.get(indx)).get(i));
			if(score == 0 && score2 == 5)
			{
				arr.add(i);	
			}	
		}
		return arr;
	}
	
}
