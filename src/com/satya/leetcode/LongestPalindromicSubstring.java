package com.satya.leetcode;

/**
 * 5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        //define dp n*n matrix
        boolean[][] dp=new boolean[s.length()][s.length()];
 //       int maxLen=0;
        String result="";
        //We have to process the dp diagonally and solve for upper diagonals
        //dist is the distance between 2 characters in  a string, starts with 0 and goes till s.length
        for(int dist=0;dist<s.length();dist++){
            //the computation starts at 0th row and ends in s.length-1 column moving diagonally upwards
            for(int i=0,j=dist;i<s.length() && j<s.length();i++,j++){
                //solve for single character, which is Palindrom by itself.Characters in The biggest diagonal in matrix
                if(dist==0) {
                    dp[i][j] = true;
                    result=String.valueOf(s.charAt(i));
                }
                //if dist==1 means comparing length of string with 2 characters only
                //check if both the characters are equal then its palindromic
                else if(dist==1 && s.charAt(i)==s.charAt(j)) {
                    dp[i][j] = true;
                    result=s.substring(i,i+2);
                }
                //for rest cases check the 1st and last character if they are equal get the value
                // from dp for rest of the middle characters from the 1 less diagonally corner cell from current cell
                else if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                    // if the new found palindrom is greater than last result palindrom length
                    //then replace the result
                    if(result.length()<j-i+1)
                        result =s.substring(i,j+1);
                }
            }
        }
        return result;
    }
}
