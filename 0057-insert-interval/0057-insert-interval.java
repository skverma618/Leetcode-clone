
// class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         List<int[]> result = new ArrayList<>();
//         int i = 0, n = intervals.length;

//         // Add all intervals that come before the new interval
//         while (i < n && intervals[i][1] < newInterval[0]) {
//             result.add(intervals[i++]);
//         }

//         // Merge all overlapping intervals
//         while (i < n && intervals[i][0] <= newInterval[1]) {
//             newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
//             newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
//             i++;
//         }
//         result.add(newInterval);

//         // Add all remaining intervals after the new interval
//         while (i < n) {
//             result.add(intervals[i++]);
//         }

//         return result.toArray(new int[result.size()][]);
//     }
// }
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Using TreeMap for maintaining sorted keys
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Increment start and decrement end for existing intervals
        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }

        // Increment start and decrement end for the new interval
        map.put(newInterval[0], map.getOrDefault(newInterval[0], 0) + 1);
        map.put(newInterval[1], map.getOrDefault(newInterval[1], 0) - 1);

        int count = 0;
        List<int[]> result = new ArrayList<>();
        int start = 0;

        // Iterating over the TreeMap to merge intervals
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count == 0) {
                start = entry.getKey();  // Start of a new interval
            }
            count += entry.getValue();
            if (count == 0) {
                result.add(new int[] {start, entry.getKey()});  // End of a merged interval
            }
        }

        // Converting the result list to a 2D array
        return result.toArray(new int[result.size()][]);
    }
}
// class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         int n = intervals.length;
        
//         ArrayList<int[]> arrli = new ArrayList<>();
//         int[] toInsert = new int[2];
//         int i = 0;
//         boolean added = false;
//         while(i < n) {
//             if((intervals[i][1] >= newInterval[0]) && (intervals[i][0] <= newInterval[1])) {
//                 int[] first = intervals[i];
//                 int l = i;
                
//                 while(i < n && newInterval[1] >= intervals[i][0]) {
//                     i++;
//                 }
//                 i--;
//                 int r = i;
//                 int[] end = intervals[i];
//                 toInsert[0] = Math.min(newInterval[0], first[0]);
//                 toInsert[1] = Math.max(end[1], newInterval[1]);
                
//                 arrli.add(toInsert);
//                 added = true;
//                 i++;
//             }
//             if(i == n) break;
//             arrli.add(intervals[i]);
//             i++;
//         }
        
//         if(added == false) {
//             if(arrli.size() > 0 && arrli.get(0)[0] > newInterval[1]){
//                 arrli.add(0, newInterval);
//             } else {
//                 arrli.add(newInterval);
//             }
//         }
//         int[][] result = arrli.toArray(new int[arrli.size()][]);
//         Arrays.sort(result, (a,b) -> (a[0] - b[0]));
//         return result;
//     }
// }