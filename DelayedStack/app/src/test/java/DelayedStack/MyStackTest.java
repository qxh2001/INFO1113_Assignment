package DelayedStack;
import java.util.Scanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyStackTest {

    @Test
    public void checkStackSize() {
        DelayedStack<String> s = new MyStack<String>(9);
        s.push("A");
        s.push("B");
        assertEquals(s.size(), 2);
    }

    @Test
    public void checkDelaySize() {
        DelayedStack<String> s = new MyStack<String>(9);
        s.setMaximumDelay(5);
        assertEquals(s.getDelay(), 9);
        assertEquals(s.getMaximumDelay(), 5);
    }

    @Test
    public void pushSize() {
        DelayedStack<String> s = new MyStack<String>(9);
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.push("5");
        s.push("6");
        assertEquals(s.size(), 6);
    }

    @Test
    public void invalidPop() {
        DelayedStack<String> s = new MyStack<String>(9);
        s.push("1");
        s.push("2");
        assertNull(s.pop());
    }

    @Test
    public void createNewArray() {
        DelayedStack<String> s = new MyStack<String>(2);
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.push("5");
        s.push("6");
        s.push("7");
        s.push("8");
        s.push("9");
        s.push("10");
        s.push("11");
        s.pop();
        s.pop();
        s.pop();
        s.push("9");
        assertEquals(s.size(), 9);
    }

    @Test
    public void testPeek() {
        DelayedStack<String> s = new MyStack<String>(4);
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.push("5");
        assertEquals(s.peek(), "5");
    }

    @Test
    public void testDelay() {
        DelayedStack<String> s = new MyStack<String>(-2);
        assertEquals(s.getDelay(), 0);
    }

    @Test
    public void testErrorsAfterClear() {
        DelayedStack<String> s = new MyStack<String>(5);
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.push("5");
        s.clear();
        assertEquals(s.size(), 0);
        assertThrows(IllegalStateException.class, ()->{s.pop();});
        assertThrows(IllegalStateException.class, ()->{s.peek();});
    }

    @Test
    public void testClearTwice() {
        DelayedStack<String> s = new MyStack<String>(5);
        s.push("1");
        s.push("2");
        s.push("3");
        s.push("4");
        s.push("5");
        s.clear();
        assertTrue(s.clear());
    }

    @Test
    public void failedClear() {
        DelayedStack<String> s = new MyStack<String>(4);
        s.push("1");
        s.push("2");
        assertFalse(s.clear());
    }

    @Test
    public void testContains1() {
        DelayedStack<String> s = new MyStack<String>(4);
        s.push("1");
        s.push("2");
        assertTrue(s.contains("2"));
        assertFalse(s.contains("5"));
        assertFalse(s.contains(null));
    }

    @Test
    public void testContains2() {
        DelayedStack<String> s = new MyStack<String>(4);
        s.push("1");
        s.push("2");
        s.push(null);
        s.push("3");
        s.push("4");
        assertTrue(s.contains(null));
        assertTrue(s.contains("4"));

    }
}