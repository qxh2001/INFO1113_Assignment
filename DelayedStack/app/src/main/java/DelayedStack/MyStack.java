package DelayedStack;

@SuppressWarnings("unchecked")
class MyStack<E> implements DelayedStack<E> {

    int stackSize = 0;
    int delaySize;
    int delay;

    E[] array;
    boolean pop;

    public MyStack(int delaySize) {
        this.delaySize = delaySize;
        this.delay = delaySize;
        this.array = (E[]) new Object[10];
        this.pop = false;
    }

    public int size() {
        return stackSize;
    }

    public void push(E element) {
        if (pop == true) {
            pop = false;
            delay = delaySize;
        }
        if (stackSize > array.length - 1) {
            createNewArray();
        }
        array[stackSize] = element;
        stackSize++;
        delay--;
    }

    private void createNewArray() {
        E[] newArray = (E[]) new Object[array.length + 10];
        for (int i = 0; i < stackSize; i++) {
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    public E pop() throws IllegalStateException {
        if (array[0] == null) {
            throw new IllegalStateException();
        }

        if (delay <= 0) {
            pop = true;
        } else {
            return null;
        }

        E removedElement = array[stackSize - 1];
        array[stackSize - 1] = null;
        stackSize--;
        return removedElement;
    }

    public E peek() throws IllegalStateException {
        if (array[0] == null) {
            throw new IllegalStateException();
        }

        E topElement = array[stackSize - 1];
        return topElement;
    }

    public int getDelay() {
        if (delay < 0) {
            return 0;
        } else {
            return delay;
        }
    }

    public void setMaximumDelay(int d) {
        delaySize = d;
    }

    public int getMaximumDelay() {
        return delaySize;
    }

    public boolean clear() {
        if (array[0] == null) {
            return true;
        }

        if (delay <= 0) {
            pop = true;
        } else {
            return false;
        }

        array = (E[]) new Object[this.array.length];
        stackSize = 0;
        return true;
    }

    public boolean contains(E elem) {
        if (elem == null) {
            for (int i = 0; i < stackSize; i++) {
                if (array[i] == null) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 0; i < stackSize; i++) {
                if (array[i] == null) {
                    continue;
                } else {
                    if (array[i].equals(elem)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}