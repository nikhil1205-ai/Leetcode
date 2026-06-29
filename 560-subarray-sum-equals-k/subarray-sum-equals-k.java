// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int total=0;
//         for(int i=0;i<nums.length;i++){
//             int sum=0;
//             for(int j=i;j<nums.length;j++){
//                  sum+=nums[j];
//                  if(sum==k) total++;
//             }
//         }
//         return total;
//     }
// }



class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        ArrayList<Integer> pre=new ArrayList<>();
        HashMap<Integer,Integer> hs=new HashMap<>();
        pre.add(nums[0]);

        for(int i=1;i<nums.length;i++){
            int val=pre.get(i-1)+nums[i];
            pre.add(val);
        }
        for(int j=0;j<nums.length;j++){
            if(pre.get(j)==k) count++;
            int val=pre.get(j)-k;
            if(hs.containsKey(val)) count+=hs.get(val);
            hs.put(pre.get(j),hs.getOrDefault(pre.get(j),0)+1);
        }

        return count;

    }
}