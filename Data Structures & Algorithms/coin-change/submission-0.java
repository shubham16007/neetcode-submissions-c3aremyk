class Solution {
    public int coinChange(int[] coins, int amount) {

        int minDp[]=new int[amount+1];

        
        for(int i=1;i<amount+1;i++){
        
         minDp[i]=Integer.MAX_VALUE;

         for(int coin:coins){
        
            if(coin<=i && minDp[i-coin]!=Integer.MAX_VALUE ){

                minDp[i]=Math.min(minDp[i],minDp[i-coin]+1);
            }
         }

        }


        return minDp[amount]==Integer.MAX_VALUE?-1:minDp[amount];
        
    }
}
