class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n ; i++) {
            int mod = arr[i] % k;
            if(mod < 0) mod += k;
            
            map.put(mod, map.getOrDefault(mod,0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            int mod = e.getKey();
            int val = e.getValue();
            int counter = k - mod;
            
            if(mod == 0) continue;
            if(mod == counter) {
                if(val % 2 != 0) return false;
            } else if(map.getOrDefault(counter, 0) != val) {
                return false;
            }
        }
        
        return true;
    }
}