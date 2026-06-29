class Solution {
    public int findDuplicate(int[] nums) {

        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int j=0;j<nums.length;j++){
            if(hs.containsKey(nums[j])) return nums[j];
            hs.put(nums[j],1);
        }
    
        return -1;
    }
}