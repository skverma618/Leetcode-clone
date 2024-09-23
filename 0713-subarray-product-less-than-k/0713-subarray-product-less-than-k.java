class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0)return 0;
        
        int n = nums.length;
        int l=0;
        int r=0;
        int prd=1;
        int count=0;

        while(r < n){
            prd *= nums[r];
            while(l <= r && prd >= k){
                prd /= nums[l];
                l++;
            }
            count += (r-l)+1;
            r++;
        }
        return count; 
    }
}