class Solution {
    List<List<Integer>> graph=new ArrayList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i=0;i<numCourses;i++){

            graph.add(new ArrayList<>());
        }

        int [] inDegree=new int[numCourses];

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


        int count=0;

        while(!queue.isEmpty()){

            int it=queue.poll();
            count++;

            for(int next:graph.get(it)){

                inDegree[next]--;

                if(inDegree[next]==0){
                    queue.add(next);
                }

            }


        }
        

        return count==numCourses;
    }
}
