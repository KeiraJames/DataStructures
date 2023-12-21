public class NodeStack <E> {
    class Node{
       Node nextPointer;
       E data;
       Node(E data){
           this.data = data;
       }
    }
    Node top;
    private int size;

    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    // method to view top data
    public E peek() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return top.data;
    }

    // method to add items to the stack
    public void push(E data){
        Node nodeToInsert = new Node(data);
        if(isEmpty()){
           top = nodeToInsert;
        }else{
            nodeToInsert.nextPointer = top;
            top = nodeToInsert;
        }
        size++;
    }

    // method to remove top data
    public E pop(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        E removedData = this.peek();
        top = top.nextPointer;
        size--;
        return removedData;
    }

    public void printStack(){
        Node temp = top;
        System.out.print("[");
        while(temp != null){
            System.out.print(temp.data + (temp.nextPointer == null? "" : ", "));
            temp = temp.nextPointer;
        }
        System.out.println("]");
    }

    public void clear(){
        while(!isEmpty()){
            this.pop();
        }
    }
    public static void main(String [] a){
        // initialize stack
        NodeStack <String> stack = new NodeStack<>();

        // add items to the stack
        stack.push("pancakes");
        stack.push("jam");
        stack.push("eggs");
        stack.push("waffles");
        stack.push("bacon");
        stack.push("biscuits");

        // print the items in our stack
        stack.printStack();

        // remove top data and print new top data
        String removedData = stack.pop();
        System.out.println("Removed data: " + removedData + ". Top data: " + stack.peek());

        // clear stack and check if its empty
        stack.clear();
        System.out.println("Stack empty? " + stack.isEmpty());
    }
}
