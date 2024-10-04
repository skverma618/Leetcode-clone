class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++) {
            int diff = nums[i] - i;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        
        long ttl = (long)n*(n-1)/2;
        long count = 0L;
        
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            long val = e.getValue();
            
            if(val > 1) {
                count += val*(val-1)/2;
            }
        }
        return ttl - count;
    }
}