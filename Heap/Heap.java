package Heap;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Heap {

    public int heapSize;
    public ArrayList<Integer> elements;


    //generate 'numElements' values in 'range' for heap - random
    public static ArrayList<Integer> generateRandomElements(int numElements, int range){
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for(int i=0; i<numElements; i++){
            int element = rand.nextInt(range + 1);
            list.add(element);
        }
        return list;
    }

    public int getParent(int i){
        return (i-1)/2;
    }

    public int getLeft(int i){
        return (2*i) + 1;
    }

    public int getRight(int i){
        return (2*i) + 2;
    }

    public ArrayList<Integer> getElements() {
        return elements;
    }

    public void minHeapify(ArrayList<Integer> A, int i){
        int smallest;
        int temp;

        int l = getLeft(i);
        int r = getRight(i);
        if(l <= heapSize && A.get(l) < A.get(i))
            smallest = l;
        else
            smallest = i;
        if(r <= heapSize && A.get(r) < A.get(smallest))
            smallest = r;
        if(smallest != i){
            temp = A.get(smallest);
            A.set(smallest, A.get(i));
            A.set(i, temp);
            minHeapify(A, smallest);
        }
    }

    public void buildMinHeap(ArrayList<Integer> A){
        heapSize = A.size()-1;
        for(int i = (A.size()/2) - 1; i >= 0; i--){
            minHeapify(A, i);
        }
    }

    public Heap(ArrayList<Integer> elms, int type){
        if(type == 0) {
            elements = elms;
            buildMinHeap(elements);
        }
        else{
            elements = new ArrayList<Integer>();
            heapSize = elms.size()-1;
            for(int i=0; i<elms.size(); i++){
                elements.add(elms.get(i));
            }
            for(int i = (elements.size()/2) - 1; i >= 0; i--){
                minHeapify(elements, i);
            }
        }
    }

    public static void main(String[] args){
        //for best results use 10000000 for input
        //any larger takes too long, any smaller gives too small values
        //run multiple times as the values are randomly generated each run
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int numElements = obj.nextInt();
        long startTime;
        long endTime;
        long totalTime;
        long linearRandomTime;
        long linearStLTime;
        long linearLtSTime;
        long obyRandomTime;
        long obyStLTime;
        long obyLtSTime;
        ArrayList<Integer> randomList = generateRandomElements(numElements, 20);
        ArrayList<Integer> listStL = new ArrayList<>(randomList);
        ArrayList<Integer> listLtS = new ArrayList<>(randomList);
        Collections.sort(listStL);
        Collections.sort(listLtS);
        Collections.reverse(listLtS);
        System.out.println("Building Linear Heaps:");

        //building heap in linear time - randomized
        startTime = System.currentTimeMillis();
        Heap linearRandom = new Heap(randomList, 0);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        linearRandomTime = totalTime;
        System.out.println("Heap built in linear time with random elements = " + totalTime + " milliseconds");

        //building heap in linear time - smallest to largest
        startTime = System.currentTimeMillis();
        Heap linearStL = new Heap(listStL, 0);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        linearStLTime = totalTime;
        System.out.println("Heap built in linear time with elements sorted smallest to largest represented as an array = " +
                totalTime + " milliseconds");

        //building heap in linear time - largest to smallest
        startTime = System.currentTimeMillis();
        Heap linearLtS = new Heap(listLtS, 0);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        linearLtSTime = totalTime;
        System.out.println("Heap built in linear time with elements sorted largest to smallest represented as an array = " +
                totalTime + " milliseconds");




        System.out.println("Building Heaps Element By Element:");

        //building heap element by element - randomized
        startTime = System.currentTimeMillis();
        Heap obyRandom = new Heap(randomList, 1);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        obyRandomTime = totalTime;
        System.out.println("Heap built element by element  with random elements represented as an array = " +
                totalTime + " milliseconds");

        //building heap element by element - smallest to largest
        startTime = System.currentTimeMillis();
        Heap obyStL = new Heap(listStL, 1);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        obyStLTime = totalTime;
        System.out.println("Heap built element by element with elements sorted smallest to largest represented as an array = " +
                totalTime + " milliseconds");

        //building heap element by element  - largest to smallest
        startTime = System.currentTimeMillis();
        Heap obyLtS = new Heap(listLtS, 1);
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        obyLtSTime = totalTime;
        System.out.println("Heap built element by element with elements sorted largest to smallest represented as an array = " +
                totalTime + " milliseconds" + '\n');




        ArrayList<Long> times = new ArrayList<>();
        times.add(linearRandomTime);
        times.add(linearLtSTime);
        times.add(linearStLTime);
        times.add(obyRandomTime);
        times.add(obyLtSTime);
        times.add(obyStLTime);
        ArrayList<String> names = new ArrayList<>();
        names.add("Linear Random");
        names.add("Linear Largest to Smallest");
        names.add("Linear Smallest to Largest");
        names.add("One by One Random");
        names.add("One by One Largest to Smallest");
        names.add("One by One Smallest to Largest");
        long difference;

        for(int i=0; i<times.size(); i++){
            for(int j=0; j<times.size(); j++){
                if(i == j){
                    //do nothing
                }
                else if(times.get(i) > times.get(j)){
                    difference = times.get(i) - times.get(j);
                    System.out.println(names.get(i) + " was " + Math.abs(difference) + " milliseconds slower than " + names.get(j));
                }
                else if(times.get(i) == times.get(j)){
                    System.out.println(names.get(i) + " took the same amount of time as " + names.get(j));
                }
                else if(times.get(i) < times.get(j)){
                    difference = times.get(i) - times.get(j);
                    System.out.println(names.get(i) + " was " + Math.abs(difference) + " milliseconds faster than " + names.get(j));
                }
            }
        }


    }

}
