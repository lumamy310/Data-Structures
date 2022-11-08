package LinkedList;

import java.util.ArrayList;

public class queue {

    ArrayList<Integer> queue;
    int rear = -1;
    int front = -1;
    int size;

    public queue(int size){
        this.size = size;
        this.queue = new ArrayList<Integer>(size);
    }

    public void insert(int input){
        if(rear + 1 == size){
            System.out.println("Queue is size 0");
        }
        if(queue.isEmpty()){
            front = 0;
            rear = 0;
            queue.add(input);
        }
        else{
            rear++;
            if(queue.size() > rear){
                queue.set(rear, input);
            }
            else
                queue.add(input);
        }
    }

    public void delete(){
        if(rear == -1){
            System.out.println("Queue is empty.");
        }
        else if(front == rear) {
            front++;
        }
        else{
            queue.remove(front);
            rear--;
        }
    }

    public String print(){
        if(rear == -1){
            return "[ ]";
        }
        String str = "[ ";
        for(int i = front; i< rear; i++){
            str += String.valueOf(queue.get(i)) + " ";
        }
        str += String.valueOf(queue.get(rear)) + " ]";
        return str;
    }

    public static void main(String[] args){
        queue s1 = new queue(5);
        System.out.print("Queue: ");
        System.out.println(s1.print());
        s1.insert(1);
        System.out.println("Inserting a 1... ");
        System.out.println(s1.print());
        s1.insert(6);
        System.out.println("Inserting a 6... ");
        System.out.println(s1.print());
        s1.insert(12);
        System.out.println("Inserting a 12... ");
        System.out.println(s1.print());
        s1.insert(7);
        System.out.println("Inserting a 7... ");
        System.out.println(s1.print());
        s1.delete();
        System.out.println("Deleting... ");
        System.out.println(s1.print());
        s1.delete();
        System.out.println("Deleting... ");
        System.out.println(s1.print());
    }

}
