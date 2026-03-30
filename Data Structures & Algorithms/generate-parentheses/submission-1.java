class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result=new ArrayList<>();

        if(n<1) return result;

        dfs(n,0,0,"",result);

        return result;
        
    }

    public void dfs(int n,int open ,int close, String c, List<String> result){

        if(c.length()==2*n){
            result.add(c);
        }

        if(open<n){
            dfs(n,open+1,close,c+"(",result);
        }

        if(close<open){
            dfs(n,open,close+1,c+")",result);
        }



    }
}
