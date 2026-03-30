class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left=0;
        int right=numbers.length-1;

        while(left<right){

            int complement=numbers[left]+numbers[right];

            if(complement==target){
                return new int[]{left+1,right+1};
            }

            if(complement<target){
                left++;
            }else{
                right--;
            }
        }
        
        return new int[2];
    }
}
