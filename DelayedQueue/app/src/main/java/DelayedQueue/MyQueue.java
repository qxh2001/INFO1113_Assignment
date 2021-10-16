package DelayedQueue;

class MyQueue<E> implements DelayedQueue<E> {

    int queueSize = 0;
    int delaySize;
    int delay;
    int top = 0;

    E[] array;
    boolean dequeue;

    public MyQueue(int delaySize) {
        this.delaySize = delaySize;
        this.delay = delaySize;
        this.top = top;
        this.array = (E[]) new Object[10];
        boolean dequeue = false;
    }

    public int size() {
        return queueSize;
    }

    public void enqueue(E element) {
        if (dequeue == true) {
            dequeue = false;
            delay = delaySize;
        }
        if (queueSize + top > array.length - 1) {
            createNewArray();
        }
        array[top + queueSize] = element;
        queueSize++;
        delay--;
    }

    private void createNewArray() {
        E[] newArray = (E[]) new Object[this.array.length + 10];
        for (int i = 0; i < queueSize; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public E dequeue() throws IllegalStateException {
        if (array[top] == null) {
            throw new IllegalStateException();
        }

        if (delay <= 0) {
            dequeue = true;
        } else {
            return null;
        }

        E removedElement = array[top];
        array[top] = null;
        queueSize--;
        top++;
        return removedElement;
    }

    public E peek() throws IllegalStateException {
        if (array[top] == null) {
            throw new IllegalStateException();
        }

        E topElement = array[top];
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
        if (array[top] == null) {
            return true;
        }

        if (delay <= 0) {
            dequeue = true;
        } else {
            return false;
        }

        array = (E[]) new Object[this.array.length];
        queueSize = 0;
        top = 0;
        return true;
    }

    public boolean contains(E elem) {
        if (elem == null) {
            for (int i = 0; i < queueSize; i++) {
                if (array[i] == null) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 0; i < queueSize; i++) {
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