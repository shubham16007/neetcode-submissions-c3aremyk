class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set=new HashSet<>();

        for(int i=0;i<board.length;i++){

            for(int j=0;j<board[0].length;j++){

                if(board[i][j]=='.'){
                    continue;
                }

                char c=board[i][j];

                String row=c+"row"+i;
                String col=c+"col"+j;
                String box=c+"i/3"+i/3+"j/3"+j/3;

                if(!set.add(row)) return false;
                if(!set.add(col)) return false;
                if(!set.add(box)) return false;


            }
        }
        
        return true;
    }
}
