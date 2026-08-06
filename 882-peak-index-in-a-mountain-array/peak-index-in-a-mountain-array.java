class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int x=0;
        int l=0,r=arr.length-1;
        while(l<r){
          if(arr[l]>arr[r]){
                x=l;
                r--;
          }else {
            x=r;
            l++;
          }
          
        }
        return x;

    }
}