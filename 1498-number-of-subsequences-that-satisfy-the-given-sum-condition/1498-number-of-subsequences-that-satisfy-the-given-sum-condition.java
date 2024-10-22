class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        int mod = 1000000007;
        
        int l = 0;
        int r = n-1;
        
        int[] pow=new int[n];
       pow[0]=1;
       for(int i=1;i<n;i++)
         pow[i] = pow[i-1]*2%mod;
        
        while(l <= r) {
            int sum = nums[l] + nums[r];
            if(sum > target) {
                r--;
            } else {
                count = (count+pow[r-l])%mod;
                l++;
            }
        }
        return count;
    }
}