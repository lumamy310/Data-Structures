package LinkedList;

import java.util.Scanner;

public class doubleLinkedList {

    private DNode head;

    public doubleLinkedList(){
        head = null;
    }

    public void print(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        DNode temp = head;
        System.out.print("{ ");
        while(temp != null){
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.print("}");
        System.out.println();
    }

    public void add(int input){
        //adding numbers will be in increasing order
        DNode temp = new DNode();

        //empty list
        if(head == null){
            head = new DNode(input, null, null);
            return;
        }

        //top of list
        if(input < head.getData()){
            temp = head;
            head = new DNode(input, temp, null);
            temp.setPrev(head);
            return;
        }

        //middle of list
        if(input > head.getData()){
            temp = head;
            while(input > temp.getData()){
                if(temp.getNext() == null){
                    temp.setNext(new DNode(input, null, temp));
                    return;
                }
                if(temp.getNext().getData() > input){
                    temp.setNext(new DNode(input, temp.getNext(), temp));
                    temp.getNext().getNext().setPrev(temp.getNext());
                    return;
                }
                temp = temp.getNext();
            }
        }
    }

    public void swapNineEleven(){
        if(head == null)
            throw new IndexOutOfBoundsException();

        DNode data = head.getNext().getNext().getNext().getNext().getNext();
        DNode temp = head.getNext().getNext();

        temp.setNext(temp.getNext().getNext());
        temp.getNext().setNext(temp.getNext().getPrev());
        temp.getNext().setPrev(temp);
        temp.getNext().getNext().setPrev(temp.getNext());
        temp.getNext().getNext().setNext(data);


    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numIntsLeft = 6;
        doubleLinkedList doubleLL = new doubleLinkedList();

        //Adding to list
        System.out.println("Adding to Double Linked List...");
        doubleLL.add(3);
        doubleLL.print();
        doubleLL.add(5);
        doubleLL.print();
        doubleLL.add(7);
        doubleLL.print();
        doubleLL.add(9);
        doubleLL.print();
        doubleLL.add(11);
        doubleLL.print();
        doubleLL.add(13);
        doubleLL.print();

        //Swapping 9 and 11
        System.out.println("Before Swap: ");
        doubleLL.print();
        System.out.println("After Swap: ");
        doubleLL.swapNineEleven();
        doubleLL.print();


    }

}
