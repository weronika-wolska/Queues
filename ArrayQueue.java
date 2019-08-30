import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T> {


    private int size;
    private int front;
    private int rear;
    private int capacity;
    T[] queue;

   public ArrayQueue(int c){
        this.capacity = c;
        queue = (T[]) new Object[capacity];
        front = 0;
        rear = 0;
        size=0;
   }


    @Override
    public void enqueue(T element) {
        if(size==capacity) {
            throw new QueueFullException();
        }
        queue[rear] = element;
        rear = (rear + 1) % capacity;
        size++;
    }

    @Override
    public T dequeue() {
        if(size==0){ throw new QueueEmptyException(); }
        T tmp = queue[front];
        queue[front] = null;
        front = (front-1) % capacity;
        return tmp;
    }

    @Override
    public T front() {
        if(size==0){ throw new QueueEmptyException(); }
        return queue[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public String toString(){
       return "Queue front=" + front + ", rear=" + rear + ", size=" + size
                + ", queue=" + Arrays.toString(queue);
    }
}
