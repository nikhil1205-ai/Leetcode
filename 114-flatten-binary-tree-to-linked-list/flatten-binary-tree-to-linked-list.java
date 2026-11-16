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
    TreeNode righest(TreeNode root){
       if(root==null || root.right==null) return root;
       return righest(root.right);

    }

    public void flatten(TreeNode root) {
      if(root==null) return;
      TreeNode right=root.right;
      root.right = root.left;
      root.left=null;
      TreeNode curr = righest(root);
      if (curr!=null) curr.right=right;
      flatten(root.left);
      flatten(root.right);
    }
}