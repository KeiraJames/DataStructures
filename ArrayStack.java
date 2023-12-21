public class ArrayStack <E>{
    private Object [] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    ArrayStack(int capacity){
        data = new Object[capacity];
        size = 0;
    }

    ArrayStack(){
        this(DEFAULT_CAPACITY);
    }

    public int getSize(){
        return size;
    }

    public int spaceLeft(){
        return data.length - size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // method to add to the stack
    public void push(E data){
        // check if there's space to add more data
        if(spaceLeft() <= 0){
            throw new IndexOutOfBoundsException("Stack is full.");
        }

        if(isEmpty()){
           this.data[0] = data;
        }else{
            this.data[size]= data;
        }
        size++;
    }

    // method to remove from the stack
    public E pop(){
        // check if stack is already empty
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty.");
        }

        E removedData = (E)data[size-1];
        size--;
        return removedData;
    }

    // method to retrieve top data
    public E peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty.");
        }
        
        return (E)data[size - 1];
    }

    public void displayStack(){
        System.out.print("[");
        for(int i = 0; i < size; i++){
            System.out.print(data[i]+(i<size-1? ", ": ""));
        }
        System.out.println("]");
    }

    public void clear(){
        while(!isEmpty()){
            this.pop();
        }
    }
    public static void main(String [] args){
        // create our stack with default capacity
        ArrayStack<Integer> stack = new ArrayStack<>();

        // adding data to stack
        stack.push(3);
        stack.push(4);
        stack.push(99);
        stack.push(55);
        stack.push(31);
        stack.push(408);
        stack.push(10);
        stack.push(75);
        stack.push(1);

        // display our stack and show how much space we have left
        stack.displayStack();
        System.out.println("We have " + stack.spaceLeft() + " space" + ((stack.spaceLeft() == 1)? "":"s") + " left.\n");

        // remove top element and display top element
        int removedData = stack.pop();
        System.out.println("Removed data: " + removedData + ". Top data: " + stack.peek() + "\n");

        stack.displayStack();
        System.out.println("We have " + stack.spaceLeft() + " space" + ((stack.spaceLeft() == 1)? "":"s") + " left.\n");

        // then finally we clear the stack
        stack.clear();
        System.out.println("We have " + stack.spaceLeft() + " space" + ((stack.spaceLeft() == 1)? "":"s") + " left.");
    }
}
