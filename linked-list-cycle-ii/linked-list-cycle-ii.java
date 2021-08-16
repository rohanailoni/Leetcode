/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)return null;
        HashSet<ListNode>set=new HashSet<>();
        ListNode parse=head;
        while(parse.next!=null){
            if(set.add(parse)){
                parse=parse.next;
            }
            else{
                return parse;
            }
            
            
        }
        return null;
    }
}