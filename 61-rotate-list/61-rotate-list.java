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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail=head;
        int n=0;
        while(tail!=null){
            n++;
            tail=tail.next;
        }
        if(n==0){
            return head;
        }
        int arr[]=new int[n];
        tail=head;
        int i=0;
        while(tail!=null){
            arr[i]=tail.val;i++;
            tail=tail.next;
        }
        
        k=k%n;
        int top=0;
        int end=n-1;
        while(top<end){
            int temp=arr[end];
            arr[end]=arr[top];
            arr[top]=temp;
            top++;
            end--;
            
        }
        top=0;
        end=k-1;
        while(top<end){
            int temp=arr[end];
            arr[end]=arr[top];
            arr[top]=temp;
            top++;
            end--;
        }
        top=k;
        end=n-1;
        while(top<end){
            int temp=arr[end];
            arr[end]=arr[top];
            arr[top]=temp;
            top++;
            end--;
        }
        i=0;
        tail=head;
        while(tail!=null){
            tail.val=arr[i];i++;
            tail=tail.next;
        }
        return head;
        
    }
}