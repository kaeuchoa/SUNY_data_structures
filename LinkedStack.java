/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import Node.Node;

/**
 *
 * @author kaeuc
 */
public class LinkedStack {

    //Keeps the beggining of the stack
    private Node topPtr;
    private int length;
    private final int maxElements;

    //Stack constructor
    public LinkedStack(int maxElements) {
        this.maxElements = maxElements;
        topPtr = null;
        length = 0;
    }

    public void makeEmpty() {
        // Temporary Node used to clear the current node through its address
        Node tempPtr;
        //it will execute until the last item of the stack which points to null
        while (topPtr != null) {
            //save the current address on tempPtr
            tempPtr = topPtr;
            //points the current top to the next
            topPtr = topPtr.getNext();
            //delete the previous node
            tempPtr = null;
        }
        length = 0;
    }

    public final boolean isEmpty() {
        //if the top of the stack is pointing to null, so there is no items
        //on the stack
        return topPtr == null;
    }

    public final boolean isFull() {
        //if the length is equal to the max number of elements allowed, so it's full
        return length == maxElements;
    }

    public void push(Object item) {
        //if the stack is already full, just return, not allowing the user
        // to insert another item
        if (isFull()) {
            return;
        }

        //Creates a new node
        Node newNode = new Node();
        //insert the data within the node
        newNode.setData(item);
        //set the next item into position
        //newNode is on the top now
        newNode.setNext(topPtr);
        //and points the top to the newNode
        topPtr = newNode;
        length++;
    }

    public Object pop() {
        //if the stack is already empty, just return null to indicate that
        if (isEmpty()) {
            return null;
        }
        //Creates a temporary node to get the current node on top
        Node tempPtr;
        //gets the address of the node on the top
        tempPtr = topPtr;
        //gets the data and insert into an object to return
        Object item = tempPtr.getData();
        //points the top of the stack to the next item
        topPtr = topPtr.getNext();
        //deletes the item 
        tempPtr = null;
        length--;
        //return the item
        return item;
    }

    public int getLength() {
        return length;
    }

    public void execute() {
        LinkedStack stack = new LinkedStack(20);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        while (!stack.isEmpty()) {
            System.out.println((int) stack.pop());
        }
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println("Length before make empty: " + stack.length);
        stack.makeEmpty();
        System.out.println("Length after make empty: " + stack.length);
    }
}
