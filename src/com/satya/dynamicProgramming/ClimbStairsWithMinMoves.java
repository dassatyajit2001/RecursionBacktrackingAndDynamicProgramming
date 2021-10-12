package com.satya.dynamicProgramming;

import java.util.Scanner;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-variable-jumps-official/ojquestion
 *
 */
public class ClimbStairsWithMinMoves {
    public static void main(String[] args) {
//        Scanner scn=new Scanner(System.in);
//        int n=scn.nextInt();
//        int[] arr=new int[n];
//        for(int i=0;i<n;i++){
//            arr[i]=scn.nextInt() ;
//        }
    //    System.out.println(minCostClimbingStairsApproach1(new int[3,2,4,2,0,2,3,1,2,2]));
          System.out.println(minCostClimbingStairsApproach1(new int[]{3,3,0,2,1,2,4,2,0,0}));

    }
    /**
     * Space Complexity O(n)
     * Time Complexity O(n)
     * @param moves
     * @return
     */
    public static int minCostClimbingStairsApproach1(int[] moves) {
        int n = moves.length + 1;
        //initialise dp array to hold stair n in array
        int[] dp = new int[n];
        // The minimum cost to reach nth stair from nth stair=0
        dp[n-1] = 0;
        //iterate and solve for bigger sub problems
        for (int i = n - 2; i >= 0; i--) {
            //if moves[i] has 0 then skip it as we cant go anywhere from here
            if(moves[i]==0){
                dp[i]=0;
            }
            //Boundary condition: if from the ith position using the jumps in moves[i] we can go till end or beyond that
            //then its 1 move.
           else if(i+moves[i]>=n-1){
               dp[i]=1;
           }
           //for other cases
           else{
                int minMove=Integer.MAX_VALUE;
               for(int j=1;j<=moves[i];j++){
                   //solve only for those values where value inside dp is not 0
                   //as 0 means no moves
                   if(dp[i+j]!=0) {
                       //get the min moves of currentJump(1) + dp[i+j] or lastMin value
                       minMove = Math.min(dp[i + j] + 1, minMove);
                   }
               }
               if(minMove==Integer.MAX_VALUE)
                   minMove=0;
               //store the min moves value in dp
                dp[i]=minMove;
           }
        }
        //return final answer
    return dp[0];
    }
}
