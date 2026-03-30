class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int min=1;
        int max=0;

        for(int n:piles){
            max=Math.max(n,max);
        }

        while(min<max){

            int mid=min+(max-min)/2;

            if(canEat(piles,mid,h)){
                max=mid;
            }else{
                min=mid+1;
            }

        }

        return min;
    }

    public boolean canEat(int[]piles,int speed,int h){

        int hours=0;

        for(int pile:piles){

            hours+=(int)Math.ceil((double)pile/speed);
        }

        return hours<=h;
    }
}
