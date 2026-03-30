class Solution {
    public int rob(int[] nums) {

        int prev1=0;
        int prev2=0;


        for(int n:nums){


            int curr=Math.max(prev2+n,prev1);
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
        
    }
}
