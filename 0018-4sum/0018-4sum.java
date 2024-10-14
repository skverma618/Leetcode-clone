class Solution {
    public List<List<Integer>> fourSum(int[] nums, int t) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < n-3 ; i++){
            long nt = t - nums[i];
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < n-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                long target = nt - nums[j];
                int s = j+1;
                int e = n-1;
                while(s < e){
                    long sum = nums[s] + nums[e];
                    if(sum > target){
                        e--;
                    }else if(nums[s] + nums[e] < target){
                        s++;
                    }else{
                        // System.out.println(target);
                        ans.add(List.of(nums[i], nums[j], nums[s] , nums[e]));
                        while((s+1 <= e) && nums[s] == nums[s+1]) s++;
                        while((s+1 <= e) && nums[e] == nums[e-1]) e--;
                        s++;e--;
                    }
                }
            }
        }
        return ans;
    }
}