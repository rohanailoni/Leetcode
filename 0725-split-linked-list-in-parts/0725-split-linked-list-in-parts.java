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
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        if (k == 1) {
            res[0] = root;
            return res;
        }
        int n = getLength(root);
        ListNode pre = null;
        for (int i = 0; i < k; i++) {
            res[i] = root;
            int j = n / k + (i < n % k ? 1 : 0);
            while (root != null && j > 0) {
                pre = root;
                root = root.next;
                j--;
            }
            if (pre != null) pre.next = null;
        }
        return res;
    }

    private int getLength(ListNode root) {
        int len = 0;
        while (root != null) {
            len++;
            root = root.next;
        }
        return len;
    }
}