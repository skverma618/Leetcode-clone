class Solution {
    public boolean judgeSquareSum(int c) {
        long start=0;
        long end=(int)Math.sqrt(c);
        //System.out.println(end);
        while(start<=end){
            long sum=(start*start)+(end*end);
            if(sum==c){
                return true;
            }
            if(sum>c){
                end--;
            }
            if(sum<c){
                start++;
            }
        }
        return false;
    }
}