class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        boolean indi=false;
        while(!que.isEmpty()){
            List<Integer> in=new ArrayList<>();
            int k=que.size();
            for(int i=0;i<k;i++){
                TreeNode curr=que.poll();
                in.add(curr.val);
                if(curr.left!=null) que.add(curr.left);
                if(curr.right!=null) que.add(curr.right);
            }
            if(indi) Collections.reverse(in);
            indi=!indi;
            list.add(in);
        }

        return list;

    }
}