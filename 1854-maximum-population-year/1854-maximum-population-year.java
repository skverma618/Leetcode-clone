class Solution {
    public int maximumPopulation(int[][] logs) {
        int n = logs.length;
        int max = 0;
        int year = 2051;
        
        for(int i = 1950; i <= 2050; i++) {
            int count = 0;
            
            for(int j = 0; j < n ; j++) {
                if(logs[j][0] <= i && logs[j][1] > i) count++;
            }
            
            // System.out.println(i + " " + count + " " + max);
            if(count > 0 && count > max) {
                max = count;
                year = i;
            } else if(count > 0 && count == max) {
                year = Math.min(i, year);
            }
        }
        return year;
    }
}