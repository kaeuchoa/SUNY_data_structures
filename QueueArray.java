/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment4;

/**
 *
 * @author kaeuc
 */
public class QueueArray {
    // indexes values of the front and rear elements
    private int qFront;
    private int qRear;
    private final int max_elements = 10;
    //Array to save the items
    private Object[] items;
    
    //Constructor
    public QueueArray() {
        this.qFront = 0;
        this.qRear = 0;
        items = new Object[max_elements];
    }
    //if front and rear indexes are the same, it means an empty queue
    public final boolean isEmpty() {
        return qFront == qRear;
    }
    //as the array is initialized with null elements, check if the last one is different of null
    //if it is, so the queue is full
    public final boolean isFull() {
        return items[max_elements - 1] != null;
    }
    
    //fulfill the array with null elements and redefine rear and front indexes
    public void makeEmpty(){
        items = new Object[max_elements];
        qRear = qFront;
    }
    
    public void enqueue(Object newItem) {
        //check the queue status for both empty or full
        if (isEmpty()) {
            //if it's empty, inserts the new Item in the first position
            items[qFront] = newItem;
            qRear++;
        } else if (isFull()) {
            //if it's full, just return a warning message
            System.out.println("The queue is full, can't add more items.");
        } else {
            //if it's not empty, inserts the element at the end of the queue
            //and increment the rear index
            items[qRear] = newItem;
            qRear++;
        }

    }

    public Object dequeue() {
        //auxiliar variable to return the dequeued value
        Object aux;
        aux = items[qFront];
        //warning message in case the queue is empty already
        if (isEmpty()) {
            System.out.println("The queue is already empty.");
        } else {
            //if it's not empty, moves all the elements removing the first one
            for (int i = 0; i < qRear - 1; i++) {
                items[i] = items[i + 1];
            }
        }
        //if the element removed was the only one, makes the queue empty again
        if (qRear == qFront) {
            items[qFront] = null;
        } else {
        //if not, decrement the rear index and clear the item at that position
            qRear--;
            items[qRear] = null;
        }
        return aux;
    }

    public void print() {
        System.out.println("The elements of the queue are: ");
        for (Object item : items) {
            System.out.println(item);
        }

    }
    
    public void execute(){
        QueueLinkedList q = new QueueLinkedList();
             System.out.println("Is empty? "+ q.isEmpty());
             q.enqueue(9);
             q.enqueue(10);
             q.enqueue(11);
             q.enqueue(12);
             q.enqueue(13);
             q.enqueue(14);
             q.enqueue(15);
             q.enqueue(16);
             q.enqueue(17);
             q.enqueue(18);
             q.enqueue(19);     
             System.out.println("Dequeue: "+ q.dequeue());
             System.out.println("Dequeue: "+ q.dequeue());
             System.out.println("Dequeue: "+ q.dequeue());
             System.out.println("Dequeue: "+ q.dequeue());
             System.out.println("Dequeue: "+ q.dequeue());                     
             System.out.println("");
             q.print();
             System.out.println("");
             q.makeEmpty();
             System.out.println("is empty after makeEmpty? "+ q.isEmpty());
    }

}
