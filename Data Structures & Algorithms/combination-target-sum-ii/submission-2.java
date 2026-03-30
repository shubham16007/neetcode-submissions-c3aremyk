class Solution {
    List<List<Integer>>  result=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        if(target==0) return result;

        Arrays.sort(candidates);

        dfs(0,candidates,new ArrayList<>(),target);

        return result;

    }

    public void dfs(int start,int[]candidates,List<Integer> temp,int target){

        if(target==0){
            result.add(new ArrayList<>(temp));
        }

        if(target<0){
            return;
        }

        for(int i=start;i<candidates.length;i++){

            if(i>start && candidates[i]==candidates[i-1]) continue;

            temp.add(candidates[i]);
            dfs(i+1,candidates,temp,target-candidates[i]);
            temp.remove(temp.size()-1);
        }
    }
}
