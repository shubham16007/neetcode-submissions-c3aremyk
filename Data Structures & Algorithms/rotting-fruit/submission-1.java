class Solution {
    public int orangesRotting(int[][] grid) {

        int freshCount=0;

        Queue<int[]> queue=new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]==1){
                    freshCount++;
                }else if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        
        if(freshCount==0){
            return 0;
        }

        int time=0;
        while(!queue.isEmpty() && freshCount>0){

            int size=queue.size();

            for(int i=0;i<size;i++){

                int loc[]=queue.poll();

                int r=loc[0];
                int c=loc[1];

                int neighbors[][]={{r+1,c},{r-1,c},{r,c+1},{r,c-1}};

                for(int neighbor[]:neighbors){

                    int nr=neighbor[0];
                    int nc=neighbor[1];

                    if(nr<0|| nc<0 || nr>=grid.length|| nc>=grid[0].length || grid[nr][nc]==0 || grid[nr][nc]==2){
                        continue;
                    }

                    grid[nr][nc]=2;

                    queue.add(new int []{nr,nc});
                    freshCount--;

                    if(freshCount==0){
                        return time+1;
                    }
                }

            }

            time++;
        }

            return -1;
    }
}
