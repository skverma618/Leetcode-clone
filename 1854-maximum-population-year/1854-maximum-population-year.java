class Solution {
//     My version of Line Sweep = O(N)
    public int maximumPopulation(int[][] arr) {
        int n = arr.length;
        int prevMax = 0;
        int ans = -1;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n ; i++) {
            int born = arr[i][0];
            int die = arr[i][1];
            
            map.put(born, map.getOrDefault(born, 0) + 1);
            map.put(die, map.getOrDefault(die, 0) - 1);
        }
        
        int sum = 0;

        
        for(int i = 1950; i <= 2050; i++) {
            int count = 0;
            int netDiff = map.getOrDefault(i, 0);
            sum += netDiff;
            if(sum > prevMax) {
                prevMax = sum;
                ans = i;
            }
        }
        return ans;
    }
}