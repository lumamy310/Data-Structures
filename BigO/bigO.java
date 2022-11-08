package BigO;

import java.util.Scanner;

public class bigO {

    public static void main(String[] args){
        int n;
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter n: ");
        n = input.nextInt();

        run(n);
    }

    public static void run(int n){
        int counter = 0;
        double someVariable = 0;
//(a)
        for(int i = 0; i < n; i++){
            someVariable = Math.log(someVariable) + 3;
            counter++;
        }
        System.out.println("Passes for a: " + counter);
        counter = 0;
//(b)
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                someVariable = Math.log(someVariable) + 3;
                counter++;
            }
        }
        System.out.println("Passes for b: " + counter);
        counter = 0;
//(c)
        for(int i = 0; i < n; i++){
            for(int j=0; j < i; j++){
                someVariable = Math.log(someVariable) + 3;
                counter++;
            }
        }
        System.out.println("Passes for c: " + counter);
        counter = 0;
//(d)
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(j % 2 == 0){
                    someVariable = Math.log(someVariable) + 3;
                    counter++;
                }
            }
        }
        System.out.println("Passes for d: " + counter);
        counter = 0;
    }

}
