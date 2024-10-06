class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int count = 0;
        
        for(int i = 0 ; i < n ; i++) {
            sum += nums[i];
            // if(nums[i] < 0) sum += k;  // MAJOR MISTAKE THAT I WAS MAKING
            int mod = sum % k;
            if(mod < 0) mod += k;         // INSTEAD OF THIS, I WAS WRITING THE COMMENTED LINE
            
            if(mod == 0) count++;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            count += val * (val-1) / 2;
        }
        
        return count;
    }
}