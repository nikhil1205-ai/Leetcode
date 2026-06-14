/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int findNode(ListNode head,int k){
        ListNode temp=head;
        for(int i=0;i<k;i++){
           temp=temp.next;
        }
        return temp.val;
    }

    int findLength(ListNode head){
        ListNode temp=head;
        int n=0;
        while(temp!=null){
          n++;
          temp=temp.next;
        }
        return n;
    }
   
    // public int pairSum(ListNode head) {
    //     int max=0;
    //     int n=findLength(head);
    //     for(int i=0;i<(n/2);i++){
    //         int fr=findNode(head,i);
    //         int Re=findNode(head,n-1-i);
    //         max=Math.max(fr+Re,max);
    //     }
    //     return max;
    // }

    public int pairSum(ListNode head) {
        int max=0;
        int n=findLength(head);
        ArrayList<Integer> arr=new ArrayList<>();
        ListNode temp=head;
        for(int i=0;i<n;i++){
            if(i<n/2){
                arr.add(temp.val);
            }else{
                arr.set(n-i-1, arr.get(n-i-1)+temp.val);
            }
            temp=temp.next;
        }
        for(int m:arr) max=Math.max(m,max);
        return max;
    }
}