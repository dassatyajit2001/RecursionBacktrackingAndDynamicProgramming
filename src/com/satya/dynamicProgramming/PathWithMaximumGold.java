package com.satya.dynamicProgramming;

/**
 * https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/goldmine-official/ojquestion
 *
 */
public class PathWithMaximumGold {
    private  boolean[][] visited;
    int nRow, nCol;
    int finalGoldCount,currGoldCount;
    int[] xs = {0, -1, 0, 1};
    int[] ys = {-1, 0, 1, 0};

    public int getMaximumGold(int[][] grid) {
        nRow=grid.length;
        nCol=grid[0].length;
        visited=new boolean[nRow][nCol];
        //running for each cell
        for(int i=0;i< nRow;i++){
            for(int j=0; j<nCol;j++){
                if(grid[i][j]>0) {
                    //    visited=new boolean[nRow][nCol];
                    dfs(grid, i, j);
                    // finalGoldCount = Math.max(finalGoldCount, currGoldCount);
                    currGoldCount = 0;
                }
            }
        }
        //return gold count
        return finalGoldCount;
    }

    /**
     * DFS for an array
     * @param grid
     * @param x
     * @param y
     *
     */
    private void dfs(int[][] grid,int x,int y){
        //mark as visited
        visited[x][y]=true;
        //get the current count of gold
        currGoldCount+=grid[x][y];
        //for all 4 directions call dfs
        for(int i=0;i<4;i++){
            int row=x+xs[i];
            int col=y+ys[i];
            //check to see if DFS can be called or not where grid is not visited and grid has some gold
            if(row<= nRow-1 && col<= nCol-1 && row>=0 && col>=0 && !visited[row][col] && grid[row][col]>0)
                dfs(grid,row,col);
        }
        //compute the finalGoldCount when back tracking. Because the maximum count is just before backtracking
        finalGoldCount = Math.max(finalGoldCount, currGoldCount);
        //Subtract the currGoldCount while back tracking
        currGoldCount-=grid[x][y];
        //reset for back track
        visited[x][y]=false;
    }
}
