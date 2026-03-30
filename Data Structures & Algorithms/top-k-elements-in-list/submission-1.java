class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket=new List[nums.length+1];

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        for(int key:map.keySet()){

            int freq=map.get(key);

            
                if(bucket[freq]==null){
                    bucket[freq]=new ArrayList<>();
                }

                bucket[freq].add(key);
            

        }

        int result[]=new int[k];

        int counter=0;

        for(int i=bucket.length-1;i>=0 && counter<k;i--){

            if(bucket[i]!=null){

                for(int n:bucket[i]){

                    if(counter==k){
                        break;
                    }

                    result[counter++]=n;
                }

            }

        }
        
        return result;
    }
}
