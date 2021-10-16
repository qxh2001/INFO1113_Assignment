package DelayedQueue;

/**
 * Implement this interface in a separate file called "MyQueue.java"
 * You are not allowed to use any imports from the java standard libraries for this task.
 * The data structure must be completely of your own creation.
 */
public interface DelayedQueue<E> {

    /**
     * Returns the number of elements currently in the queue.
     * @return The size of the queue.
     */
    public int size();

    /**
     * Add an element to this queue.
     * @param element The element to be added.
     */
    public void enqueue(E element);

    //See descriptions in DelayedStack for these methods (similar functionality)
    public E dequeue() throws IllegalStateException;

    public E peek() throws IllegalStateException;

    public int getDelay();

    public void setMaximumDelay(int d);

    public int getMaximumDelay();

    public boolean clear();

    public boolean contains(E elem);
}