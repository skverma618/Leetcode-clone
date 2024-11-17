class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int[] color = new int[n];
        Arrays.fill(color,0);
        for(int i = 0;i < n ; i++){
            if(color[i] == 0){
                color[i] = 1;
                if(!bfs(i,color,graph))return false;
            }
        }
        return true;
    }
    
    public boolean bfs(int n, int[] color, int[][] graph){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while(q.size() > 0){
            int curr  = q.poll();
            
            for(int neighbor : graph[curr]){
                if(color[neighbor] == 0){
                    color[neighbor] = 3 - color[curr];
                    q.add(neighbor);
                }else if(color[neighbor] == color[curr])return false;
            }
        }
        return true;
    }
}