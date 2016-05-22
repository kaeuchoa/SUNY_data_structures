package Assignment2;

/**
 *
 * @author kaeuc
 */
public class ArrayStack {
    //Declaration of the stack structure

    //maxItems: it will determine how many items this stack can keep
    private final int maxItems;
    //top: it will keep track of the index which represents the top of the stack
    private int top;
    //length: it will keep track of the number of elements within the stack
    private int length;
    //items: array to store the items
    private char[] items;

    //Constructor to initialize the stack
    public ArrayStack(int maxItems) {
        this.maxItems = maxItems;
        items = new char[maxItems];
        top = -1;
        length = 0;
    }

    //Makes the stack empty
    //returns the stack to the initial state
    public void makeEmpty() {
        top = -1;
        length = 0;
    }

    //return whether the stack is full or not
    //if the top index is equal to the last index in the array 
    //which is maxItems - 1, so it means it's full
    public boolean isFull() {
        return (top == maxItems - 1);
    }

    //return whether the stack is empty or not
    public final boolean isEmpty() {
        return top == -1;
    }

    //inserts an item on the stack top
    public void push(char item) {
        //if the stack is full, it doesn't allow the user to insert a new item
        if (isFull()) {
            return;
        }
        //if it's not, increase the top index and the length and insert the 
        //new item in the array
        top++;
        length++;
        items[top] = item;

    }

    //removes an item from the stack top
    public char pop() {
        //if the stack is alredy empty, you can't pop anything from it
        if (isEmpty()) {
            return 0;
        }
        //if not, gets the item at the top, decrement the top index and length
        //and return the item to the user
        char item = items[top];
        top--;
        length--;
        return item;

    }

    //just returns the current lenght
    public int getLength() {
        return length;
    }

    public void execute() {
        //Instantiate the stack
        ArrayStack charStack = new ArrayStack(5);
        //creates a char variable
        char letter = 'v';
        //pushes the variable letter on the stack top
        charStack.push(letter);
        //show if the stack is empty or full or none of them

        System.out.println("Is Empty?\n" + charStack.isEmpty());
        System.out.println("Is Full?\n" + charStack.isFull());
        //if the stack is not empty, inserts another item
        if (!charStack.isEmpty()) {
            letter = charStack.pop();
            System.out.println("letter: " + letter);
        }

        //fullfil the stack until is full
        for (int i = 80; !charStack.isFull(); i++) {
            charStack.push((char) i);
        }

        //check if the stack is really full
        System.out.println("Is Full?\n" + charStack.isFull());

        //remove all the items from the stack until is empty and print 		each item on the screen
        while (!charStack.isEmpty()) {
            letter = charStack.pop();
            System.out.println("letter: " + letter);

        }

        //fullfil the stack until is full again         
        for (int i = 50; !charStack.isFull(); i++) {
            charStack.push((char) i);
        }
        //show the full status and to demonstrate makeEmpty function
        System.out.println("Call is full: " + charStack.isFull());
        System.out.println("Call make empty.");
        //calls the makeEmpty to clean the stack and print the empty 		status
        charStack.makeEmpty();
        System.out.println("Is Empty?\n" + charStack.isEmpty());
    }
}
