package com.satya.recursionBacktracking;

/**
 * Find the 1st index of a given number
 */
public class LastIndexofOccurrence {
        public static void main(String[] args) {
            int arr[]={45,33,54,67,67,65,33,22,99};
            System.out.println(findLast(arr,0,45));
        }
        public static int findLast(int[] arr, int index,int val){
            //if index reached its limit return the min value as we need to find max value
            if(index== arr.length)
                return -1;
            //recursive call to n-1 elements or rest of the index
           int indx=findLast(arr, index + 1, val);
           // Postfix logic as we need to get the highest value while returning from recursion
            if(indx==-1 && arr[index]==val) {
                indx= index;
            }
            return indx;
        }
}
