package com.satya.recursionBacktracking;

/**
 * Given a stair, a person standing on the top of the stairs can reach the bottom of the stairs
 * by either 1 or 2 jumps. Find all counts of such jump combinations that he can reach the bottom of stairs
 *
 * Say there are 3 stairs then number or ways are
 * 1) 1->1->1
 * 2) 1->2
 * 3) 2->1
 *
 *
 */
public class AllStairsPath {

    /**
     * Recursive method which computes the total number of ways one can reach the bottom of the stairs
     * @param stairs
     * @return
     */
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
