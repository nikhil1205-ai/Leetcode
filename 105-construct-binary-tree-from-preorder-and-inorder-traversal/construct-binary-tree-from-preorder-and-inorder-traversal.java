/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    static int pidx;

    int search(int[] inorder, int left, int right, int val) {
    for (int i = left; i <= right; i++) {
        if (inorder[i] == val) return i;
    }
    return -1;
    }

    TreeNode build(int[] preorder, int[] inorder,int left,int right){
       
       if(left>right) return null;
       TreeNode root=new TreeNode(preorder[pidx]);
       int id=search(inorder,left,right,preorder[pidx]);
       pidx++;
       root.left=build(preorder,inorder,left,id-1);
       root.right=build(preorder,inorder,id+1,right);

       return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
       pidx=0;
       return build(preorder,inorder,0,preorder.length-1);
    }
}