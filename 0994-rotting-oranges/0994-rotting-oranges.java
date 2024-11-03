class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        boolean orange = false;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0; j < m ; j++) {
                if(grid[i][j] != 0) orange = true;
                if(grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }
        
        if(orange == false) return 0;
        
        int[][] dir = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        int ans = -1;
        while(q.size() > 0) {
            int size = q.size();
            ans++;
            for(int p = 0; p < size; p++) {
                int[] node = q.poll();
                for(int i = 0; i < 4; i++) {
                    int nr = node[0] + dir[i][0];
                    int nc = node[1] + dir[i][1];
                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0; j < m ; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return ans;
    }
}