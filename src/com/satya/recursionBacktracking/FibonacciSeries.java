package com.satya.recursionBacktracking;

/**
 * Prints the fibonacci series up to a given length;
 * The Fibonacci sequence is a set of numbers that starts with a one or a zero,
 * followed by a one, and proceeds based on the rule that each
 * number (called a Fibonacci number) is equal to the sum of the preceding or previous two numbers.
 * The simplest is the series for n=7 (0, 1,)-> 1, 2, 3, 5, 8, 13, 21 etc.
 */
public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println(fibonacciSeries(7));
    }

    /**
     *Calculates the fibonacci number
     * Time complexity 2^n. Each call generates 2 separate recursive calls
     * @param n
     * @return
     */
    public static int fibonacciSeries(int n){
        //given base condition for 0 or 1 return 1
        if(n<2)
            return 1;
        // call for function with n-1 and n-2 as per
        // (fib number is equal to the sum of the preceding or previous two numbers.)
        return fibonacciSeries(n-1)+fibonacciSeries(n-2);
    }
}
