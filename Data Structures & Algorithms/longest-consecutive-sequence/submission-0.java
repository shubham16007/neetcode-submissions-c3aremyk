class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set=new HashSet<>();

        for(int n:nums){
            set.add(n);
        }

        int maxLen=0;
        
        for(int n:set){

            if(!set.contains(n-1)){

                int count=0;

                while(set.contains(n+count)){

                    count++;
                }

                maxLen=Math.max(maxLen,count);
            }

        }

        return maxLen;
        
    }
}
