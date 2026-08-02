class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> setList = new HashSet<>();

        for(int i=0;i<nums.length;i++){

            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=i+1;j<nums.length;j++){

                int comp = -(nums[i]+nums[j]);

                if(map.containsKey(comp)){

                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(comp);
                    Collections.sort(list);
                    setList.add(list);
                }

                else{
                    map.put(nums[j],j);
                }
            }
        }

        return new ArrayList<>(setList);

    }
}