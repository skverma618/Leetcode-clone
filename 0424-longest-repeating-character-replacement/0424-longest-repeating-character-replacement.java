class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        int counter = k;
        int l = 0;
        int r = 0;
        
        while(r < n) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c,0) + 1);
            int max = getMax(map);
            
            if(r - l + 1 - max > k) {
                while((r - l + 1 - max) > k) {
                    // System.out.println(l + " " + r + " " + (r - l + 1) + " " + max);
                    char ch = s.charAt(l);
                    map.put(ch, map.get(ch) - 1);
                    max = getMax(map);
                    l++;
                }
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
    
    public int getMax(HashMap<Character, Integer> map) {
        int max = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }
}