import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.*;

/**
A HashMap stores a set of objects as integers in a Map by using a hashcode to turn the object into an integer
@author Akash Kumar
@version 11/28/16
*/

public class HashMap<K,V> implements Map<K,V>
{
    public int size;
    public int capacity;
    public Set<K> keySet;
    public Entry<K,V>[] storage;
    public double loadFactor;
    
    static class Entry<K,V>
    {
        public K key;
        public V value;

        public Entry(K k, V v)
        {
            key = k;
            value = v;
        }

        public void setKey(K k)
        {
            key = k;
        }

        public void setValue(V v)
        {
            value = v;
        }

        public K getKey()
        {
            return key;
        }

        public V getValue()
        {
            return value;
        }

        public String toString()
        {
            return "Key: " + key.toString() + "   Value: " + value.toString();
        }
    }

    /**
    Constructor for Hashmap that uses the initial capacity and load factor
    @param s the initial capacity
    @param lFactor the amount allowed to be filled
    */
    public HashMap(int c, double lfac)
    {
        size = 0;
        capacity = c;
        keySet = new Set<K>(c);
        storage = new Entry[capacity];
        if(lfac <= 0 || lfac > 1)
        {
            throw new IllegalArgumentException();
        }
        loadFactor = lfac;
    }
    /**
    Default constructor that sets capacity to 5000 and load Factor to 0.6
    */
    public HashMap()
    {
        size = 0;
        capacity = 5000;
        keySet = new Set<K>(5000);
        storage = new Entry[capacity];
        loadFactor = 0.6;
    }

    /**
    Doubles the size of the HashMap
    */
    public void grow() 
    {
        HashMap<K,V> temp = new HashMap(capacity*2,loadFactor);
        temp.putAll(this);
        this.storage = temp.storage;
        this.keySet = temp.keySet;
        capacity = capacity*2;
    }
    /**
    Public put
    @param key key of the new entry
    @param value value of the new entry
    @return whether or not the entry was succesfully added
    */
    public boolean put(K key, V value) 
    {
        return put(key,value,capacity,storage);
    }

    /**
    Private put
    @param key key of the new entry
    @param value value of the new entry
    @param cap max value of the index of  new entry
    */
    private boolean put(K key, V value, int cap)
    {

        while((double)(size + 1)/(double)storage.length >= (loadFactor))
        {
            grow();
        }

        if(keySet.add(key))
        {
            size++;
            int i = Math.abs(key.hashCode()) % capacity;

            while(storage[i] != null)
            {
                i = rehash(i,capacity);
            }
            
            storage[i] = new Entry(key,value);
            return true;
        }
        return false;
    }

    /**
    Takes in a number and adds 1 to it and then performs a mod operation with the capacity
    @param code integer
    @param initcap initial capacity
    @return changed hash
     */
    private int rehash(int code, int initcap)
    {
        return ((code + 1) % initcap);
    }

    /**
    Value for a given key
    @param key key to find the value for
    @return value for the key
    */
    public V get(Object key)
    {
        int i = Math.abs(key.hashCode()) % capacity;
       
        if(storage[i] == null)
        {
            return null;
        }

        if(storage[i].key.equals(key))
        {
            return storage[i].value;
        }

        while(true)
        {
            index = rehash(i,capacity);

            if(storage[i] == null)
            {
                return null;
            }

            if(storage[i].key.equals(key))
            {
                return storage[i].value;
            }
        }
    }
    /**
    Adds all values of a given map to a new map
    @param m map to be added
    */
    public void putAll(MyMap<? extends K, ? extends V> m) 
    {
        for(Object key: m.keySet())
        {
            put((K)key, m.get(key));
        }
    }

    /**
    Whether or not the map contains a given key
    @param key key to be checked
    @return whether or not the key is in the map
    */
    public boolean containsKey(K key)
    {
        return keySet.contains(key);
    }

    /**
    Checks if the map contains a certain value
    @param value value being checked for
    @return whether or not the value is contained
     */
    public boolean containsValue(V value)
    {
        for(K key: keySet)
        {
            try
            {
                if(value.equals(get(key)))
                {
                    return true;
                }
            }

            catch(NullPointerException e)
            {
                if(get(key) == null)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
    Removes a value for a key
    @param key key for a given value
    @return value for the key
    */
    public V remove(K key)
    {
        int i = Math.abs(key.hashCode()) % capacity;

        if(storage[i] == null)
        {
            return null;
        }

        if(storage[i].key.equals(key))
        {
            V temp = storage[i].value;
            storage[i] = null;
            keySet.remove(key);
            size--;
            return temp;
        }
        while(true)
        {
            i = rehash(i,capacity);

            if(storage[i] == null)
            {
                return null;
            }

            if(storage[i].key.equals(key))
            {
                V temp = storage[i].value;
                storage[i] = null;
                keySet.remove(key);
                size--;
                return temp;
            }
        }
    }

    /**
    Whether or not the map is empty
    @return Whether or not the map is empty
    */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
    The size of the map;
    @return size of the map
    */
    public int size()
    {
        return size;
    }
   
    /**
    The keySet
    @return keySet
    */
    public Set<K> keySet()
    {
        return keySet;
    }

    /**
    A vector of all values
    @return vector of all values
    */
    public Vector<V> values()
    {
        Vector<V> temp = new Vector<V>(keySet.size());

        for(int i = 0; i<keySet.size(); i++)
        {
            temp.add(get(keySet.get(i)));
        }
        return temp;
    }

    public void printValues()
    {
        for(Object key: keySet)
        {
            System.out.println(get(key).toString() + "|");
        }
    }

    public void printEntries()
    {
        for(int i = 0; i<capacity; i++)
        {
            try
            {
                System.out.println(storage[i].toString());
            }

            catch(NullPointerException e)
            {
                System.out.println(" |NULL| ");
            }
        }
        }
}