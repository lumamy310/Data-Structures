package InsertionSort;

import java.util.ArrayList;
import java.util.Scanner;

public class insertionSort {

    /*
    The insertion sort works by selecting the value at a[1], then moves
    towards the beginning of the array, until it reaches the front of the array or a
    value > the current value. If it reaches a value > the current value,
    the value is shifted to the right, and the old position is replaced with
    the current value.
     */
    public static void sort(ArrayList<Integer> list){
        for(int i=1; i < list.size(); i++){
            int currentValue = list.get(i);
            int j = i - 1;
            while(j >= 0 && list.get(j) > currentValue){
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, currentValue);
        }
    }

    public static void main(String[] args){

        ArrayList<Integer> userInput = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        int numIntsLeft = 5;

        for(int i=0; i<5; i++){
            System.out.print("Please enter an integer: ");
            userInput.add(input.nextInt());
            System.out.println(userInput.toString());
        }

        sort(userInput);
        System.out.println();
        System.out.println("Sorted array: " + userInput.toString());

    }






}
