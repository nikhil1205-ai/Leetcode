class Solution {
    public void sortColors(int[] nums) {
        int l=0,j=0,k=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) l++;
            if(nums[i]==1) j++;
            if(nums[i]==2) k++;
        }
        int idx=0;
        while(idx<nums.length){
         if(l>0){
            nums[idx]=0; l--; idx++;
         }
         else if(j>0){
            nums[idx]=1; j--; idx++;
         }
         else{
            nums[idx]=2; k--; idx++;
         }
        }
    }
}