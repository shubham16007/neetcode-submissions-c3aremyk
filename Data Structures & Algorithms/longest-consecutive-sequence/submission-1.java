class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set=new HashSet<>();

        for(int n:nums){
            set.add(n);
        }


       // int count=0;

        int maxLen=0;

        for(int s:set){

            if(!set.contains(s-1)){
                int count=0;

                while(set.contains(count+s)){
                    count++;
                }
                maxLen=Math.max(maxLen,count);

            }
            
        }

        return maxLen;
        
    }
}
