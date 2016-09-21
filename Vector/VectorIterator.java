import java.util.NoSuchElementException;
import java.util.Iterator;

public class VectorIterator<E> implements Iterator<E> 
{
	private Vector<E> vector;
	private int curr;
	
	public VectorIterator(Vector<E> v)
	{
		if((v == null) || (v.isEmpty()))
			throw new IllegalArgumentException("cannot use an empty or null vector");
		vector = v;
		curr = 0;
	}
	
	public boolean hasNext()
	{
		if(curr < vector.size())
			return true;
		return false;
	}
		
	public E next()
	{
		if(hasNext() == false)
			throw new NoSuchElementException("no more items left in the Vector");	
		E output = vector.get(curr);
		curr++;
		return output;
	}		
}