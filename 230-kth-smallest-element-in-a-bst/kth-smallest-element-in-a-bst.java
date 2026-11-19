class Solution {
    int order=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        if(root.left!=null){
            int num1=kthSmallest(root.left,k);
            if(num1!=-1) return num1;
        }
        
        order=order+1;
        if(order==k) return root.val;
       


        if(root.right!=null){
            int num2=kthSmallest(root.right,k);
            if(num2!=-1) return num2;
        }
        return -1; 
    }
}