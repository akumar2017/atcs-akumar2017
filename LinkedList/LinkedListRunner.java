/**
The LinkedListRunner class tests code in the Linked List class
@author Akash Kumar
@version 10/25/16
*/
public class LinkedListRunner
{
	public static void main(String [] args)
	{	
		LinkedList<String> v = new LinkedList<String>();
		/*
		Should print One Two Six null Four Seven Five
		Should print IndexOfNullThere 3
		Should print Get: null
		Should print list again then remove null
		Should remove One, return true and print list without One
		Should return -1 because null doesn't exist
		Should set index 0 (Two) to New and print New Six Four Seven Five
		Should print Contains: false because Three isn't in the list
		Should print Contains: true because Four is in the list
		Should print isEmpty: false because the list isn't empty
		Should clear the List and then print isEmpty: true becasuse the list is now empty
		Should add One and print it
		Should add Two and print OneTwo
		Creates a new LinkedList n and sets it equal to Linked List v and prints both
		Adds Three to N and prints One Two Three
		Should print V which should just say One Two
		Should print Each item: One, Each item: Two and Each item: Three
		Should print Poll: One followed by Two Three Four
		Should print Peek: Two followed by Two Three Four
		Should print Peek: Five followed by Five Four Three Two One
		Should print Pop: Five followed by Four Three Two One
		*/
		v.add("One");
		v.add("Two");
		v.add(null);
		v.add("Four");
		v.add("Five");
		v.add(2,"Six");
		v.add(5,"Seven");
		System.out.println(v);
		System.out.println("IndexOfNullThere " + v.indexOf(null));
		System.out.println("Get " + v.get(3));
		System.out.println(v);
		System.out.println("RemoveIndex: " + v.remove(3));
		System.out.println(v);
		System.out.println("RemoveValue: " + v.remove("One"));
		System.out.println(v);	
		System.out.println("IndexOfNullNotThere " + v.indexOf(null));
		System.out.println(v);
		System.out.println("Set: " + v.set(0, "New"));
		System.out.println(v);
		System.out.println("Contains: " + v.contains("Three"));
		System.out.println(v);
		System.out.println("Contains: " + v.contains("Four"));
		System.out.println(v);
		System.out.println("isEmpty: " + v.isEmpty());
		System.out.println(v);
		System.out.println("clear: ");
		v.clear();
		System.out.println(v);
		System.out.println("isEmpty: " + v.isEmpty());
		System.out.println(v);
		v.add("One");
		System.out.println("Another 1: ");
		System.out.println(v);
		v.add("Two");
		System.out.println("Another 2: ");
		System.out.println(v);
		LinkedList<String> n = new LinkedList<String>(v);
		System.out.println("N:");
		System.out.println(n);
		System.out.println("V:");
		System.out.println(n);
		n.add("Three");
		System.out.println("N after adding Three:");
		System.out.println(n);
		System.out.println("The same V:");
		System.out.println(v);
		
		for (String iter : n)
		{
			System.out.println("Each item: " + iter);
		}
		System.out.println("\n");
		

		Queue<String> q = new LinkedList<String>();
		q.offer("One");
		q.offer("Two");
		q.offer("Three");
		q.offer("Four");
		System.out.println("Poll: " + q.poll());
		System.out.println(q);
		System.out.println("Peek: " + q.peek());
		System.out.println(q);
		
		Stack<String> s = new LinkedList<String>();
		s.push("One");
		s.push("Two");
		s.push("Three");
		s.push("Four");
		s.push("Five");
		System.out.println("Peek: " + s.peek());
		System.out.println(s);
		System.out.println("Pop: " + s.pop());
		System.out.println(s);
	}
}