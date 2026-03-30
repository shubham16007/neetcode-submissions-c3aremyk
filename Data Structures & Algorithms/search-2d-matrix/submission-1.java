class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n=matrix.length;
        int m=matrix[0].length;

        int N=n*m;

        int left=0;
        int right=N-1;

        while(left<=right){

            int mid=left+(right-left)/2;

            int row=mid/m;
            int col=mid%m;

            int val=matrix[row][col];

            if(val==target){

                return true;
            }

            if(val<target){
                left=mid+1;
            }else{
                right=mid-1;
            }


        }
        
        return false;
    }
}
