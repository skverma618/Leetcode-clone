class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int maXe=0;
        int i=0,j=n-1;
        while(i<n/2 && j>=n/2){
            int Sum=0;
            Sum=nums[i]+nums[j];
            if(Sum>maXe){
                maXe=Sum;
            }
            i++;
            j--;
        }
        return maXe;
    }
}