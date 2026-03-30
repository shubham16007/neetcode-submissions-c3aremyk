class Solution {

    List<String> list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n<1) return list;

        dfs(n,0,0,"");

        return list;
        
    }


    public void dfs(int n,int open ,int close,String c){

        if(c.length()==2*n){

            list.add(c);
            return;
        }


        if(open<n){
            dfs(n,open+1,close,c+"(");
        }

        if(close<open){
            dfs(n,open,close+1,c+")");
        }

    }
}
