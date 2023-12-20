import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {

    //--------------------------Node Class---------------------------------------
    class Node {
        private Node previousPointer;
        private Node nextPointer;
        private E data;

        Node(E data) {
            this.data = data;
        }
    }

    //----------------------------Double Linked List Class-----------------------
    private Node head;
    private Node tail;
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

    public E getTail() {
        return tail.data;
    }

    private void isInRange(int index) {
        if (index < 0 || index >= this.getSize()) {
            throw new IndexOutOfBoundsException();
        }
    }

    // method to add to the list
    public void add(E data) {
        Node nodeToInsert = new Node(data);

        if (isEmpty()) {
            head = nodeToInsert;
        } else if (head.nextPointer == null) {
            Node temp = head;
            temp.nextPointer = nodeToInsert;
            nodeToInsert.previousPointer = temp;
            tail = nodeToInsert;
        } else {
            Node temp = tail;
            nodeToInsert.previousPointer = temp;
            temp.nextPointer = nodeToInsert;
            tail = nodeToInsert;
        }
        size++;
    }

    // method to add to a specific index of the list
    public void add(E data, int index) {
        isInRange(index);
        Node nodeToInsert = new Node(data);
        Node temp;

        if (index == 0) {
            nodeToInsert.nextPointer = head;
            head.previousPointer = nodeToInsert;
            head = nodeToInsert;
            size++;
            return;
        }
        if (index < size / 2) {
            temp = head;
            int count = 1;
            while (count < index) {
                temp = temp.nextPointer;
                count++;
            }
            nodeToInsert.nextPointer = temp.nextPointer;
            temp.nextPointer = nodeToInsert;
            nodeToInsert.previousPointer = temp;
            temp = temp.nextPointer;
            temp.previousPointer = nodeToInsert;

        } else {
            temp = tail;
            int count = size - 1;
            while (count > index) {
                temp = temp.previousPointer;
                count--;
            }
            nodeToInsert.previousPointer = temp.previousPointer;
            temp.previousPointer = nodeToInsert;
            nodeToInsert.nextPointer = temp;
            temp = temp.previousPointer.previousPointer;
            temp.nextPointer = nodeToInsert;
        }
        size++;
    }

    // method to retrieve position of data in list
    public int indexOf(E dataToCheck) {
        Node temp = head;
        int count = 0;
        while (temp != null) {

            if (temp.data.equals(dataToCheck)) {
                return count;
            }
            temp = temp.nextPointer;
            count++;

        }
        throw new NoSuchElementException();
    }

    // method to retrieve data at a specified position in list
    public E get(int index) {
        isInRange(index);
        Node temp;
        if (index < size / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.nextPointer;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.nextPointer;
            }
        }
        return temp.data;
    }

    //method to remove data at specified position in list
    public E remove(int index) {
        isInRange(index);
        E removedData;
        Node temp = head;
        if (index == 0) {
            removedData = head.data;
            temp = temp.nextPointer;
            temp.previousPointer = null;
            head = temp;

            return removedData;

        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.nextPointer;
        }
        removedData = temp.nextPointer.data;

        temp.nextPointer = temp.nextPointer.nextPointer;
        temp = temp.nextPointer;
        temp.previousPointer = head;

        return removedData;
    }

    public void printLinkedList() {
        Node temp = head;
        System.out.print("[");
        while (!(temp == null)) {
            System.out.print(temp.data + (temp.nextPointer == null ? "" : ", "));
            temp = temp.nextPointer;
        }
        System.out.println("]");
    }

    public void printReverseLinkedList() {
        Node temp = tail;
        System.out.print("[");
        while (!(temp == null)) {
            System.out.print(temp.data + (temp.previousPointer == null ? "" : ", "));
            temp = temp.previousPointer;
        }
        System.out.println("]");
    }

    public static void main(String [] args){
        // create our doubly linkedlist
        DoublyLinkedList <Double> doublelist = new DoublyLinkedList<>();

        //add to our list
        doublelist.add(24.2);
        doublelist.add(43.2);
        doublelist.add(6.8);
        doublelist.add(9.0);
        doublelist.add(71.2);

        //print our list
        doublelist.printLinkedList();
        doublelist.printReverseLinkedList();

        //retrieve index of our data and remove it
        doublelist.remove(doublelist.indexOf(9.0));
        
        doublelist.printLinkedList();
    }
}
