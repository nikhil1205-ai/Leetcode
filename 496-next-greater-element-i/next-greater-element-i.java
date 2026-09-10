class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> mp=new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<nums2.length;i++){
            while(!st.isEmpty() && st.peek() < nums2[i]){
                int k=st.pop();
                mp.put(k,nums2[i]);
            }
            st.push(nums2[i]);
            
        }

        int[] ans=new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            ans[i]=mp.getOrDefault(nums1[i],-1);
        }

        return ans;
    }
}