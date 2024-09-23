class Solution {
    public int equalSubstring(String s, String t, int max) {
        int l = 0;
        int r = 0;
        int ans = 0;
        int n = s.length();
        int cost = 0;
        
        while(r < n) {
            int curr = Math.abs(t.charAt(r) - s.charAt(r));
            cost += curr;
            
            while(l < r && cost > max) {
                cost -= Math.abs(t.charAt(l) - s.charAt(l));
                l++;
            }
            
            if(curr <= max) {
                ans = Math.max(ans, r-l+1);
            }
            
            r++;
        }
        return ans;
    }
}