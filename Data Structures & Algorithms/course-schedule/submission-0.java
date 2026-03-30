class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph =new ArrayList<>();

        for(int i=0;i<numCourses;i++){

            graph.add(new ArrayList<>());
        }


        int inDegree[]=new int[numCourses];

        for(int pre[]:prerequisites){

            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        
        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<numCourses;i++){

            if(inDegree[i]==0){
                queue.offer(i);
            }

        }        


        int counter=0;


        while(!queue.isEmpty()){

            int next=queue.poll();
            counter++;

            for(int it:graph.get(next)){
                inDegree[it]--;

                if(inDegree[it]==0){
                    queue.offer(it);
                }
            }
        }



        return counter==numCourses;

    }
}
