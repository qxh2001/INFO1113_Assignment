package DelayedQueue;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyQueueTest {

    @Test
    public void checkQueueSize() {
        DelayedQueue<String> s = new MyQueue<String>(9);
        s.enqueue("A");
        s.enqueue("B");
        assertEquals(s.size(), 2);
    }

    @Test
    public void checkDelaySize() {
        DelayedQueue<String> s = new MyQueue<String>(9);
        s.setMaximumDelay(5);
        assertEquals(s.getDelay(), 9);
        assertEquals(s.getMaximumDelay(), 5);
    }

    @Test
    public void enqueueSize() {
        DelayedQueue<String> s = new MyQueue<String>(9);
        s.enqueue("1");
        s.enqueue("2");
        s.enqueue("3");
        s.enqueue("4");
        s.enqueue("5");
        s.enqueue("6");
        assertEquals(s.size(), 6);
    }

    @Test
    public void invalidDequeue() {
        DelayedQueue<String> s = new MyQueue<String>(9);
        s.enqueue("1");
        s.enqueue("2");
        assertNull(s.dequeue());
    }

    @Test
    public void createNewArray() {
        DelayedQueue<String> s = new MyQueue<String>(2);
        s.enqueue("1");
        s.enqueue("2");
        s.enqueue("3");
        s.enqueue("4");
        s.enqueue("5");
        s.enqueue("6");
        s.enqueue("7");
        s.enqueue("8");
        s.enqueue("9");
        s.enqueue("10");
        s.enqueue("11");
        s.dequeue();
        s.dequeue();
        s.dequeue();
        s.enqueue("9");
        assertEquals(s.size(), 9);
    }

    @Test
    public void testPeek() {
        DelayedQueue<String> s = new MyQueue<String>(4);
        s.enqueue("1");
        s.enqueue("2");
        s.enqueue("3");
        s.enqueue("4");
        s.enqueue("5");
        assertEquals(s.peek(), "1");
    }

    @Test
    public void testDelay() {
        DelayedQueue<String> s = new MyQueue<String>(-2);
        assertEquals(s.getDelay(), 0);
    }

    @Test
    public void testErrorsAfterClear() {
        DelayedQueue<String> s = new MyQueue<String>(5);
        s.enqueue("1");
        s.enqueue("2");
        s.enqueue("3");
        s.enqueue("4");
        s.enqueue("5");
        s.clear();
        assertEquals(s.size(), 0);
        assertThrows(IllegalStateException.class, ()->{s.dequeue();});
        assertThrows(IllegalStateException.class, ()->{s.peek();});
    }

    @Test
    public void testClearTwice() {
        DelayedQueue<String> s = new MyQueue<String>(5);
        s.enqueue("1");
        s.enqueue("2");
        s.enqueue("3");
        s.enqueue("4");
        s.enqueue("5");
        s.clear();
        assertTrue(s.clear());
    }

    @Test
    public void failedClear() {
        DelayedQueue<String> s = new MyQueue<String>(4);
        s.enqueue("1");
        s.enqueue("2");
        assertFalse(s.clear());
    }

    @Test
    public void testContains1() {
        DelayedQueue<String> s = new MyQueue<String>(4);
        s.enqueue("1");
        s.enqueue("2");
        assertTrue(s.contains("2"));
        assertFalse(s.contains("5"));
        assertFalse(s.contains(null));
    }

    @Test
    public void testContains2() {
        DelayedQueue<String> s = new MyQueue<String>(4);
        s.enqueue("1");
        s.enqueue("2");
        s.enqueue(null);
        s.enqueue("3");
        s.enqueue("4");
        assertTrue(s.contains(null));
        assertTrue(s.contains("4"));
    }
}