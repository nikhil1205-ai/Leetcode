/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int k=que.size();

            Node curr=que.poll();
            if(curr!=null )que.add(curr.left);
            if(curr!=null ) que.add(curr.right);

            for(int i=1;i<k;i++){
                Node next=que.poll();
                if(curr!=null ) curr.next=next;
                if(next!=null ) que.add(next.left);
                if(next!=null ) que.add(next.right);
                curr=next;
            }
        }
        return root;
    }
}