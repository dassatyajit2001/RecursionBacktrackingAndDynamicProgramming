package com.satya.recursionBacktracking;

/**
 * Prints the number in increasing order starting from 1 to n using recursion
 */
public class PrintIncreasing {
    public static void main(String[] args) {
        printIncreasing(10);
    }

    /**
     * Takes the input which it needs to print from 1-n using recursion
     * Time and space complexity of o(n)
     * @param n
     */
    public  static void printIncreasing(int n){
        //return when base case is encountered
        if(n==0)
            return;
        //recursion call for n-1
        printIncreasing(n-1);
        // printed after the recursive call because, the program needs to print from 1 to n.
        //hence postfix print is used.
        System.out.println(n);
    }
}
