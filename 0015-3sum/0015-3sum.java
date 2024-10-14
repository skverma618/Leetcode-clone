class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0 ; i < n-2 ; i++){
            if(nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = 0 - nums[i];
            int s = i+1;
            int e = n-1;
            while(s < e){
                if(nums[s] + nums[e] > target){
                e--;
            }else if(nums[s] + nums[e] < target){
                s++;
            }else{
                ans.add(List.of(nums[i], nums[s] , nums[e]));
                    while((s+1 <= e) && nums[s] == nums[s+1]) s++;
                    while((s+1 <= e) && nums[e] == nums[e-1]) e--;
                    s++;e--;
            }
            }
            
        }
        return ans;
    }
}