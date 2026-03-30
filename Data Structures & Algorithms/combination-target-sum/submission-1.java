class Solution {

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        

        if(target==0) return result;

        dfs(0,nums,new ArrayList<>(),target);

        return result;
    }


    public void dfs(int start,int[]nums,List<Integer> temp,int target){

        if(target==0){
            result.add(new ArrayList<>(temp));
        }

        if(target<0){
            return;
        }


        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(i,nums,temp,target-nums[i]);
            temp.remove(temp.size()-1);
        }

    }
}
