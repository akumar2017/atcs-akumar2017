import java.util.Iterator;

public class Vector<E> implements Iterable<E>
{
	private Object[] data;

	private int capacity;

	private int size;

	public Vector()
	{
		this(10);
	}

	public Vector(int initCapacity)
	{
		if(initCapacity <= 0)
			throw new IllegalArgumentException("Initial capacity cannot be less than or equal to zero:" + initCapacity);
		data = new Object[initCapacity];
		capacity = initCapacity;
		size = 0;
	}

	public Vector(Vector<E> other)
	{
		if(other == null)
			throw new IllegalArgumentException("cannot copy an empty vector");
		data = new Object[other.size()];
		for(int i = 0; i <other.size(); i++)
		{
			data[i] = other.get(i);
		}
		capacity = data.length;
		size = other.size();
	}

	public void add(E toAdd)
	{
		if(size >= capacity)
			increaseCapacity();
		data[size] = toAdd;
		size++;
	}

	public void add(int index, E toAdd)
	{
		if(size >= capacity)
			increaseCapacity();
		if((index > size) || (index < 0))
			throw new ArrayIndexOutOfBoundsException("You tried to add a value to position " + index + ", but the size of array is " + size);
		size++;
		for(int i = index; i < size; i++)
		{
			E temp = get.(i);
			data[i] = toAdd;
			toAdd = temp;
		}
	}

	private void increaseCapacity()
	{
		Object[] temp = data;
		data = new Object[capacity * 2];
		for(int i = 0; i < temp.length; i++)
		{
			data[i] = temp[i];
		}
		capacity = data.length;
	}

	public String toString()
	{
		String s = "";
		for(int i = 0; i < size; i++)
		{
			s += "[" + data[i] + ']' + " ";
		}
		return s;
	}

	public E get(int index)
	{
		if((index >= size) || (index < 0))
			throw new ArrayIndexOutOfBoundsException("You tried to get a value at position " + index + ", but the size of array is " + size);
		return (E) data[index];
	}

	public int size()
	{
		return size;
	}

	public E remove(int index)
	{
		if((index >= size) || (index < 0))
			throw new ArrayIndexOutOfBoundsException("You tried to remove a value at position " + index + ", but the size of array is " + size);
		E output = (E) data[index];
		for(int i = index; i < size - 1; i++)
		{
			data[i] = data[i + 1];
		}
		size--;
		return output;
	}

	public boolean remove(E obj)
	{
		if(contains(obj) == false)
			return false;
		int i = indexOf(obj);
		remove(i);
		return true;
	}

	public E set(int index, E obj)
	{
		if((index >= size) || (index < 0))
			throw new ArrayIndexOutOfBoundsException("tried to set a value at spot " + index + ", size of array is " + size);
		E output = (E) data[index];
		data[index] = obj;
		return output;
	}
}
