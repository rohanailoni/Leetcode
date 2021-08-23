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
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer,Integer>map =new HashMap<>();
        ListNode tail=head;
        while(tail!=null){
            map.put(tail.val,map.getOrDefault(tail.val,0)+1);
            tail=tail.next;
            
        }
        tail=head;
        ListNode tail1=head;
        while(tail!=null){
            
            if(map.get(tail.val)>1){
                // System.out.print(tail.val);
                // System.out.println(tail1.val);
                if(tail==head){
                    tail=tail.next;
                    tail1=tail1.next;
                    head=head.next;
                  }
                else{
                    tail=tail.next;
                    tail1.next=tail;
                }
                
                
                
            }
            else{
                if(tail==head){
                    tail=tail.next;
                    
                }
                else{
                    
                    tail=tail.next;
                    
                    tail1=tail1.next;
                }
                
            }
            
        }
        return head;
    }
}