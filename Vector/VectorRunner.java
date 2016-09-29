/**
	Vector Runner class to test the Vector program
	@version 9/28/16
	@author Akash Kumar
*/
public class VectorRunner
{
	public static void main(String [] args)
	{
		/*
		Testing add, remove, toString and contains methods
			- adds 5 4 3 2 1 and then removes the element in position 1 (4)
			- Prints a (should be 5 3 2 1)
			- Prints a with toString which should give same result
			- Checks if a contains 3 (should return true)
		*/
		Vector<Integer> a = new Vector<Integer>();
		a.add(5);
		a.add(4);
		a.add(3);
		a.add(2);
		a.add(1);
		a.remove(1);
		System.out.println(a);
		System.out.println(a.toString());
		System.out.println(a.contains(3));

		/*
		Testing add, hasNext, remove, set, indexOf
			- adds abcdefghijkl and prints
			- tests hasNext (should return true)
			- removes elements at position 0 (a should be removed)
			- sets "x" at new positon 0 (b should be replaced by x)
			- Asks for indexOf w which doesnt exist (should return -1)
			- Asks indexOf f (should return 4)
			- Tries to remove w which doesn't exist (should return false)
			- Removes h from the list (should return true)
			- Prints new list (should be xcdefgijkl)
		*/
		Vector<String> v = new Vector<String>();
		v.add("a");
		v.add("b");
		v.add("c");
		v.add("d");
		v.add("e");
		v.add("f");
		v.add("g");
		v.add("h");
		v.add("i");
		v.add("j");
		v.add("k");
		v.add("l");

		System.out.println(v);
		VectorIterator<String> i = new VectorIterator<String>(v);
		System.out.println(i.hasNext());

		v.remove(0);
		System.out.println(v.set(0,"x"));
		System.out.println(v.indexOf("w"));
		System.out.println(v.indexOf("f"));
		System.out.println(v.remove("w"));
		System.out.println(v.remove("h"));
		System.out.println(v);

		/*
		Testing add with index parameter, increaseCapacity, get, size, indexOf, remove and clear
			- first creates a new Vector of String type with certain size and adds elements at certain indices and prints it (should be null null a b c z d a b c z d a b c z d)
				- I go over the size of the vector but it doesn't crash which shows that increaseCapacity works
			- Prints what is stored at the position of size - 1 (should be d)
			- Gets what is at position 0 (should return null)
			- Prints the indexOf(null) (should return 0)
			- Removes what is at position 0 (should return null)
			- Removes null (should return true)
			- Prints current v1 (should be a b c z d a b c z d a b c z d)
			- Removes what is at position 5 using Integer and prints new vector (should be a b c z d b c z d a b c z d)
			- Clears v1 and then prints (should be empty line)
			- Creates a new v2 equal to the old vector v and adds z before printing (should be x c d e f g i j k l z)
		*/
		Vector<String> v1 = new Vector<String>(10);
		v1.add(0,"d");
		v1.add(0,"c");
		v1.add(0,"b");
		v1.add(0,"a");
		v1.add(3,"z");
		v1.add(0,"d");
		v1.add(0,"c");
		v1.add(0,"b");
		v1.add(0,"a");
		v1.add(3,"z");
		v1.add(0,"d");
		v1.add(0,"c");
		v1.add(0,"b");
		v1.add(0,"a");
		v1.add(3,"z");
		v1.add(0,null);
		v1.add(0,null);
		System.out.println(v1);
		System.out.println(v1.get(v1.size()-1));
		System.out.println(v1.get(0));
		System.out.println(v1.indexOf(null));
		System.out.println(v1.remove(0));
		System.out.println(v1.remove(null));
		System.out.println("v1: " + v1);
		v1.remove(new Integer(5));
		System.out.println("v1: " + v1);
		v1.clear();
		System.out.println(v1);
		Vector<String> v2 = new Vector<String>(v);
		v2.add("z");
		System.out.println(v2);

		/*
		Testing various exceptions with try and catch and isEmpty method
			- First catch makes sure you do not create an empty vector
			- Second catch makes sure you do not create a null vector
			- Creates a tester vector of size two and adds "apple" null "orange" null null
			- Tries adding null to -1 position to catch Index Out of Bounds
			- Adds "chicken" "shrimp" null and then tries to add null to position 9 to catch another Index Out of Bounds
			- Adds "eggs" to the tester vector and creates the vector tester2 equal to tester
			- Prints tester2 (should be apple null orange null null chicken shrimp null eggs)
			- Adds 0 to the null position of tester and prints it (should be null apple null orange null null chicken shrimp null eggs)
			- Gets what is at position 0 of tester (should return null)
			- Tries to get what is at position 10 (which does not exist) to catch Index Out of Bounds
			- Tries to get what is at position -1 (which does not exist) to catch Index Out of Bounds
			- Gets what is at position 4 (should return null)
			- Removes what is at position 0 (should return null)
			- Removes what is at position 3 (should return null)
			- Prints new tester vector (should be apple null orange null chicken shrimp null eggs)
			- Tries to get what is at position -1 (which does not exist) to catch Index Out of Bounds
			- Tries to get what is at position 8 (which does not exist) to catch Index Out of Bounds
			- Prints the same tester vector again for reference (should be apple null orange null chicken shrimp null eggs)
			- Removes the first two null positions (should return true twice)
			- Tries to remove "cheese" which does not exist (should return false)
			- Removes "apple" (should return true)
			- Prints new tester vector (should be orange chicken shrimp null eggs)
			- Clears the tester and sets new vector tester3 equal to tester
			- Prints tester3 (should be empty line)
			- Checks if tester3 isEmpty (should return true)
		*/
		try
		{
			Vector<String> tester = new Vector<String>(0);
		}

		catch (IllegalArgumentException e)
		{
			System.out.println("Caught Illegal Argument 1");
		}

		try
		{
			Vector<String> tester = new Vector<String>(null);
		}

		catch (IllegalArgumentException e)
		{
			System.out.println("Caught Illegal Argument 2");
		}

		Vector<String> tester = new Vector<String>(2);
		tester.add("apple");
		tester.add(null);
		tester.add("orange");
		tester.add(null);
		tester.add(null);
		try
		{
			tester.add(-1, null);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Caught Index out of Bounds 1");
		}
		tester.add("chicken");
		tester.add("shrimp");
		tester.add(null);
		try
		{
			tester.add(9, null);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Caught Index out of Bounds 2");
		}
		tester.add("eggs");
		Vector<String> tester2 = new Vector<String>(tester);
		System.out.println(tester2);
		tester.add(0, null);
		System.out.println(tester);
		System.out.println(tester.get(0));
		try
		{
			tester.get(10);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Caught Index out of Bounds 3");
		}
		try
		{
			tester.get(-1);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Caught Index out of Bounds 4");
		}
		System.out.println(tester.get(4));
		System.out.println(tester.remove(0));
		System.out.println(tester.remove(3));
		System.out.println(tester);
		try
		{
			tester.remove(-1);
		}
		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Caught Index out of Bounds 5");
		}
		try
		{
			tester.remove(8);
		}

		catch (IndexOutOfBoundsException e)
		{
			System.out.println("Caught Index out of Bounds 6");
		}
		System.out.println();
		System.out.println(tester);
		System.out.println(tester.remove(null));

		System.out.println(tester.remove(null));

		System.out.println(tester.remove("cheese"));

		System.out.println(tester.remove("apple"));

		System.out.println(tester);

		tester.clear();

		Vector<String> tester3 = new Vector<String>(tester);

		System.out.println(tester3);

		System.out.println(tester.isEmpty());

	}
}
