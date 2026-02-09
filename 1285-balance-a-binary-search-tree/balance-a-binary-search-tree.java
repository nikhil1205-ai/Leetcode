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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);
       
       return constructTree(0,list.size()-1,list);
    }

    public TreeNode constructTree(int low,int high,ArrayList<Integer> list){
        if(low>high){
            return null;
        }

        int mid=(low+high)/2;

        TreeNode root=new TreeNode(list.get(mid));

        root.left=constructTree(low,mid-1,list);
        root.right=constructTree(mid+1,high,list);

        return root;
    }

    public void inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null) return ;

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}