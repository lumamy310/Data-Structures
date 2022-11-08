package LinkedList;

import java.util.Scanner;

public class singleLinkedList {

    private Node head;

    public singleLinkedList(){
        head = null;
    }

    public void print(){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        Node temp = head;
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
        Node temp = new Node();

        //empty
        if(head == null){
            head = new Node(input, null);
            return;
        }

        //top of list
        if(input < head.getData()){
            temp = head;
            head = new Node(input, temp);
            return;
        }

        //middle and bottom of list
        temp = head;
        while(input > temp.getData()){
            if(temp.getNext() == null){
                temp.setNext(new Node(input, null));
                return;
            }
            if(temp.getNext().getData() > input){
                temp.setNext(new Node(input, temp.getNext()));
                return;
            }
            temp = temp.getNext();
        }
    }

    public void swapNineEleven(){
        //Assuming the 9 is located at index 3 and the 11 located at index 4
        Node previousX, previousY, currentX, currentY, pointer;
        currentX = head;
        currentX = currentX.getNext().getNext().getNext();
        currentY = currentX.getNext();
        previousX = head.getNext().getNext();
        previousY = previousX.getNext();

        Node temp = currentY.getNext();
        previousX.setNext(currentY);
        previousX.getNext().setNext(currentX);
        previousX.getNext().getNext().setNext(temp);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numIntsLeft = 6;
        singleLinkedList singleLL = new singleLinkedList();

        //Adding to list
        System.out.println("Adding to Single Linked List...");
        singleLL.add(3);
        singleLL.print();
        singleLL.add(5);
        singleLL.print();
        singleLL.add(7);
        singleLL.print();
        singleLL.add(9);
        singleLL.print();
        singleLL.add(11);
        singleLL.print();
        singleLL.add(13);
        singleLL.print();

        //Swapping 9 and 11
        System.out.println("Before Swap: ");
        singleLL.print();
        System.out.println("After Swap: ");
        singleLL.swapNineEleven();
        singleLL.print();


    }

}
