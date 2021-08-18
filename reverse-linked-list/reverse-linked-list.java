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
    public ListNode reverseList(ListNode head) {
        List<Integer>n=new ArrayList<>();
        ListNode tail=head;
        while(tail!=null){
            n.add(tail.val);
            tail=tail.next;
            
        }
        int i=0;int j=n.size()-1;
        while(i<j){
            int temp=n.get(i);
            n.set(i,n.get(j));
            n.set(j,temp);
            i++;
            j--;
        }
        
        int k=0;
        tail=head;
        while(tail!=null){
            tail.val=n.get(k);
            tail=tail.next;
            k++;
        }
        return head;
    }
}