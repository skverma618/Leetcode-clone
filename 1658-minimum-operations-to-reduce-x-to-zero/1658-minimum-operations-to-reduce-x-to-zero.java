class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int min = -1;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        for(int i = 0 ; i < n ; i++) {
            sum += nums[i];
            map.put(sum, i);
            if(sum == x) min = (min == -1) ? i+1 : Math.min(min, i+1);
        }
        
        sum = 0;
        for(int i = n-1; i >= 0; i--) {
            sum += nums[i];
            if(sum == x) min = (min == -1) ? n-i : Math.min(min, n-i);
            if(map.containsKey(x-sum) && map.get(x-sum) < i) {
                int left = map.get(x - sum) + 1;
                int right = n-i;
                int idx = left+right;
                // System.out.println(left + " " + right);
                min = (min == -1) ? idx : Math.min(min, idx);
            }
        }
        
        return min;
    }
    
    
//     public int bruteForce (int[] nums, int x, int count, int l, int r) {
//         if(x == 0) {
//             return count;
//         }
//         if(l > r) return -1;
//         if(x < 0) return -1;
        
//         int left = helper(nums, x - nums[l], count+1, l+1, r);
//         int right = helper(nums, x - nums[r], count+1, l, r+1);
        
//         if(left != -1) return left;
//         return right;
//     }
}