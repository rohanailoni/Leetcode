// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode partition(ListNode head, int x) {
//         ListNode temp=head;
//         ListNode top=head;
//         int len=0;
//         while(temp.next!=null){
//             if(temp.val==x){
//                 top=temp;
//             }
//             temp=temp.next;
//             len++;
//         }
//         x=top.val;
//         top.val=temp.val;
//         temp.val=x;
//         int pivot=temp.val;
//         ListNode wall=head;
//         ListNode i=head;
//         for(int j=0;j<=len;j++){
//             if(wall.val<pivot){
//                 swap(i,wall);
                
//                 i=i.next;
                
//             }
//             wall=wall.next;
//         }
//         swap(temp,i);
//         return head;
//     }
//     static void swap(ListNode i, ListNode j)
//     {
//         int temp = i.val;
//         i.val =j.val;
//         j.val = temp;
//     }
// }
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        
        ListNode leftTail = left;
        ListNode rightTail = right;
        
        while(head != null){
            if(head.val < x){
                leftTail.next = head;
                leftTail = leftTail.next;
            }
            else{
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        
        leftTail.next = right.next;
        rightTail.next = null;
        
        return left.next;
    }
}