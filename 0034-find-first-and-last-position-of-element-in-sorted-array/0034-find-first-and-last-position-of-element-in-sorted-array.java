class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = getFirst(nums, target);
        ans[1] = getLast(nums, target);
        return ans;
    }
    
    public int getFirst(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int m = l + (r-l)/2;
        int ans = n+1;
        
        while(l <= r) {
            m = l + (r-l)/2;
            
            if(target <= nums[m]) {
                r = m-1;
                if(nums[m] == target) ans = Math.min(m, ans);
            } else {
                l = m+1;
            }
        }
        
        return (ans == n+1) ? -1 : ans;
    }
    
    public int getLast(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int m = l + (r-l)/2;
        int ans = -1;
        
        while(l <= r) {
            m = l + (r-l)/2;
            
            if(target >= nums[m]) {
                l = m+1;
                if(nums[m] == target) ans = Math.max(ans, m);
            } else {
                r = m-1;
            }
        }
        
        return ans;
    }
}