class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n-1;
        int m = l + (h-l)/2;
        if(n==1)return 0;
        if(n > 1 && nums[1] < nums[0])return 0;
        if(n > 1 && nums[n-1] > nums[n-2])return n-1;
        while(l <= h){
            m = l + (h-l)/2;
            
            if(m-1 >= 0 && m+1 <= n-1 && nums[m] > nums[m-1] && nums[m] > nums[m+1]){
                System.out.println(nums[m]);
                return m;
            }
            if(nums[m+1] > nums[m]){
                l = m+1;
            }else if(nums[m-1] > nums[m]){
                h = m-1;
            }
        }
        return m;
    }
}