public class Set<E> extends Vector<E>
{
    public Set()
    {
        super();
    }

    public Set(int initCapacity)
    {
        super(initCapacity);
    }

    public Set(Set<E> s)
    {
        super(s);
    }

    /**
    Makes sure that an element that is already in the set cannot be added again
    @param key The element which we are attempting to add
    @return Whether that element was succesfully added
    */
    public boolean add(E key)
    {
        if(this.contains(key))
        {
            return false;
        }

        else
        {
            super.add(key);
        }
        return true;
    }
}