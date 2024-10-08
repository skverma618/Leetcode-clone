class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        long count = 0;
        
        // To store the prefix sum mod counts
        HashMap<Integer, Long> prefixModCount = new HashMap<>();
        // Initial prefix mod count is 0 for empty subarray
        prefixModCount.put(0, 1L);
        
        int prefixSumMod = 0;
        
        for (int i = 0; i < n; i++) {
            // Convert nums[i] into 1 if it contributes to interesting subarray, 0 otherwise
            int currentValue = (nums.get(i) % modulo == k) ? 1 : 0;
            
            // Update prefix sum mod
            prefixSumMod = (prefixSumMod + currentValue) % modulo;
            // Handle negative mod results to keep in range [0, modulo-1]
            if (prefixSumMod < 0) {
                prefixSumMod += modulo;
            }
            
            // We need (prefixSumMod - k) % modulo == 0, to find valid subarrays
            int targetMod = (prefixSumMod - k + modulo) % modulo;
            
            // If there's a previous prefix with this mod, add its count to the result
            count += prefixModCount.getOrDefault(targetMod, 0L);
            
            // Update the hashmap with the current prefix mod
            prefixModCount.put(prefixSumMod, prefixModCount.getOrDefault(prefixSumMod, 0L) + 1);
        }
        
        return count;
    }
}