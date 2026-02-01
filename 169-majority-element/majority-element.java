class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hs= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
        }
        int k=0;
        int key=0;
        for(int i:hs.keySet()){
           if(hs.get(i)>k){
              key=i;
              k=hs.get(i);
           }
        }
        return key;
    }
}