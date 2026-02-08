class Solution {
    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        int lsub = height(root.left);
        int rsub = height(root.right);
        
        if (Math.abs(lsub - rsub) > 1) return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
