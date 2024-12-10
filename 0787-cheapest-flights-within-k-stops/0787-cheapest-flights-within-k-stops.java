class pair{
    int node, stops, dist;
    public pair(int node, int stops, int dist){
        this.node = node;
        this.stops = stops;
        this.dist = dist;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        int[] distance = new int[n];
		//intialise the distance as infinity
        Arrays.fill(distance, (int)1e9);
        
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<pair>());
        }
        
        for(int i = 0 ; i < flights.length ; i++){
			//prepare adjacency list with respect to cost
            adj.get(flights[i][0]).add(new pair(flights[i][1], 0, flights[i][2]));
        }
        
        PriorityQueue<pair> pq = new PriorityQueue<pair>((x,y)->x.stops-y.stops);
        pq.add(new pair(src, 0, 0));
        distance[src] = 0;
        
        while(!pq.isEmpty()){
            pair p = pq.poll();
			//once we have exceeded the stops we donot want to calculate any further
            if(p.stops > k){
                break;
            }
            
            for(pair city : adj.get(p.node)){
                int totalDist = p.dist + city.dist;
                if(distance[city.node] > totalDist){
                    distance[city.node] = totalDist;
                    pq.add(new pair(city.node, p.stops+1, totalDist));
                }
            }
        }
        
        return distance[dst] == (int)1e9 ? -1 : distance[dst];
    }
}