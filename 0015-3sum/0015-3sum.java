class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < n ; i++) {
            int sum = 0 - nums[i];
            int l = i+1;
            int r = n-1;
            
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
            while(l < r) {
                if(nums[l] + nums[r] == sum) {
                    ans.add(List.of(nums[i], nums[l], nums[r]));
                    while(l + 1 < r && nums[l+1] == nums[l]) l++;
                    while(r - 1 > l && nums[r-1] == nums[r]) r--;
                    l++;
                }
                
                while(l < r && nums[l] + nums[r] > sum) r--;
                while(l < r && nums[l] + nums[r] < sum) l++;
            }
            }
        }
        return ans;
    }
}