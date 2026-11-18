class Solution {
   TreeNode build(int[] nums , int st,int end){
     if(st>end) return null;
     int mid=st+(end-st)/2;
     TreeNode root= new TreeNode(nums[mid]);
     root.left=build(nums,st,mid-1);
     root.right=build(nums,mid+1,end);
     return root;
   }
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }
}