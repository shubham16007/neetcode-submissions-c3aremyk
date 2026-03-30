class Solution {
    public int jump(int[] nums) {

        int farthest=Integer.MIN_VALUE;
        int count=0;
        int current=0;

        int n=nums.length;

        for(int i=0;i<n-1;i++){

            farthest=Math.max(farthest,nums[i]+i);

            if(current==i){
                current=farthest;
                count++;
            }

        }

        return count;
        
    }
}
