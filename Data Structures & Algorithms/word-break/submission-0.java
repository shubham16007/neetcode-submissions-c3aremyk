class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n=s.length();

        int maxLen=0;

        HashSet<String> set=new HashSet<>(wordDict);


        for(String k:set){
            maxLen=Math.max(k.length(),maxLen);
        }


        boolean[]dp=new boolean[n+1];
        dp[0]=true;


        for(int i=1;i<=n;i++){

            for(int j=i-1;j>=Math.max(0,i-maxLen);j--){

                if(dp[j] && set.contains(s.substring(j,i))){

                    dp[i]=true;
                    break;
                }
            }
        }
        

        return dp[n];


    }
}
