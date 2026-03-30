class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int [] T=new int[nums.length];


        for(int i=1;i<nums.length;i++){

            for(int j=0;j<i;j++){

                if(nums[i]>nums[j]){

                    if(T[j]+1>T[i]){
                        T[i]=T[j]+1;
                    }
                }
            }
        }

        int max=0;

        for(int n:T){
            max=Math.max(max,n);
        }

        return max+1;
    }
}
