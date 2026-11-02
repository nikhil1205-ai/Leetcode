class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] right=new int[n];
        int[] left=new int[n];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<n;i++){
          while(st.size()>0 && heights[st.peek()]>=heights[i]){
            st.pop();
          }
          left[i] =(st.size()>0)? st.peek() : -1;
          st.push(i);
        }

        while(st.size()>0) st.pop();

        for(int i=n-1;i>=0;i--){
          while(st.size()>0 && heights[st.peek()]>=heights[i]){
            st.pop();
          }
          right[i] =(st.size()>0)? st.peek() : n;
          st.push(i);
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            int curr=heights[i]*(right[i]-left[i]-1);
            ans=Math.max(curr,ans);
        }
        return ans;
    }
}