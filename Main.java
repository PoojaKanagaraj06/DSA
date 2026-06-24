class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }
}

public class Main {

    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Step 1: Insert copied nodes
        Node curr = head;

        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers
        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate original and copied list
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            Node copy = curr.next;

            curr.next = copy.next;
            copyCurr.next = copy;

            copyCurr = copy;
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void printList(Node head) {
        Node curr = head;

        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;

            System.out.println(
                "Node = " + curr.val +
                ", Random = " + randomVal
            );

            curr = curr.next;
        }
    }

    public static void main(String[] args) {

        // Create nodes
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        // Next pointers
        n1.next = n2;
        n2.next = n3;

        // Random pointers
        n1.random = n3; // 1 -> 3
        n2.random = n1; // 2 -> 1
        n3.random = n2; // 3 -> 2

        System.out.println("Original List:");
        printList(n1);

        Node copiedHead = copyRandomList(n1);

        System.out.println("\nCopied List:");
        printList(copiedHead);
    }
}
