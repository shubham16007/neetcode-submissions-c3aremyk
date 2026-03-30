class Solution {
    public boolean canJump(int[] nums) {

        int n=nums.length-1;
        int jump=n;

        for(int i=n;i>=0;i--){

            if( i>=0 && nums[i]+i>=jump){
                jump=i;

            }
        }
        

        return jump==0;
    }
}
