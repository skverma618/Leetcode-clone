class Solution {
    public int nextGreaterElement(int num) {
        int temp = num;
        int n = (int)Math.floor(Math.log10(num) + 1);
        int[] arr = new int[n];
        
        for(int i = n-1; i >= 0; i--) {
            arr[i] = temp%10;
            temp /= 10;
        }
        
        arr = nextPermutation(arr);
        if(arr.length == 0) return -1;
        
//         arr to int
        long ans = 0L;
        for(int i = 0 ; i < n ; i++) {
            ans *= 10;
            ans += arr[i];
        }
        
        if(ans > Integer.MAX_VALUE) return -1;
        return (int)ans;
    }
    
    public int[] nextPermutation(int[] nums) {
        int i = nums.length-2;
        int j = 0;
        while(i>=0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if(i < 0) return new int[0];
            if(i>=0) {
                j = nums.length-1;
                while(nums[j] <= nums[i]) {
                    j--;
                }
                    swap(nums,i,j);
                
                
            }
            reverse(nums, i+1,nums.length-1);
        return nums;
    }
    public static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void reverse(int nums[] , int i, int j) {
        while(i<j) {
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}