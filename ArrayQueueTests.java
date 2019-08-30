public class ArrayQueueTests {
    public static void main(String[] args){
        testEmptyQueue();
        testEnqueue();
        testEnqueueFullQ();
        testDequeue();
        testDequeueEmptyQ();
    }

    // test if isEmpty() method works
    private static void testEmptyQueue(){
        Queue<String> q = new ArrayQueue<>(10);
        try{
            if(!q.isEmpty()){
                System.out.println("testEmptyQueue(): FAILED");
                System.out.println("Expected empty queue.");
            }else{
                System.out.println("testEmptyQueue(): SUCCESS");
            }
        }catch(RuntimeException e){
            System.out.println("testEmptyQueue(): HELLA FAILED");
            e.printStackTrace();
        }

    }

    // test if enqueue() method works
    private static void testEnqueue(){
        Queue<String> q = new ArrayQueue<>(10);
        q.enqueue("A");
        try {
            if (!q.front().equals("A")) {
                System.out.println("testEnqueue(): FAILED");
                System.out.println("Expected 'A' at front of queue.");
            } else {
                System.out.println("testEnqueue(): SUCCESS");
            }
        }catch (RuntimeException e){
            System.out.println("testEnqueue(): HELLA FAILED");
            e.printStackTrace();
        }
    }

    // test if enqueue() method throws exception when stack is full
    private static void testEnqueueFullQ(){
        Queue<String> q = new ArrayQueue<>(2);
        q.enqueue("A");
        q.enqueue("A");
        try{
            q.enqueue("A");
            System.out.println("testEnqueueFullQ(): FAILED");
        }catch(RuntimeException e){
            System.out.println("testEnqueueFullQ(): SUCCESS");
        }
    }

    // test if dequeue() works on a non-empty queue
    private static void testDequeue(){
        Queue<String> q = new ArrayQueue<>(10);
        q.enqueue("A");
        try{
            if(!q.dequeue().equals("A")){
                System.out.println("testDequeue(): FAILED");
                System.out.println("Expected output: A");
            }else{
                System.out.println("testDequeue(): SUCCESS");
            }
        }catch(RuntimeException e){
            System.out.println("testDequeue(): HELLA FAILED");
        }

    }

    // test if dequeue() throws exception if stack is empty
    private static void testDequeueEmptyQ(){
        Queue<String> q = new ArrayQueue<>(10);
        try{
            q.dequeue();
            System.out.println("testDequeueEmptyQ(): FAILED");
            System.out.println("Expected QueueEmptyRuntimeException.");
        }catch (RuntimeException e){
            System.out.println("testDequeue(): SUCCESS");
        }
    }
}
