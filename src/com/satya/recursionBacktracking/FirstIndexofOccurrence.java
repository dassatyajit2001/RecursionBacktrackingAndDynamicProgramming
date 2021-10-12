package com.satya.recursionBacktracking;

/**
 * Find the 1st index of a given number
 */
public class FirstIndexofOccurrence {
        public static void main(String[] args) {
            int arr[]={45,33,54,67,67,65,33,22,99};
            System.out.println(findFirst(arr,0,100));
        }
        public static int findFirst(int[] arr, int index,int val){
            //if index reached its limit return the min value as we need to find max value
            if(index== arr.length)
                return -1;

            if(arr[index]==val) {
                return index;
            }
            else
                return findFirst(arr, index + 1, val);
        }
}
