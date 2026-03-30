class Solution {

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        if(target==0){
            return result;
        }

        dfs(0,nums,new ArrayList<>(),target);

        return result;
    }


    public void dfs(int start,int [] num,List<Integer> temp,int target){

        if(target==0){
            result.add(new ArrayList<>(temp));
        }

        if(target<0){
            return;
        }

        for(int i=start;i<num.length;i++){
            temp.add(num[i]);
            dfs(i,num,temp,target-num[i]);
            temp.remove(temp.size()-1);
        }
    }
}
