package com.satya.dynamicProgramming;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/count-palindromic-subsequence-given-string/
 */
public class CountPalindromicSubsequencesWithDuplicatePending {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int len = 0; len < n; len++) {
            for (int i = 0, j = len; j < n; i++, j++) {
                if (len == 0)
                    dp[i][j] = 1;
                else if (len == 1) {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = 3;
                    else
                        dp[i][j] = 2;
                } else {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                    else
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }
        return dp[0][n-1];
    }
}
