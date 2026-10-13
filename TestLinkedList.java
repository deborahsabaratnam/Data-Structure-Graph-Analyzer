public class TestLinkedList {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.display();

        System.out.println("Searching for 20...");

        if (list.search(20)) {
            System.out.println("20 found.");
        } else {
            System.out.println("20 not found.");
        }

        list.delete(20);

        list.display();
    }
}