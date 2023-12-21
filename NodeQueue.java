public class NodeQueue <E> {
    class Node {
        Node nextPointer;
        E data;
        Node(E data) {
            this.data = data;
        }
    }
    Node front, rear;
    private int size;

    public int getSize(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // method to add to the queue
    public void enqueue(E data){
        Node nodeToInsert = new Node(data);
        if(isEmpty()){
            front = nodeToInsert;
            rear = nodeToInsert;
        }else{
            rear.nextPointer = nodeToInsert;
            rear = nodeToInsert;
        }
        size++;
    }

    // method to remove from queue
    public E dequeue(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Queue is empty.");
        }
        E removedData = front.data;
        front = front.nextPointer;
        size--;

        // if there are no more elements, reset rear
        if(front == null){
           rear = null;
        }
        return removedData;
    }

    // method to view front data
    public E peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Queue is empty.");
        }
        return front.data;
    }

    public void printQueue(){
        System.out.print("[");
        Node temp = front;
        while(temp !=null){
            System.out.print(temp.data + (temp.nextPointer==null? "":", "));
            temp = temp.nextPointer;
        }
        System.out.println("]");
    }

    public void clear(){
        while(!isEmpty()){
            this.dequeue();
        }
    }

    public static void main(String [] args){
        // initialize queue
        NodeQueue <Integer> queue = new NodeQueue<>();

        // add to the queue
        queue.enqueue(12);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(4);

        // print the items in the queue
        queue.printQueue();

        // remove front data and print new front data
        int removedData = queue.dequeue();
        System.out.println("Removed data: " + removedData + ". Top data: " + queue.peek());


        // clear queue and check if its empty
        queue.clear();
        System.out.println("Stack empty? " + queue.isEmpty());
    }
}
