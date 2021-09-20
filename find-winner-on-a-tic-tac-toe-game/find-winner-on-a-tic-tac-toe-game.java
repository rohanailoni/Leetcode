class Solution {
    int n = 3;
    public String tictactoe(int[][] moves) {
        char[][] board = new char[n][n];
        for(int i = 0; i < moves.length; i++){
            int row = moves[i][0];
            int col = moves[i][1];
            if((i & 1) == 0){
                //even, X's move
                board[row][col] = 'X';
                if(didWin(board, row, col, 'X')) return "A";
            }else{
                //odd, O's move
                board[row][col] = 'O';
                if(didWin(board, row, col, 'O')) return "B";
            }
        }
        return moves.length == n * n ? "Draw" : "Pending";
    }
    
    private boolean didWin(char[][] board, int row, int col, char player){
        //check the current row
        boolean didPlayerWin = true;
        for(int i = 0; i < n; i++){
            if(board[row][i] != player){
                didPlayerWin = false;
            }                
        }
        if(didPlayerWin) return true;   //player has won the game
        
        //check the current col
        didPlayerWin = true;
        for(int i = 0; i < n; i++){
            if(board[i][col] != player){
                didPlayerWin = false;
            }                
        }
        if(didPlayerWin) return true;   //player has won the game
        
        //check the diagonal
        if(row == col){
            didPlayerWin = true;
            for(int i = 0; i < n; i++){
                if(board[i][i] != player){
                    didPlayerWin = false;
                }                
            }
            if(didPlayerWin) return true;   //player has won the game    
        }
        
        //check reverse diagonal
        if(col == n - row - 1){
            didPlayerWin = true;
            for(int i = 0; i < n; i++){
                if(board[i][n-i-1] != player){
                    didPlayerWin = false;
                }                
            }
            if(didPlayerWin) return true;   //player has won the game    
        }
        
        //player did not win
        return false;
    }
}