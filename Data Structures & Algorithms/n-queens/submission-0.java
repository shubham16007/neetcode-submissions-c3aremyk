class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        
        List<String> board=new ArrayList<>();

        for(int i=0;i<n;i++){
            board.add(".".repeat(n));
        }
        
        nQueens(board,0,n);

        return result;
    }

    public void nQueens(List<String> board,int row,int n){

        if(row==n){
            result.add(new ArrayList<>(board));
            return;
        }

        for(int j=0;j<n;j++){

            if(isSafe(board,row,j,n)){

                char [] temp=board.get(row).toCharArray();
                temp[j]='Q';
                board.set(row,new String(temp));

                nQueens(board,row+1,n);

                temp[j]='.';
                board.set(row,new String(temp));
            }

        }

    }

    public boolean isSafe(List<String>board,int row,int col,int n){

        //vertically

        for(int i=0;i<row;i++){
            if(board.get(i).charAt(col)=='Q'){
                return false;
            }
        }


        //left diagonally


        for(int i=row,j=col; i>=0 && j>=0 ; i--,j--){

            if(board.get(i).charAt(j)=='Q'){
                return false;
            }
        }


        //right diagonally

        for(int i=row,j=col;i>=0 && j<n;i--,j++){

            if(board.get(i).charAt(j)=='Q'){
                return false;
            }
        }

        return true;

    }

}
