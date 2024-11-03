class Solution {
    
    Queue<Integer> q = new LinkedList<>();
    
    public int findCircleNum(int[][] grid) {
        int n = grid.length;
        
        boolean[] vis = new boolean[n];
        Arrays.fill(vis,false);
        
        int count = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                vis[i] = true;
                bfs(i,grid,vis);
                count++;
            }
        }
        return count;
    }
    
    public void bfs(int node, int[][] grid, boolean[] vis){
        int n = grid.length;
        q.add(node);
        
        while(q.size() > 0) {
            int curr = q.poll();
            for(int i = 0 ; i < n ; i++) {
                if(vis[i] == false && grid[curr][i] == 1) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
    }
}