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
    TreeNode build(TreeNode root,int val){
      if(root==null) return new TreeNode(val);
      if(root.val > val) root.left=build(root.left, val);
      else root.right=build( root.right, val);
      return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root= new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++) build(root,preorder[i]);
        return root;
    }

    
}