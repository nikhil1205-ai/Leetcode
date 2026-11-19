

// class Solution {
//     public Node connect(Node root) {
//         Queue<Node> que=new LinkedList<>();
//         que.add(root);
//         while(!que.isEmpty()){
//             int k=que.size();

//             Node curr=que.poll();
//             if(curr!=null )que.add(curr.left);
//             if(curr!=null ) que.add(curr.right);

//             for(int i=1;i<k;i++){
//                 Node next=que.poll();
//                 if(curr!=null ) curr.next=next;
//                 if(next!=null ) que.add(next.left);
//                 if(next!=null ) que.add(next.right);
//                 curr=next;
//             }
//         }
//         return root;
//     }
// }

class Solution {
    Node[] prev = new Node[13];
    
    public Node connect(Node root) {
        dfs(root, 0);
        return root;
    }

    private void dfs(Node root, int d){
        if(root == null) return;
        dfs(root.right, d+1);
        dfs(root.left, d+1);

        root.next = prev[d];
        prev[d] = root;
    }
}