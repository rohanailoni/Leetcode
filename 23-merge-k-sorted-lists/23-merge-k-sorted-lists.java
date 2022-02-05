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
    public ListNode mergeKLists(ListNode[] list) {
        int min_index=0;
        ListNode head=new ListNode(0);
        ListNode tail=head;
        
        while(true){
            boolean break_if=true;
            int min=Integer.MAX_VALUE;
            
            for(int i=0;i<list.length;i++){
                if(list[i]!=null){
                    if(list[i].val<min){
                        min=list[i].val;
                        min_index=i;
                    }
                    break_if=false;
                }
            }
            if(break_if)break;
            ListNode temp_node=new ListNode(list[min_index].val);
            tail.next=temp_node;
            tail=tail.next;
            list[min_index]=list[min_index].next;
            
        }
        return head.next;
        
    }
    
}