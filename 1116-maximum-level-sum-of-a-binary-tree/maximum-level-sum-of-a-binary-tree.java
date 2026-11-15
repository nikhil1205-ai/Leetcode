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

    

    public int maxLevelSum(TreeNode root) {
        int max=Integer.MIN_VALUE;
        int level=0;
        int le=1;
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        while(que.size()>0){
          int sum=0;
          int k=que.size();
          for(int i=0;i<k;i++){
            TreeNode node=que.poll();
            sum+=node.val;
            if(node.left!=null) que.add(node.left);
            if(node.right!=null) que.add(node.right);
          }
          if(max<sum){
            max=sum;
            level=le;
          }
          le++;
        }

        return level;
    }
}