class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int m = l + (r-l)/2;
        while(l <= r){
            m = l + (r-l)/2;
            if(nums[m] >= target){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return l;
    }
}