package mj223vn_assign2.Exercise1;
/**
* An interface representing a simple linked list.  This interface defines the required
* functionality for all <code>LinkedQueue</code> implementations. . It also
* contains basic support for sequential access of the whole content (i.e., iterators).
* <p/>
* Currently available <code>Queue</code> implementations in the 
* <code>linked</code> package are:
* <ul>
* <li>  {@link Exercise1.LinkedQueue} </li>
* </ul>
*
* @author	Marcus Johansson
* @since 2019-02-06
*/
import java.util.Iterator;

public interface Queue extends Iterable<Object>{
	
	/** Number of objects currently stored in the Queue. 
	 *  @return Current queue size
	 */
	public int size();                     // current queue size 
	
	/** True if queue is empty. 
	 * @return true if queue is empty
	 */
	public boolean isEmpty();              // true if queue is empty 
	
	/** 
	 * Add object <code>element</code> at the end of queue.
	 * @param element to be added
	 */
	public void enqueue(Object element);   // add element at end of queue 
	
	/**
	 * Return and remove first element in queue.
	 * @return first element in queue.
	 */
	public Object dequeue();               // return and remove first element. 
	
	/**
	 * Return without removing first element.
	 * @return first element in queue.
	 */
	public Object first();                 // return (without removing) first element 
	
	/**
	 * Return without removing last element.
	 * @return last element in queue.
	 */
	public Object last();                  // return (without removing) last element 
	
	/**
	 * Returns a string representation of the current queue.
	 * @return string representation of the content.
	 */
	public String toString();              // return a string representation of the queue content
	
	
	 /** Iterates over the objects in the queue.*/
	public Iterator<Object> iterator();    // element iterator
	

}
