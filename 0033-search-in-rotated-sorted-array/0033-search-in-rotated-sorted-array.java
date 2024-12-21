class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int m = l + (r-l)/2;
        
        while(l <= r) {
            m = l + (r-l)/2;
            // System.out.println(l + " " + r + " " + m + " " + nums[m]);
            if(nums[m] == target) return m;
            
            if(nums[m] >= nums[0]) {
                if(nums[m] > target && target >= nums[0]) {
                    r = m-1;
                } else {
                    l = m+1;
                }
            } else {
                if(nums[m] < target && target <= nums[r]) {
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
        }
        
        return -1;
    }
}