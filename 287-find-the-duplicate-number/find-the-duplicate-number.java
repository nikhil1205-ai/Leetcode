class Solution {
    public int findDuplicate(int[] nums) {
        
        // HashMap<Integer,Integer> hs=new HashMap<>();
        // for(int j=0;j<nums.length;j++){
        //     if(hs.containsKey(nums[j])) return nums[j];
        //     hs.put(nums[j],1);
        // }


        // Arrays.sort(nums);
        // int k=0;
        // for(int i=0;i<nums.length;i++){
        //     if(k-nums[i]==0) return nums[i];
        //     k=nums[i];
        // }

        int slow=nums[0],fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);

        slow=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
    
        return slow;
    }
}