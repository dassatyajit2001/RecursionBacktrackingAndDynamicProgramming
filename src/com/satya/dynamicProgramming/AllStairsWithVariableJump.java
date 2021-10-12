package com.satya.dynamicProgramming;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-variable-jumps-official/ojquestion
 */
public class AllStairsWithVariableJump {
    /**
     * Iterative way using DP. The basic idea is use tabulation to solve the sub problems
     * 1) Build the array of size n+1 because n also to be included in the array. int[] dp=new int[n+1]
     * 2) Solve the lowest problem 1st and then solve for bigger problems
     *     a) populate dp for dp[0] and dp[1]
     * 3) Move up the ladder for bigger problem and solve using the smaller problems
     *     a) when in position dp[x], get the value of dp[x-1],dp[x-2]
     *     b) the sum of dp[x-1],dp[x-2] is value for dp[x]. Make sure you check boundary condition of array
     *
     * @param n
     * @return
     */
    public int climbStairsDP(int[] arr,int n) {

        int[] dp=new int[n+1];
        //This is the base case as question says we have to reach stairs n from stairs 0
        //Only one way of going from nth stair to nth stair is 1 way.
        dp[n]=1;
        //solve for bigger sub problems we come from larger value to smaller value
        for(int i=n-1;i>=0;i--){
            //this for loop is used on how many jumps can we make using arr[i] value
            //example if arr[i]==3 then we can jump to i+1,i+2,i+3
            //check boundary condition too '&& i+j<n'
            for(int j=1;j<=arr[i] && i+j<n;j++){
                    dp[i]+=dp[i+j];
            }
        }
        //this will store the final result
        return dp[0];
    }
}
