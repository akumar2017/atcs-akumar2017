public class Pair<E>
{ 
	private E obj1; 
	private E obj2;

	public Pair(E o1, E o2)
	{
		o1 = obj1;
		o2 = obj2;
	}

	public String toString()
	{
		return obj1.toString() + " " + obj2.toString();
	}
}