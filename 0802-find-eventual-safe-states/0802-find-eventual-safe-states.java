class Solution {
    int[] safe;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        safe = new int[n]; // 0 = unvisited, 1 = safe, -1 = unsafe

        for (int i = 0; i < n; i++) {
            if (safe[i] == 0) { // Only process unvisited nodes
                dfs(i, graph);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i] == 1) {
                result.add(i); // Collect all safe nodes
            }
        }
        return result;
    }

    public boolean dfs(int node, int[][] graph) {
        if (safe[node] != 0) {
            return safe[node] == 1; // Return previously computed result
        }

        // Mark as visiting
        safe[node] = -1;

        for (int nbr : graph[node]) {
            if (!dfs(nbr, graph)) {
                return false; // If any neighbor is unsafe, this node is unsafe
            }
        }

        // Mark as safe after all neighbors are processed
        safe[node] = 1;
        return true;
    }
}
