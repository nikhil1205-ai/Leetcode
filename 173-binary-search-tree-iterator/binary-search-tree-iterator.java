class BSTIterator {
    List<Integer> list;
    int pointer;
    void inorder(TreeNode root,List<Integer> list){
       if(root==null) return;
       inorder(root.left,list);
       list.add(root.val);
       inorder(root.right,list);
    }
    public BSTIterator(TreeNode root) {
        this.pointer=0;
        this.list=new ArrayList<>();
        inorder(root,list);
    }
    
    public int next() {
        int val=list.get(pointer);
        pointer++;
        return val;
    }
    
    public boolean hasNext() {
        return pointer<list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */