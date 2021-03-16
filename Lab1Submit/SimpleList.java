
import java.util.LinkedList;
/**
 * The overall purpose of this class is to create a linked list and 
 * use a variety of different methods to modify the list. Such as adding,
 * removing, setting, clearing, and checking for the size.
 * 
 * 
 * @author Matteo Messana
 * @version 1.0
 * @since January 23rd, 2018
 */
public class SimpleList 
{
	/**
	 * List holds the entire linked list of type Integer.
	 */
	private LinkedList<Integer> List;
	
	/**
	 * The default constructor used to create the object.
	 */
	public SimpleList()
	{
		this.List = new LinkedList<Integer>();
	}
	
	/**
	 * Adds an element to the beginning of the linked list.
	 * @param val: takes in a value to place inside of the linked list.
	 */
	public void pushFront(int val)
	{
		this.List.addFirst(val);
	}
	
	/**
	 * Adds an element to the end of the linked list.
	 * @param val: takes in a value to place inside of the linked list.
	 */
	public void pushBack(int val)
	{
		this.List.addLast(val);
	}
	
	/**
	 * Replaces an element at the specified index.
	 * @param index: gives the index for the element to be placed in the linked list
	 * @param val: takes in a value to place inside of the linked list.
	 */
	public void set(int index, int val)
	{
		this.List.set(index, val);
	}
	
	/**
	 * Gets the size of the linked list.
	 * @return size: returns the size of the linked list.
	 */
	public int size()
	{
		return this.List.size();
	}
	
	/**
	 * Removes an element of the linked list at this index
	 * @param index: Contains the index of the element to be removed
	 * @param size: Holds the size of the linked list
	 */
	public void remove(int index, int size)
	{
		if(index < size)
		{
			this.List.remove(index);
		}
	}
	
	/**
	 * Clears the entire list
	 */
	public void clear()
	{
		this.List.clear();
	}
	
	/**
	 * Add an element to the array
	 * @param index: Holds the index of the element of the array.
	 * @param val: Holds the value to be placed in the linked list.
	 * @param size: Holds the size of the linked list.
	 */
	public void add(int index, int val, int size)
	{
		if(index == size)
			pushBack(val);
		if(index < size && index >= 0)
			List.add(index,val);
	}
	
	/**
	 * Prints the list and all of its elements
	 */
	public void print()
	{
		
		System.out.printf("After calling push_front. list must have: " + this.List + "\n");
	}
	
	public static void main(String[] args) 
	{
	     
        SimpleList List = new SimpleList();
        System.out.println("List just after creation -- is empty.");
       
        List.pushFront(50);
        List.print();
        
        List.pushBack(440);
        List.set(0,770);  
        List.print();
        
        List.pushBack(330);
        List.pushBack(220);
        List.pushBack(110);
        List.print();
        
        List.remove(0,List.size());
        List.remove(2,List.size());
        List.print();
        
        List.add(3,40,List.size());
        List.add(-1,20,List.size());
        List.add(30000,30,List.size());
        List.add(0,10,List.size());
        List.add(2,33,List.size());
        List.print();
        
        List.remove(0,List.size());
        List.remove(1,List.size()); 
        List.remove(2,List.size()); 
        List.remove(3,List.size());
        List.remove(4,List.size()); 
        List.remove(5,List.size()); 
        List.print();
        
        List.clear();
        List.print();
        
        List.pushBack(331);
        List.pushBack(221);
        List.pushBack(111);
        List.print();
	}
	
}
