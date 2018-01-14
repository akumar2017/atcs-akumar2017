public class HeapPriorityQueue
{
   Object data[];
   int maxItems;
   int numberOfItems;
                 
   public HeapPriorityQueue(int size)
   {
      maxItems = size;
      data = new Object[maxItems];
      numberOfItems = 0;
   }
   
   public boolean isEmpty()
   {
      return numberOfItems == 0;
   }
   
   public void enqueue(Object item)
   {
      data[numberOfItems] = item;
      trickleUp(numberOfItems);
      ++numberOfItems;
   }
   
   private void trickleUp(int newPosition)
   {
      Object temp = data[newPosition];
      int parent = (newPosition-1)/2;
      while (newPosition > 0 && data[parent].pValue < temp.pValue)
      {
         data[newPosition] = data[parent];
         newPosition = parent;
         parent = (newPosition-1)/2;
      }
      data[newPosition] = temp;
   }

   public Object dequeue()
   {
      Object temp = data[0];
      --numberOfItems;
      if (numberOfItems > 0)
      {
         data[0] = data[numberOfItems];
         trickleDown(0);
      }
      return temp;
   }

   private void trickleDown(int itemPosition)
   {
      int child;                        // Index of the larger child.
      if (2*itemPosition+1 >= numberOfItems)
      {
         child = itemPosition;          // Leaf node (no children).
      }
      else if (2*itemPosition+2 == numberOfItems)
      {
         child = 2*itemPosition+1;      // One child (at the left).
      }
      else if (data[2*itemPosition+1].pValue > data[2*itemPosition+2].pValue)
      {
         child = 2*itemPosition+1;      // Two children w/ larger on the left.
      }
      else
      {
         child = 2*itemPosition+2;      // Two children w/ larger on the right.
      }
      if (data[itemPosition].pValue < data[child].pValue)
      {
         Object temp = data[itemPosition];
         data[itemPosition] = data[child];
         data[child] = temp;
         trickleDown(child);
      }
   }
}