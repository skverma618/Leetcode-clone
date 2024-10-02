class Solution {
    public int removeCoveredIntervals(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a,b) -> (a[0] != b[0]) ? (a[0] - b[0]) : b[1] - a[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        int count = 0;
        for(int i = 0; i < n ; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            
            // while(pq.peek() < start) pq.poll();
            // System.out.println(end);
            if(pq.size() > 0 && pq.peek() >= end) count++;
            
            pq.add(end);
            
        }
        return n - count;
    }
}