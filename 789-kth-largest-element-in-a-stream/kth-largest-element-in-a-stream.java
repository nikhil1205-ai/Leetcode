// class KthLargest {
//     PriorityQueue<Integer> pq;
//     int k;
//     public KthLargest(int k, int[] nums) {
//         this.pq=new PriorityQueue<>();
//         this.k=k;
//         for(int n:nums){
//             pq.add(n);
//         }
//     }
    
//     public int add(int val) {
//         pq.add(val);
//         while(pq.size()>k){
//             pq.poll();
//         }
//         return pq.peek();
//     }
// }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */



 class KthLargest {
    class Node {
        int val;
        int size;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.size = 1;
        }
    }

    Node root;
    int k;

    KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            root = insert(root, num);
        }
    }

    int getSize(Node node) {
        return node == null ? 0 : node.size;
    }

    Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        root.size = 1 + getSize(root.left) + getSize(root.right);

        return root;
    }

    int kthLargest(Node root, int k) {
        int rightSize = getSize(root.right);

        if (k == rightSize + 1) {
            return root.val;
        }

        if (k <= rightSize) {
            return kthLargest(root.right, k);
        }

        return kthLargest(root.left, k - rightSize - 1);
    }

    public int add(int val) {
        root = insert(root, val);
        return kthLargest(root, k);
    }
}