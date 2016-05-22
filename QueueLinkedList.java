/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

import Node.Node;
import java.util.Random;

/**
 *
 * @author kaeuc
 */
public class QueueLinkedList {

    //First node and last node

    private Node qFront;
    private Node qRear;

    //Constructor
    public QueueLinkedList() {
        this.qFront = null;
        this.qRear = null;
    }

    //if the front node is null still, it means there is no elements within the
    //queue
    public final boolean isEmpty() {
        return qFront == null;
    }

    //as this implementation is dynamic the queue is only full
    //in cases of lack of memory

    public final boolean isFull() {
        return false;
    }

    public void makeEmpty() {
        //temporary node to keep track of the nodes
        Node tempPtr;
        //while the front node don't point to null (which means the queue is empty)
        while (qFront != null) {
            //get the front node
            tempPtr = qFront;
            //points the front node to the next one
            qFront = qFront.getNext();
            //deletes the previous node
            tempPtr = null;
        }
        //guarantees the last node also is empty
        qRear = null;
    }

    public void enqueue(Object newItem) {
        //creates a new node
        Node ptr;
        ptr = new Node();
        //inserts the data in the node
        ptr.setData(newItem);
        //points the next pointer to null indicating the end of the queue
        ptr.setNext(null);
        //checkes where the new node must be inserted
        //if the queue is empty
        if (qFront == null) {
            //inserts in the beginning 
            qFront = ptr;
        } else {
            //inserts at the end
            qRear.setNext(ptr);
        }
        //now the last node points to the new node inserted
        qRear = ptr;

    }

    public Object dequeue() {
        //auxiliar node to help to delete the current front node
        Node tempPtr;
        Object item;
        //gets the first node
        tempPtr = qFront;
        //copies the item to return
        item = qFront.getData();
        //makes the front pointer point to the next one
        qFront = qFront.getNext();
        //if the list is empty it makes sure that the rear also indicates that
        if (qFront == null) {
            qRear = null;
        }
        //Avoids the memory leak
        tempPtr = null;
        //returns the data in the front node
        return item;
    }

    public void print() {
        Node tempPtr;
        Object item;
        System.out.println("The elements of the queue are: ");
        tempPtr = qFront;
        while (tempPtr != null) {
            item = tempPtr.getData();
            System.out.println(item);
            tempPtr = tempPtr.getNext();

        }

    }
    
    public void execute(){
        QueueArray q = new QueueArray();
        System.out.println("Is empty? " + q.isEmpty());
        for (int i = 0; i < 10; i++) {
            q.enqueue((new Random()).nextInt()%100);
        }     
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("");
        q.print();
        System.out.println("");
        q.makeEmpty();
        System.out.println("is empty after makeEmpty? " + q.isEmpty());
    }
}
