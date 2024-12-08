class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
        
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] vis = new int[n][m];
        for(int[] row : vis) Arrays.fill(row, -1);
        vis[0][0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        pq.add(new int[]{0, 0, 0});
        
        while(pq.size() > 0) {
            int len = pq.size();
            
            for(int i = 0 ; i < len; i++) {
                int[] curr = pq.poll();
                for(int j = 0 ; j < 4; j++) {
                    int nr = curr[0] + dirs[j][0];
                    int nc = curr[1] + dirs[j][1];
                    if(isValid(nr, nc, n, m)) {
                        int currMax = curr[2];
                        int diff = Math.abs(heights[nr][nc] - heights[curr[0]][curr[1]]);
                        int effort = Math.max(currMax, diff);
                        if((vis[nr][nc] == -1) || (effort < vis[nr][nc])) {
                            pq.add(new int[] {nr, nc, effort});
                            vis[nr][nc] = effort;
                        }
                    }
                }
            }
        }
        
        return vis[n-1][m-1];
    }
    
    public boolean isValid(int r, int c, int n, int m) {
        return (r >= 0 && c >= 0&& r < n && c < m) ? true : false;
    }   
}