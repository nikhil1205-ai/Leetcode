
class Solution {
    boolean func(TreeNode lroot, TreeNode rroot){
        if(lroot == null && rroot == null) return true;
        if(lroot==null || rroot==null) return false;
        if(lroot.val!=rroot.val) return false;
        return func(lroot.left,rroot.right) && func(rroot.left,lroot.right);

    }
    public boolean isSymmetric(TreeNode root) {
        return func(root.left,root.right);
    }
}