import java.util.Stack;

class MyQueue {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // Enqueue
    public void enqueue(int x) {
        stackIn.push(x);
    }

    // Dequeue
    public int dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        if (stackOut.isEmpty()) {

            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        return stackOut.pop();
    }

    // Front Element
    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        if (stackOut.isEmpty()) {

            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        return stackOut.peek();
    }

    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    public int size() {
        return stackIn.size() + stackOut.size();
    }
}

public class Main {

    public static void main(String[] args) {

        MyQueue q = new MyQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue()); // 10
        System.out.println(q.dequeue()); // 20

        q.enqueue(40);

        System.out.println(q.dequeue()); // 30
        System.out.println(q.dequeue()); // 40
    }
}
