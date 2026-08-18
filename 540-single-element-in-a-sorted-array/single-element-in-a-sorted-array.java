class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        int i;
        for( i=0;i<nums.length-2;i+=2){
            if(nums[i]!=nums[i+1]) return nums[i];
        }

        if(i<=nums.length) return nums[i];
        else return -1;
    }
}