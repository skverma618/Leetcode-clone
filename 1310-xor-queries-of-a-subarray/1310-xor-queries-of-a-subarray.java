class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int xor = 0;
        
        for(int i = 0 ; i < n ; i++) {
            xor ^= arr[i];
            map.put(i, xor);
        }
        
        int[] ans = new int[queries.length];
        for(int i = 0 ; i < queries.length; i++) {
            int l = queries[i][0] - 1;
            int r = queries[i][1];
            
            ans[i] = l < 0 ? map.get(r) : map.get(r) ^ map.get(l);
        }
        
        return ans;
    }
}