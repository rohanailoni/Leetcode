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
    public ListNode swapNodes(ListNode head, int k) {
        int len=0;
        ListNode temp;
        temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
            
        }
        if(len==1){
            return head;
        }
        temp=head;
        int end=len-k;
        ListNode mid=null;
        int c=0;
        System.out.println(len);
        while(temp!=null){
            if(c==k-1){
                if(mid==null)mid=temp;
                else{
                    int t=mid.val;
                    mid.val=temp.val;
                    temp.val=t;
                }
                
            }
            if(c==end){
                if(mid==null){
                    mid=temp;
                }
                else{
                    int t=mid.val;
                    mid.val=temp.val;
                    temp.val=t;
                }
                
            }
            c++;
            temp=temp.next;
        }
        return head;
        
        
    }
}