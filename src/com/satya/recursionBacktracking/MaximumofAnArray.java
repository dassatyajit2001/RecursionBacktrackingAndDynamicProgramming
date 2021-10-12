package com.satya.recursionBacktracking;

/**
 * Find maximum of an array using recursion
 */
public class MaximumofAnArray {
    public static void main(String[] args) {
        int arr[]={45,33,54,67,94,65,33,22};
        System.out.println(findMax(arr,0));
    }
    public static int findMax(int[] arr, int index){
        //if index reached its limit return the min value as we need to find max value
        if(index== arr.length)
            return Integer.MIN_VALUE;
        //call for n-1 terms
        int val=findMax(arr,index+1);
        //return the max of returned val and the current index val
        return Math.max(val,arr[index]);
    }
}
