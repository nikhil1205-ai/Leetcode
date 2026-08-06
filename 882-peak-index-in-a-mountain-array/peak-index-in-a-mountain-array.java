class Solution {
    // public int peakIndexInMountainArray(int[] arr) {
    //     int x=0;
    //     int l=0,r=arr.length-1;
    //     while(l<r){
    //       if(arr[l]>arr[r]){
    //             x=l;
    //             r--;
    //       }else {
    //         x=r;
    //         l++;
    //       }
          
    //     }
    //     return x;

    // }


        public int peakIndexInMountainArray(int[] arr) {
        int l=0,h=arr.length-1;

        while(l<h){
            int mid=(l+h)/2;
            if(arr[mid]<arr[mid+1]){
               l=mid+1;
            }else{
                h=mid;
            }
        }

        return l;
        

    }
}