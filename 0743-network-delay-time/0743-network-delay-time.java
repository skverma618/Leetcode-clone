class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < times.length; i++) {
            int[] time = times[i];
            adj.get(time[0]).add(new ArrayList<>(Arrays.asList(time[1], time[2])));
        }
         
        int[] vis = new int[n+1];
        Arrays.fill(vis, -1);
        vis[k] = 0;
        
        int ans = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {k, 0});
        
        while(pq.size() > 0) {
            int[] node = pq.poll();
            int curr = node[0];
            for(ArrayList<Integer> next : adj.get(curr)) {
                int nextNode = next.get(0);
                int wt = next.get(1);
                if(vis[nextNode] == -1 || vis[nextNode] > wt + node[1]) {
                    pq.add(new int[] {nextNode, wt + node[1]});
                    vis[nextNode] = wt + node[1];
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            // System.out.println(i + " " + vis[i]);
            if(vis[i] == -1) return -1;
            ans = Math.max(ans, vis[i]);
        }
        return ans;
    }
}