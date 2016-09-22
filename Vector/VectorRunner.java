public class VectorRunner
{
	public static void main(String [] args)
	{
		
		Vector<Integer> a = new Vector<Integer>();
		a.add(5);
		a.add(4);
		a.add(3);
		a.add(2);
		a.add(1);
		a.remove(1);
		System.out.println(a);
		Vector<String> v = new Vector<String>();
		v.add("a");
		v.add("b");
		v.add("c");
		v.add("d");
		v.add("a");
		v.add("b");
		v.add("c");
		v.add("d");
		v.add("a");
		v.add("b");
		v.add("c");
		v.add("d");

		//for(String s : v)
		//	System.out.println(s);

		System.out.println(v);
		VectorIterator<String> i = new VectorIterator<String>(v);
		System.out.println(i.hasNext());

		//for(int x = 0;x < 100; x++)
		//{
		//	System.out.println(i.next());
		//}

		v.remove(0);
		System.out.println(v.set(0,"x"));
		System.out.println(v.indexOf("w"));
		System.out.println(v.remove("w"));
		System.out.println(v.remove("r"));
		System.out.println(v);
		Vector<String> v1 = new Vector<String>(10);
		v1.add(0,"d");
		v1.add(0,"c");
		v1.add(0,"b");
		v1.add(0,"a");
		v1.add(3,"s");
		v1.add(0,"d");
		v1.add(0,"c");
		v1.add(0,"b");
		v1.add(0,"a");
		v1.add(3,"s");
		v1.add(0,"d");
		v1.add(0,"c");
		v1.add(0,"b");
		v1.add(0,"a");
		v1.add(3,"s");
		v1.add(0,null);
		v1.add(0,null);
		System.out.println(v1.get(v1.size()-1));
		System.out.println(v1);
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
		Vector<String> v3 = new Vector<String>(10);
		Vector<String> v4 = new Vector<String>(v3);
		v2.add("z");
		System.out.println(v2);
		//v2.add(-1,"s");
		//v2.add(100, "s");
		//v2.get(-2);
		//v2.get(100);
		//v2.remove(100);
		//v2.remove(-3);
		//v2.set(-4, "s");
		//v2.set(100, "s");
		//System.out.println(v2);
		
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