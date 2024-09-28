class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a,b) -> (a[1] - b[1]));
        int n = intervals.length;
        
        ArrayList<int[]> arrli = new ArrayList<>();
        int[] toInsert = new int[2];
        int i = 0;
        boolean added = false;
        while(i < n) {
            if((intervals[i][1] >= newInterval[0]) && (intervals[i][0] <= newInterval[1])) {
                int[] first = intervals[i];
                int l = i;
                
                while(i < n && newInterval[1] >= intervals[i][0]) {
                    i++;
                }
                // System.out.println(i);
                i--;
                int r = i;
                int[] end = intervals[i];
                toInsert[0] = Math.min(newInterval[0], first[0]);
                toInsert[1] = Math.max(end[1], newInterval[1]);
                
                // System.out.println(i + " " + toInsert[0] + " " + toInsert[1]);
                arrli.add(toInsert);
                added = true;
                i++;
            }
            if(i == n) break;
            arrli.add(intervals[i]);
            i++;
        }
        
        if(added == false) {
            if(arrli.size() > 0 && arrli.get(0)[0] > newInterval[1]){
                arrli.add(0, newInterval);
            } else {
                arrli.add(newInterval);
            }
        }
        int[][] result = arrli.toArray(new int[arrli.size()][]);
        Arrays.sort(result, (a,b) -> (a[0] - b[0]));
        return result;
    }
}