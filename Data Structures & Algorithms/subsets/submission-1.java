class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result=new ArrayList<>();

        dfs(0,nums,new ArrayList<>(),result);

        return result;
        
    }

    public void dfs(int start,int[] nums,List<Integer> list,List<List<Integer>> result){

        result.add(new ArrayList<>(list));

        for(int i=start;i<nums.length;i++){

            list.add(nums[i]);
            dfs(i+1,nums,list,result);
            list.remove(list.size()-1);
        }


    }
}
