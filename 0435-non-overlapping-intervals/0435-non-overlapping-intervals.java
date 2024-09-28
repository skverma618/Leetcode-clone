class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        
        int count = 0;
        int prevMax = Integer.MIN_VALUE;
        
        for(int[] interval : arr) {
            if(interval[0] >= prevMax) {
                prevMax = interval[1];
            } else {
                count++;
            }
        }
        
        return count;
    }
}