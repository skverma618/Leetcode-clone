class Solution {
    
    public boolean isValid(int r, int c , int n , int m) {
        return (r >= 0 && c >= 0 && r < n && c < m) ? true : false;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        
        int col = image[sr][sc];
        
        if(col == color) return image;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        
        int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while(q.size() > 0) {
            int[] node = q.poll();
            
            image[node[0]][node[1]] = color;
            for(int i = 0; i < 4; i++) {
                int nr = node[0] + dir[i][0];
                int nc = node[1] + dir[i][1];
                
                if(isValid(nr, nc, n, m) && image[nr][nc] == col) {
                    image[nr][nc] = color;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        
        return image;
    }
}