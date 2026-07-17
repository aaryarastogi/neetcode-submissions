class Solution {
    public boolean isValid(int i , int j , char[][] board){
        //us row me
        for(int k = 0 ; k<9; k++){
            if((k!=j) && board[i][k] == board[i][j]) return false;
        }
        //us column me
        for(int k=0;k<9;k++){
            if((k!=i) && board[k][j] == board[i][j]) return false;
        }
        //us square me
        int istart = (i/3) * 3;
        int jstart = (j/3) * 3;

        for(int k=istart;k<istart+3;k++){
            for(int l=jstart;l<jstart+3;l++){
                if(k==i && l==j) continue;
                if(board[k][l] == board[i][j]) return false;
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] != '.' && !isValid(i,j,board)){
                    return false;
                }
            }
        }

        return true;
    }
}
