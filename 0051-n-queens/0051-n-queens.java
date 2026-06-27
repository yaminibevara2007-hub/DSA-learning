class Solution {
    public List<List<String>> solveNQueens(int n) {

        char board[][] = new char[n][n];
        List<List<String>> ans = new ArrayList<>();

        for(int i =0;i<board.length;i++){
            Arrays.fill(board[i] , '.');
        }
       
       solve(board , 0 ,ans);
       return ans;
    }
   private static void solve(char board[][] , int row ,List<List<String>> ans){

        if(row == board.length) {
            ans.add(building(board));
            return;
        }

        for(int col =0; col < board[0].length;col++){

            if(IsSafe(board , row , col)){
                board[row][col]='Q';

                solve(board , row + 1 , ans);

                board[row][col] = '.';
            }
        }

   }
        private static boolean IsSafe(char board[][],int row,int col){

            int r  = row;
            int c = col;

            while(r >= 0){
                if(board[r][c] == 'Q') return false;

                r--; 
            }
            r = row-1;
            c = col-1;
            // upper left
            while(r >= 0 && c >=0  ){
                if(board[r][c] == 'Q') return false;
                c--;
                r--; 
            }

            r = row-1;
            c = col+1;
            // upper right
            while(r >= 0 && c < board[0].length ){
                if(board[r][c] == 'Q') return false;
                c++;
                r--; 
            }
            return true;
        }

        private static List<String> building(char board[][]){
            List<String> temp = new ArrayList<>();

            for(char n[] : board){
                temp.add(new String(n));
            }
            return temp;
        }

}