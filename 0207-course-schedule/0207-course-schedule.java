class Solution {
    Stack<Integer> s = new Stack<>();
    HashSet<Integer> set = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = numCourses;
        for(int i = 0 ; i < n ; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < arr.length ; i++) {
            int u = arr[i][1];
            int v = arr[i][0];
            adj.get(u).add(v);
        }
        
        boolean[] vis = new boolean[n];
        
        for(int i = 0 ; i < n ; i++) {
            if(vis[i] == false) {
                set.add(i);
                boolean ans = dfs(i, adj, vis);
                set.remove(i);
                if(ans == true) return false;
                
            }
        }
        return true;
    }
    
    public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[v] = true;
        
        ArrayList<Integer> arrli = adj.get(v);
        
        boolean ans = false;
        for(int node: arrli) {
            if(vis[node] == true && set.contains(node)) {
                return true;
            } else if(vis[node] == false) {
                set.add(node);
                ans |= dfs(node, adj, vis);
                set.remove(node);
            }
        }
        
        return ans;
    }
}