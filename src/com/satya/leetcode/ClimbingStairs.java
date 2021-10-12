package com.satya.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. Climbing Stairs
 */
public class ClimbingStairs {

  //  --------------------------------Using DP--------------------------------
    /**
     * Iterative way using DP. The basic idea is use tabulation to solve the sub problems
     * 1) Build the array of size n+1 because n also to be included in the array. int[] dp=new int[n+1]
     * 2) Solve the lowest problem 1st and then solve for bigger problems
     *     a) populate dp for dp[0] and dp[1]
     * 3) Move up the ladder for bigger problem and solve using the smaller problems
     *     a) when in position dp[x], get the value of dp[x-1],dp[x-2], dp[x-3]
     *     b) the sum of dp[x-1],dp[x-2], dp[x-3] is value for dp[x]. Make sure you check boundary condition of array
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        //we know when 0 stairs is reached it is 1 way hence dp[0]=1
        dp[0]=1;
        //solve for bigger sub problems
        for(int i=1;i<=n;i++){
            //this will hold the paths
            int sumPathsForI=0;
            //boundary check only for when i=1
            if(i-2>=0) {
                // add the sumPathForI when there is 1 jump with 2 steps, this holds number of ways to go to 0 the step
                sumPathsForI += dp[i - 2];
            }
            // add the sumPathForI when there is 1 jump with 1 step,  this holds number of ways to go to 0 the step
            sumPathsForI+=dp[i-1];
            //dp[i] is the sum of paths of dp[i-1] and dp[i-2]
            dp[i]=sumPathsForI;
        }
        return dp[n];
    }



//    --------------------------------Using Memoization--------------------------------
    Map<Integer,Integer> cache=new HashMap<>();
    /**
     * Recursive method which computes the total number of ways one can reach the bottom of the stairs
     * uses memoization technique for better performance and reduce calls
     * @param n
     * @return
     */
    public int climbStairsMemoize(int n) {
        //if stairs<0 then this step or jump is invalid
        if(n<0)
            return 0;
        //if stairs==0 then its a valid step or jump, increment this by 1 or return value 1
        if(n==0)
            return 1;
        //If value present in cache , then return from cache and dont call recursion
        if(cache.containsKey(n))
            return cache.get(n);
        //recursive call if 1 jump is taken
        int x=climbStairsMemoize(n-1);
        //recursive call if 2 jumps is taken
        int y=climbStairsMemoize(n-2);

        //put in cache the Total paths for n and retrieve from cache
        cache.putIfAbsent(n,x+y);
        return cache.get(n);
    }



//	--------------------------------Using just Recursion--------------------------------
    /**
     * Recursive method which computes the total number of ways one can reach the bottom of the stairs
     * @param stairs
     * @return
     */
    public int climbStairsOnlyRecursion(int stairs) {
        //if stairs<0 then this step or jump is invalid
        if(stairs<0)
            return 0;
        //if stairs==0 then its a valid step or jump, increment this by 1 or return value 1
        if(stairs==0)
            return 1;
        //recursive call if 1 jump is taken
        int x=climbStairsOnlyRecursion(stairs-1);
        //recursive call if 2 jumps is taken
        int y=climbStairsOnlyRecursion(stairs-2);
        //return the sum of paths to reach destination
        return x+y;
    }

}
