class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum=nums[0];
        int curr=nums[0];

        for(int i=1;i<nums.length;i++){
            curr=Math.max(curr+nums[i],nums[i]);
            maxSum=Math.max(curr,maxSum);
        }

        return maxSum;
        
    }
}
