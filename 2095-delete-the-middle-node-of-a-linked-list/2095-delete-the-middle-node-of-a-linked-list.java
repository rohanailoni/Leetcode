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
    public ListNode deleteMiddle(ListNode head) {
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        if(len==1){
            return null;
        }
        int mid=len/2; 
        temp=head;
        int c=0;
        while(temp!=null){
            if(c==mid-1){
                if(temp.next.next!=null){
                    temp.next=temp.next.next;
                }else{
                    temp.next=null;
                }
            }
            c++;
            temp=temp.next;
        }
        return head;
        
        
    }
}