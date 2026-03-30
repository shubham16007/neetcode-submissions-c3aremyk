class Solution {
    public int maxArea(int[] heights) {
        
        int left=0;
        int right=heights.length-1;
        int maxLen=0;


        while(left<right){

        int h=right-left;
        int w=Math.min(heights[left],heights[right]);

        int area=h*w;

        maxLen=Math.max(maxLen,area);

        if(heights[left]<heights[right]){
            left++;
        }else{
            right--;
        }

        }

        return maxLen;
    }
}
