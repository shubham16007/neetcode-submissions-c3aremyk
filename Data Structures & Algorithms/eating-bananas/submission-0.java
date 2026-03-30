class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int min=1;
        int max=0;

        for(int pile:piles){
            max=Math.max(max,pile);
        }

        while(min<max){

            int mid=min+(max-min)/2;
            if(isEating(piles,mid,h)){
                max= mid;
            }else{
                min=mid+1;
            }
        }

        return min;
        
    }

    public boolean isEating(int [] piles,int speed,int h){

        int hours=0;

        for(int pile:piles){

            hours+=(int)Math.ceil((double)pile/speed);
        }

        return hours<=h;

    }
}
