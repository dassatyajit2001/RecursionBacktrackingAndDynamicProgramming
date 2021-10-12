package com.satya.recursionBacktracking;
/**
 * Prints the number in decreasing and increasing order starting from n to 1 and then from 1 to n using recursion
 */
public class PrintDecreasingIncreasing {
    public static void main(String[] args) {
        printDecreasing(10);
    }

    /**
     * This used complexity of o(n)
     * @param n
     */
    public  static void printDecreasing(int n){
        //return when base case is encountered
        if(n==0)
            return;
        // printed before the recursive call because, the program needs to print from n to 1.
        // hence prefix print is used. Operation carried out while recursion call grows/goes up
        System.out.println(n);
        //recursion call for n-1
        printDecreasing(n-1);
        // printed after the recursive call because, the program needs to print from 1 to n.
        // hence postfix print is used. Operation carried out while recursion returns/comes back
        System.out.println(n);
    }
}
