class Solution {
    public int singleNonDuplicate(int[] nums) {
        // if(nums.length==1) return nums[0];
        // int i;
        // for( i=0;i<nums.length-2;i+=2){
        //     if(nums[i]!=nums[i+1]) return nums[i];
        // }

        // if(i<=nums.length) return nums[i];
        // else return -1;

        int low=0,high=nums.length-1;
        if(nums.length==1) return nums[0];
        while(low<=high){
          int mid=low+(high-low)/2;
          if(mid==0 && nums[0]!= nums[1]) return nums[0];
          if(mid== nums.length-1 && nums[mid-1] != nums[mid]) return  nums[mid];
          if( nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]) return nums[mid];
          
          if(mid%2==0){
            if(nums[mid]==nums[mid-1]) high=mid-1;
            else low=mid+1;
          }else{
             if(nums[mid]==nums[mid-1])  low=mid+1;
             else high=mid-1;
          }

    
        }

        return -1;


    }
}