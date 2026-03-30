class Solution {
       List<List<Integer>>result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

     

        boolean[] visited=new boolean[nums.length];

        dfs(nums,new ArrayList<>(),visited);

        return result;
        
    }


    public void dfs(int[] nums,List<Integer> list,boolean [] visited){

        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){

            if(visited[i]==true) continue;

            list.add(nums[i]);
            visited[i]=true;
            dfs(nums,list,visited);
            visited[i]=false;
            list.remove(list.size()-1);

        }

    }
}
