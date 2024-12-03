class Solution {
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        int dir[][] = {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        int level = 1;
        grid[0][0] = 1;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int i = 0 ; i < size; i++){
                
                Pair p = q.poll();
                for(int j = 0 ; j < 8 ;j++){
                    int nx = p.x + dir[j][0];
                    int ny = p.y + dir[j][1];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                        if(grid[nx][ny] == 0){
                            q.add(new Pair(nx,ny));
                            grid[nx][ny] = level;
                        }
                    }
                }
            }
        }
        if(grid[n-1][n-1] == 0){
            return -1;
        }else{
            return grid[n-1][n-1];
        }
    }
     
}
class Pair{
            int x;
            int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }