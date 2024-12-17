import java.util.*;

// Class to store the time and node
class Pair {
    long time; // Change this to long
    int node;

    Pair(long t, int n) { // Change parameter type to long
        this.time = t;
        this.node = n;
    }
}

class Solution {
    private static final int MOD = 1_000_000_007; // 10^9 + 7

    public int countPaths(int n, int[][] roads) {
        // Adjacency List to create the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Populate the adjList with roads information 
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            // Add edge b/w u -> v & v -> u
            adj.get(u).add(new Pair(time, v));
            adj.get(v).add(new Pair(time, u));
        }

        // Distance array initialized to infinity
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0; // Starting point distance is 0

        // Number of ways to reach each node
        long[] ways = new long[n];
        ways[0] = 1; // One way to reach the starting node

        // Priority Queue for Dijkstra's algorithm
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.time));
        pq.add(new Pair(0, 0)); // Starting from node 0 with distance 0

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long time = curr.time;
            int node = curr.node;

            // Skip if current path is not optimal
            if (time > dist[node]) continue;

            // Explore the node's neighbours
            for (Pair neighbour : adj.get(node)) {
                int adjNode = neighbour.node;
                long newTime = time + neighbour.time; // Calculate new time

                // Relaxation step
                if (newTime < dist[adjNode]) {
                    dist[adjNode] = newTime; // Update shortest distance
                    ways[adjNode] = ways[node]; // Update the number of ways to reach this node
                    pq.add(new Pair(newTime, adjNode)); // Add to the priority queue
                } else if (newTime == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD; // Update ways if we find another shortest path
                }
            }
        }

        return (int) ways[n - 1]; // Return the number of ways to reach the last node
    }
}