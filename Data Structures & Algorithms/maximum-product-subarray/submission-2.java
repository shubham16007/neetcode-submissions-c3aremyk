class Solution {
    public int maxProduct(int[] nums) {

        int maxPro=nums[0];
        int minPro=nums[0];
       int result=nums[0];


       for(int i=1;i<nums.length;i++){

            int curr=nums[i];
            
            if(curr<0){

                int temp=maxPro;
                maxPro=minPro;
                minPro=temp;
            }

            maxPro=Math.max(maxPro*curr,curr);
            minPro=Math.min(minPro*curr,curr);

            result=Math.max(maxPro,result);
       }

       return result;
        
    }
}
