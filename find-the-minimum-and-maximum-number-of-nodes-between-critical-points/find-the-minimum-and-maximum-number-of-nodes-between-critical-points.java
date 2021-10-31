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
//     public int[] nodesBetweenCriticalPoints(ListNode head) {
//         if(head.next==null){
//             return new int[]{-1,-1};
//         }
//         if(head.next.next==null){
//             return new int[]{-1,-1};
//         }
//         int d=1;
//         ListNode x=head;
//         ListNode y=head.next;
//         ListNode z=head.next.next;
//         List<Integer>dist=new ArrayList<>();
//         while(z!=null){
//             if(y.val>x.val && y.val>z.val ){
//                 dist.add(d);
//             }else if(y.val<x.val && y.val<z.val){
//                 dist.add(d);
//             }
//             x=x.next;
//             y=y.next;
//             z=z.next;
//             d++;
//         }
        
        
//         if(dist.size()==0){
//             return new int[]{-1,-1};
//         }if(dist.size()==1){
//             return new int[]{-1,-1};
//         }
//         System.out.println(dist+" "+dist.get(dist.size()-2));
//         int max=dist.get(dist.size()-1)-dist.get(0);
//         int min=dist.get(dist.size()-1)-dist.get(dist.size()-2);
//         return new int[]{min,max};
//     }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        //three pointers to get min/max critical points 
        int firstCP=-1, prevCP=-1, currCP=-1;
        int minCP =-1, maxCP =-1;
        int i=1;
        ListNode prevNode = null;
        ListNode currNode = head;
        while(currNode != null) {
            //set min & max
            if(firstCP != -1 && currCP>firstCP) {
                if(minCP ==-1) {
                    minCP = currCP-prevCP;
                } else{
                    minCP = Math.min(minCP, currCP-prevCP);    
                }
                maxCP = Math.max(maxCP, currCP-firstCP);
            }
            if(prevNode !=null && currNode.next !=null) {
                //critical point check
                if((currNode.val<prevNode.val && currNode.val<currNode.next.val) ||
                   currNode.val>prevNode.val && currNode.val>currNode.next.val) {
                    if(firstCP==-1) {
                        firstCP=i;
                        currCP=i;
                    } else {
                        prevCP = currCP;
                        currCP=i;
                    }
                }
            }
            i++;
            prevNode = currNode;
            currNode = currNode.next;
        }
        return new int[] {minCP, maxCP};
    }
}