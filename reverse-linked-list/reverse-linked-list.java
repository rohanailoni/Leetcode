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
    private ListNode rev(ListNode head){
        ListNode pre=null;
        ListNode temp=null;
        while(head!=null){
            temp=head;
            head=head.next;
            temp.next=pre;
            pre=temp;
        }
        return pre;
    }
    public ListNode reverseList(ListNode head) {
        return rev(head);
    }
}
