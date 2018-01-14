/**
	Vector class (similar to an array but size is dynamic)
	@version 9/25/16
	@author Akash Kumar
*/

import java.util.Iterator;

public class Vector<E> implements Iterable<E>
{
	private Object[] data;

	/**
	size of data
	*/
	private int capacity;
	
	/**
	number of objects being used in data
	*/
	private int size;
	
	/**
	default constructor
	*/
	public Vector()
	{
		this(10);
	}
	   
	/**
	constructor that takes in an int initCapacity
	@param initCapacity initial capacity of data
	*/
	public Vector(int initCapacity)
	{
		if(initCapacity <= 0)
			throw new IllegalArgumentException("Initial capacity cannot be less than or equal to zero:" + initCapacity);
		data = new Object[initCapacity];
		capacity = initCapacity;
		size = 0;
	}

	/**
	constructor that takes in another Vector<E> and copies that vector's data 
	@param other Vector that is to be copied 
	*/
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

	/**
	adds a values to the end of data
	@param toAdd value to be added to end of data
	*/
	public void add(E toAdd)
	{
		if(size >= capacity)
			increaseCapacity();
		data[size] = toAdd;
		size++;
	}

	/**
	adds value to specific spot in data and shifts values to the right down one spot
	@param index spot at which value is to be added
	@param toAdd value that is to be added
	*/
	public void add(int index, E toAdd)
	{
		if(size >= capacity)
			increaseCapacity();
		if((index > size) || (index < 0))
			throw new ArrayIndexOutOfBoundsException("You tried to add a value to position " + index + ", but the size of array is " + size);
		size++;
		for(int i = index; i < size; i++)
		{
			E temp = get(i);
			data[i] = toAdd;
			toAdd = temp;
		}
	}

	/**
	doubles the size of data. called in add function if size is greater than or equal to capacity
	*/
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

	/**
	returns a string representation of the vector
	@return String representation of the vector
	*/
	public String toString()
	{
		String s = "";
		for(int i = 0; i < size; i++)
		{
			s += "[" + data[i] + ']' + " ";
		}
		return s;
	}
	
	/**
	returns value at input index of data
	@param index spot of data whose value is to be returned
	@return E value at spot index of data
	*/
	@SuppressWarnings("unchecked")
	public E get(int index)
	{
		if((index >= size) || (index < 0))
			throw new ArrayIndexOutOfBoundsException("You tried to get a value at position " + index + ", but the size of array is " + size);
		return (E) data[index];
	}

	/**
	returns the variable size
	@return int number of values in data
	*/
	public int size()
	{
		return size;
	}

	/**
	removes and returns item at a input index. shifts other items down
	@param index spot of item that is going to be removed
	@return E item that was removed
	*/
	@SuppressWarnings("unchecked")
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

	/**
	remove first instance of input object
	@param obj object to be removed
	@return boolean true if object was removed and false is object not in vector
	*/
	public boolean remove(E obj)
	{
		if(contains(obj) == false)
			return false;
		int i = indexOf(obj);
		remove(i);
		return true;
	}

	/**
	places objects at input location
	@param index spot at which object is to be placed
	@param obj object that is to be placed
	@return E object that was previously at that spot
	*/
	@SuppressWarnings("unchecked")
	public E set(int index, E obj)
	{
		if((index >= size) || (index < 0))
			throw new ArrayIndexOutOfBoundsException("tried to set a value at spot " + index + ", size of array is " + size);
		E output = (E) data[index];
		data[index] = obj;
		return output;
	}

	/**
	removes all items from the vector
	*/
	public void clear()
	{
		data = new Object[capacity];
		size = 0;
	}
	
	/**
	returns whether or not the vector is empty
	@return boolean returns true is vector is empty and false if not
	*/
	public boolean isEmpty()
	{
		if(size == 0)
			return true;
		return false;
	}
	
	/**
	returns whether or not the vector contains a input object
	@param obj checks whether obj is in vector
	@return boolean returns true if obj is in the vector, false if not
	*/
	public boolean contains(E obj)
	{
		if(indexOf(obj) >= 0)
			return true;
		return false;
	}

	/**
	returns index of first instance of input object
	@param obj object whose index is returned
	@return int index of obj
	*/
	public int indexOf(E obj)
	{
		if(obj == null)
		{
			for(int i = 0; i < size; i++)
			{
			if(data[i] == null)
				return i;
			}
		}
		else
		{
			for(int i = 0; i < size; i++)
			{
				if(obj.equals(data[i]))
					return i;
			}
		}
		return -1;
	}
	
	/**
	iterator for the vector
	@return Iterator<E> iterator for the vector
	*/
	public Iterator<E> iterator()
	{
		return new VectorIterator<E>(this);
	}

}
