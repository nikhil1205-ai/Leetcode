
class Solution {
    static int pidx;
    int search(int[] inorder , int left,int right , int val){
       for(int i=left;i<=right;i++){
        if(inorder[i]==val) return i;
       }
       return -1;
    }

    TreeNode build(int[] inorder , int[] postorder,int left,int right){
        if(left>right) return null;
        TreeNode root=new TreeNode(postorder[pidx]);
        int idx=search(inorder,left,right,postorder[pidx]);
        pidx--;
        root.right=build(inorder,postorder,idx+1,right);
        root.left=build(inorder,postorder,left,idx-1);
        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pidx=inorder.length-1;
        return build(inorder,postorder,0,pidx);

    }
}