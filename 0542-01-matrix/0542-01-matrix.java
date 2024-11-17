class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
//         Adding all zeroes in queue
        for(int i = 0 ;i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    grid[i][j] = -1;
                }
            }
        }
        
        
        int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while(q.size() > 0) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                
                for(int j = 0; j < 4; j++) {
                    int nr = r + dirs[j][0];
                    int nc = c + dirs[j][1];
                    
                    if(isValid(nr, nc, n, m) && grid[nr][nc] != 0) {
                        if((grid[nr][nc] == -1) || (grid[nr][nc] > grid[r][c] + 1)) {
                            grid[nr][nc] = grid[r][c] + 1;
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        
        return grid;
    }
    
    public boolean isValid(int nr, int nc, int n, int m) {
        return (nr >= 0 && nc >= 0 && nr < n && nc < m) ? true : false;
    }
}