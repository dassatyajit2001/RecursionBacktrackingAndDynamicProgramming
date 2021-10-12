package com.satya.recursionBacktracking;

/**
 * takes a base number and the power number returns number^power
 */
public class PrintPowerOfaNumber {
    public static void main(String[] args) {
//        System.out.println(power(5,3));
//        System.out.println(power(10,5));
//        System.out.println(power(2,0));
//        System.out.println(power(2,5));
//        System.out.println(powerLog(2,4));
        System.out.println(power(2,100));
    }

    /**
     * Takes the inputs and calculates the power of a given number
     * Time and space complexity of o(power)
     *
     * @param num
     * @param power
     * @return
     */
    public static int power(int num,int power){
       //base condition when power is equal to 0 return 1
        if(power==0)
            return 1;
        //recursion call for power from given value to 0
        int result=power(num,power-1);
        //in post fix multiply num to the result
        result*=num;
        return result;
    }

    /**
     * Takes the inputs and calculates the power of a given number
     * if power is even then k^p=k^(p/2)*k^(p/2)
     * if power is odd then k^p=k^(p/2)*k^(p/2) * k(extra multilied by k as it is odd)
     * Time and space complexity of o(log(p))
     *
     * @param num
     * @param power
     * @return
     */
    public static int powerLog(int num,int power){
        //base condition when power is equal to 0 return 1
        if(power==0)
            return 1;
        //recursion call for power from given value to 0.
        int val1=powerLog(num,power/2);
        int result=val1*val1;
        if(power%2==1)// measn it is odd then multiply an extra
            result*=num;
        return result;
    }
}
