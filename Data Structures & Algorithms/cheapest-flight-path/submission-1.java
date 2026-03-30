class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int prev[]=new int[n];

        Arrays.fill(prev,Integer.MAX_VALUE);
        prev[src]=0;

        for(int i=0;i<k+1;i++){

            int temp[]=new int[n];

            for(int j=0;j<n;j++){
                temp[j]=prev[j];
            }


            for(int [] flight:flights){


                int u=flight[0];
                int v=flight[1];
                int w=flight[2];

                if(prev[u]!=Integer.MAX_VALUE && prev[u]+w<temp[v]){
                    temp[v]=prev[u]+w;
                }
            }

            prev=temp;
        }

        return prev[dst]==Integer.MAX_VALUE?-1:prev[dst];
    }
}
