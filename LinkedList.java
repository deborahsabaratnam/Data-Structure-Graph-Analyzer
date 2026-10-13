public class LinkedList {

    Node head;

    public LinkedList() {
        head = null;
    }

    // Insert a new node at the end
    public void insert(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Delete the first occurrence
    public void delete(int data) {

        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        if (head.data == data) {
            head = head.next;
            System.out.println(data + " deleted.");
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.data == data) {
                current.next = current.next.next;
                System.out.println(data + " deleted.");
                return;
            }

            current = current.next;
        }

        System.out.println(data + " not found.");
    }

    // Search for a value
    public boolean search(int data) {

        Node current = head;

        while (current != null) {

            if (current.data == data) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Display the linked list
    public void display() {

        if (head == null) {
            System.out.println("Linked List is empty.");
            return;
        }

        Node current = head;

        System.out.print("Linked List: ");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }
}