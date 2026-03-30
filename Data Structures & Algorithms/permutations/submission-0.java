class Solution {

     List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

       

        if(nums.length<1) return result;

        boolean[] visited= new boolean[nums.length];

        dfs(nums,visited,new ArrayList<>());

        return result;
        
    }


    public void dfs(int[] nums,boolean[] visited,List<Integer> list){

        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
        
            if(visited[i]==true){
                continue;
            }

            list.add(nums[i]);
            visited[i]=true;
            dfs(nums,visited,list);
            visited[i]=false;
            list.remove(list.size()-1);

        }


    }
}
