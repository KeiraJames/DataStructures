public class Linkedlist <E> {
    public class Node {
        Node nextPointer;
        E data;

        Node(E data) {
            this.data = data;
        }
    }

    private Node head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public E getHead() {
        return head.data;
    }

    private void checkRange(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    //method modifies data at specific index in the list
    public E set(E data, int index) {
        checkRange(index);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.nextPointer;
        }
        E removedData = temp.data;
        temp.data = data;
        return removedData;
    }
    //method adds an item to the list

    public void add(E data) {
        Node n = new Node(data);
        if (isEmpty()) {
            head = n;
        } else {
            Node temp = head;
            while (!(temp.nextPointer == null)) {
                temp = temp.nextPointer;
            }
            temp.nextPointer = n;
        }
        size++;
    }

    //method adds to a specific index in the list
    public void add(E data, int index) {
        checkRange(index);
        Node n = new Node(data);
        if (index == 0) {
            n.nextPointer = head;
            head = n;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.nextPointer;
            }
            n.nextPointer = temp.nextPointer;
            temp.nextPointer = n;
        }
        size++;
    }

    //method removes a specific item in the list
    public E remove(int index) {
        checkRange(index);
        E removedData;
        if (isEmpty()) {
            return null;
        } else if (index == 0) {
            removedData = head.data;
            head = null;

        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.nextPointer;
            }
            removedData = temp.nextPointer.data;
            temp.nextPointer = temp.nextPointer.nextPointer;
        }
        size--;
        return removedData;
    }

    //method removes the last item in the list
    public E remove() {
        return remove(size - 1);
    }

    public void printList() {
        System.out.print("[");
        Node temp = head;
        while (!(temp == null)) {
            System.out.print(temp.data + (temp.nextPointer == null ? "" : ", "));
            temp = temp.nextPointer;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        //creating our singly linkedlist
        Linkedlist<Integer> list = new Linkedlist<>();

        //adding to our list
        list.add(7);
        list.add(4);
        list.add(1);
        list.add(8);

        //printing our list
        list.printList();

        //removing last item in our list
        list.remove();

        list.printList();
    }
}
