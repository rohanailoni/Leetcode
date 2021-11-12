class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)return head;
        ListNode dummy = new ListNode(0);
        ListNode p = head,q = dummy;
        
        while(p != null){
            if(p.val == val)p = p.next;
            else{
                q.next = p;
                q = p;
                p = p.next;
            }
        }
        
        q.next = p;
        return dummy.next;
    }
}