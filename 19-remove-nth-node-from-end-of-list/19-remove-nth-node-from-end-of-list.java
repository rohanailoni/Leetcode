
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        if(len==1){
            return null;
        }
        int end=len-n-1;
        if(end==-1){
            head=head.next;
            return head;
        }
        temp=head;
        int c=0;
        
        while(temp!=null){
            if(c==end){

                if(temp.next.next!=null){
                    temp.next=temp.next.next;
                }else{
                    temp.next=null;
                    
                }
                return head;
            }
            c++;
            temp=temp.next;
        }
        return head;
    }
}