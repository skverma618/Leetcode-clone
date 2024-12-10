class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] flight : flights) {
            int from = flight[0];
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(flight[1]);
            pair.add(flight[2]);
            adj.get(from).add(pair);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(src, 0, 0)); // Start with source, 0 stops, and 0 cost.
        
        // Track minimum costs to reach a city with up to `k+1` stops.
        int[][] vis = new int[n][k + 2];
        for (int[] row : vis) Arrays.fill(row, Integer.MAX_VALUE);
        vis[src][0] = 0;
        
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            
            if (curr.city == dst) return curr.cost; // Found the cheapest path to destination.
            
            if (curr.count > k) continue; // Exceeding stop limit.
            
            for (ArrayList<Integer> next : adj.get(curr.city)) {
                int nextCity = next.get(0);
                int fair = next.get(1);
                int newCost = curr.cost + fair;
                
                if (newCost < vis[nextCity][curr.count + 1]) {
                    vis[nextCity][curr.count + 1] = newCost;
                    pq.add(new Pair(nextCity, curr.count + 1, newCost));
                }
            }
        }
        
        return -1; // Destination unreachable within `k` stops.
    }
}

class Pair {
    int city;
    int count;
    int cost;
    
    public Pair(int city, int count, int cost) {
        this.city = city;
        this.count = count;
        this.cost = cost;
    }
}
