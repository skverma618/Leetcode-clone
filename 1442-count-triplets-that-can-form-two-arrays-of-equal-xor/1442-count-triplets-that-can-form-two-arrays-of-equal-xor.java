class Solution {
    public int countTriplets(int[] arr) {
        int n=arr.length;
        int res=0;
        for(int i=0;i<n;i++){
            int xor=arr[i];
            for(int k=i+1;k<n;k++){
                xor^=arr[k];
                if(xor==0){
                    res+=k-i;
                }
            }
        }
        return res;
    }
}