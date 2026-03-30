class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set=new HashSet<>(wordDict);
        int n=s.length();

        int maxLen=0;

        for(String str:set){
            maxLen=Math.max(str.length(),maxLen);
        }

        boolean []dp=new boolean[n+1];

        dp[0]=true;

        for(int i=1;i<=n;i++){

            for(int j=i-1;j>=Math.max(0,i-maxLen);j--){

                if(dp[j]==true && set.contains(s.substring(j,i))){

                    dp[i]=true;
                    break;
                }
            }
        }
        

        return dp[n];
    }
}
