class Solution {
    public int maxProfit(int[] prices) {

        int profit=0;
        int candidate=Integer.MAX_VALUE;


        for(int price:prices){

            if(price<candidate){
                candidate=price;
            }

            profit=Math.max(profit,price-candidate);

        }

        return profit;
        
    }
}
