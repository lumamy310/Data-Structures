package LinkedList;

import java.util.ArrayList;

public class stack {

    ArrayList<Integer> stack;
    int top = -1;
    int size;

    public stack(int size){
        this.size = size;
        this.stack = new ArrayList<Integer>(size);
    }

    public void push(int input){
        if(top + 1 == size){
            System.out.println("Stack overflow");
        }
        else{
            top = top + 1;
            if(stack.size() > top){
                stack.set(top, input);
            }
            else
                stack.add(input);
        }
    }

    public void pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
        }
        else {
            stack.remove(top);
            top--;
        }
    }

    public String print(){
        if(top == -1){
            return "[ ]";
        }
        String str = "[ ";
        for(int i=0; i<top; i++){
            str += String.valueOf(stack.get(i)) + " ";
        }
        str += String.valueOf(stack.get(top)) + " ]";
        return str;
    }

    public static void main(String[] args){
        stack s1 = new stack(5);
        System.out.print("Stack: ");
        System.out.println(s1.print());
        s1.push(1);
        System.out.println("Pushing a 1... ");
        System.out.println(s1.print());
        s1.push(6);
        System.out.println("Pushing a 6... ");
        System.out.println(s1.print());
        s1.push(12);
        System.out.println("Pushing a 12... ");
        System.out.println(s1.print());
        s1.push(7);
        System.out.println("Pushing a 7... ");
        System.out.println(s1.print());
        s1.pop();
        System.out.println("Popping... ");
        System.out.println(s1.print());
        s1.pop();
        System.out.println("Popping... ");
        System.out.println(s1.print());
    }

}
