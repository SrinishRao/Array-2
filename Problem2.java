// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        //1-->0 (2)
        //0-->1 (3)
        int m = board.length; int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = countLives(board, i, j, m, n);
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    //rule 1 & rule 3
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && count == 3){
                    //rule 4
                    board[i][j] = 3;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
    private int countLives(int[][] board, int i, int j, int m, int n){
        int result = 0;
        int [][] dirs ={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int [] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(r>=0 && r<m && c>=0 && c<n && (board[r][c] ==1 || board[r][c] == 2)){
                result++;
            }
        }
        return result;
    }
}

