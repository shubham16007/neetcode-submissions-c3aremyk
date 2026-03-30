class Solution {
    public int rob(int[] nums) {

        if(nums.length<=1) return nums[0];

        int n=nums.length;

        return Math.max(dfs(nums,1,n-1),dfs(nums,0,n-2));
    }


    public int dfs(int[] nums,int start,int end){

        if(nums.length<=1) return nums[0];

        int prev1=0;
        int prev2=0;

        for(int i=start;i<=end;i++){

            int curr=Math.max(prev2+nums[i],prev1);
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }
}
