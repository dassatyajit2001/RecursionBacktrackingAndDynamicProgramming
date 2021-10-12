package com.satya.recursionBacktracking;

/**
 * Prints factorial of a number example 5!= 5*4*3*2*1
 */
public class PrintFactorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    /**
     * Takes the input prints the factorial of the number
     * Time and space complexity of o(n)
     * @param n
     * @return
     */
    public static int factorial(int n){
        //base condition. if n=1 then return 1 as this 1 would be multiplied
        // with other recursive call's return value
        if(n==1)
            return 1;
        //n is multiplied with other recursive calls , when base condition is hit then 1 is returned and that
        //get multiplied with 2 and that with 3 and so on till n.PowerLinear
        int result= n*factorial(n-1);
        return result;
    }
}
