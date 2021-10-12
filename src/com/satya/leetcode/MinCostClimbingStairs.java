package com.satya.leetcode;

/**
 * 746. Min Cost Climbing Stairs
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairsApproach2(new int[]{10,15,20}));
        System.out.println(minCostClimbingStairsApproach2(new int[]{1,100,1,1,1,100,1,1,100,1}));

    }

    /**
     * Space Complexity O(1)
     * Time Complexity O(n)
     * @param cost
     * @return
     */
    public static int minCostClimbingStairsApproach2(int[] cost) {
        //iterate from n-3 step as from there we can calculate the min cost.
        //Why n-3? if we start from i=n-2 or i=n-1 then we anyways have to pay the cost
        // of of cost[n-1] or cost[n-2] as we start from that
        for (int i = cost.length-3; i >= 0; i--) {
            //Calculate the min Cost from i+1 and i+2 steps and add it to its own cost i.e, cost[i]
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        //return the min of 0 and 1st step
        return Math.min(cost[0],cost[1]);
    }

    /**
     * Space Complexity O(n)
     * Time Complexity O(n)
     * @param cost
     * @return
     */
    public static int minCostClimbingStairsApproach1(int[] cost) {
        int n = cost.length + 1;
        //initialise dp array to hold stair n in array
        int[] dp = new int[n];
        // The minimum cost to reach nth stair from nth stair=1
        dp[n-1] = 1;
        //iterate and solve for bigger sub problems
        for (int i = n - 2; i >= 0; i--) {
            //base condition if step is 1 or 2 less than final destination step then dp[i] will hold cost[i]
            //as we have to pay the cost to start from step i and from there we can reach i+1 and i+2 (final step)
            if (i >= n - 3)
                dp[i] = cost[i];
            else {// for non base condition
                // this will calculate the minimum cost of i+1 or i+2 and add it to cost of starting from ith step
                dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
            }
        }
        //return the min of 0 and 1st step
        return Math.min(dp[0], dp[1]);
    }
}
