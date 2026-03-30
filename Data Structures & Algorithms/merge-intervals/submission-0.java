class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length<=1) return intervals;

        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);

        int[] newIntervals=intervals[0];

        List<int[]> result=new ArrayList<>();

        result.add(newIntervals);


        for(int []interval:intervals){

            if(interval[0]<=newIntervals[1]){

                newIntervals[1]=Math.max(newIntervals[1],interval[1]);
            }
            else{
                newIntervals=interval;
                result.add(newIntervals);
            }
        }


        return result.toArray(new int[result.size()][]);
        
    }
}
