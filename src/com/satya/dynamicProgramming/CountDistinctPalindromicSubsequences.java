package com.satya.dynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://www.youtube.com/watch?v=fvYlinirmFg&list=TLGGxBXOeJtEUfgxMjEwMjAyMQ&t=1s
 * https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/754057/Evolve-from-recursion-to-dp
 * https://leetcode.com/problems/count-different-palindromic-subsequences/
 *
 *
 */
public class CountDistinctPalindromicSubsequences {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        //the dp array defined
        int[][] dp = new int[n][n];

        //this array is used to store the index of prev occurrence of same character in string
        //example for input string given -----> a m a n q a r a
        //prevArr has {-1,-1,0,-1,-1,2,-1,5}    0 1 2 3 4 5 6 7 (previous occurrence index value in the array)
        int[] prevOccurArr = new int[n];
        //stores the characters that have been encountered till now
        Map<Character, Integer> charCache = new HashMap<>();
        //populate the prevOccurArr
        for (int i = 0; i < n; i++) {
            //if character is present in cache
            if (charCache.containsKey(s.charAt(i))) {
                //get the index of the character
                int index = charCache.get(s.charAt(i));
                //store the prev occurrence of char's index in the array
                prevOccurArr[i] = index;
                //upate the cache
                charCache.put(s.charAt(i), i);
            } else {
                //for 1st time occurance store -1
                charCache.put(s.charAt(i), -1);
            }
        }

        //this array stores the char's index of next occurrence
        int[] nextOccurArr = new int[n];
        charCache.clear();
        //populate the nextOccurArr
        for (int i = n - 1; i > -1; i--) {
            //if character is present in cache
            if (charCache.containsKey(s.charAt(i))) {
                //get the index of the character
                int index = charCache.get(s.charAt(i));
                //store the prev occurrence of char's index in the array
                prevOccurArr[i] = index;
                //upate the cache
                charCache.put(s.charAt(i), i);
            } else {
                //for 1st time occurance store -1
                charCache.put(s.charAt(i), -1);
            }
        }
        for (int len = 0; len < n; len++) {
            for (int i = 0, j = len; j < n; i++, j++) {
                if (len == 0)
                    dp[i][j] = 1;
                else if (len == 1) {
                    dp[i][j] = 2;
                } else {
                    if (s.charAt(i) != s.charAt(j))
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    else {
                        int nextIndexOfChar = nextOccurArr[i];
                        int prevIndexOfChar = prevOccurArr[j];
                        if (prevIndexOfChar > nextIndexOfChar) {//means there 2 same chars present between i & j same as s[i],s[j]
                            dp[i][j] = 2 * dp[i + 1][j - 1] + dp[nextIndexOfChar + 1][prevIndexOfChar - 1];
                        } else if (prevIndexOfChar < nextIndexOfChar) {//no occurance
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        } else {//exactly 1 occurance
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
