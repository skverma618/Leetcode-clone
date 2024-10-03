class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        ArrayList<int[]> arrli = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> (a[0] != b[0]) ? (a[0] - b[0]) : a[1] - b[1]);
        
        arrli.add(intervals[0]);
        for(int i = 1; i < n ; i++) {
            int[] prev = arrli.get(arrli.size() - 1);
            int[] curr = intervals[i];
            
            if(curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                arrli.add(curr);
            }
        }
        
        int[][] result = arrli.toArray(new int[arrli.size()][]);
        return result;
    }
}