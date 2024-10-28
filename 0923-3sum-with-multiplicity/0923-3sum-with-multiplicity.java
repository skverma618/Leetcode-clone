class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length;
        int count = 0;
        int mod = 1000000007;
        
        for(int i = 0; i < n ; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = target - arr[i];
            for(int j = i+1; j < n ; j++) {
                if(map.containsKey(sum - arr[j])) {
                    count = (count + map.get(sum - arr[j])) % mod;
                }
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
        }
        return count;
    }
}