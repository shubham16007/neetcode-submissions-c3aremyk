class Solution {
    public List<List<Integer>> threeSum(int[] nums) {


        int left=0;
        int right=nums.length-1;

        HashSet<List<Integer>> res=new HashSet<>();

        Arrays.sort(nums);


        for(int i=0;i<nums.length;i++){

            left=i+1;
            right=nums.length-1;

            while(left<right){

                int sum=nums[i]+nums[left]+nums[right];

                if(sum==0){

                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }

            }

        }

            return new ArrayList<>(res);        
    }
}
