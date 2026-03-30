class Solution {
    public int jump(int[] nums) {

        int farthest=Integer.MIN_VALUE;
        int current=0;
        int count=0;
        

        for(int i=0;i<nums.length-1;i++){

            farthest=Math.max(farthest,nums[i]+i);

            if(current==i){
                current=farthest;
                count++;
            }
        }
        
        return count;
    }
}
