class Solution {
    private ListNode merge(ListNode left, ListNode right, ListNode res) {
        while(left != null && right != null) {
            if(left.val < right.val) {
                res.next = left;
                left = left.next;
            }
            else {
                res.next = right;
                right = right.next;
            }
            res = res.next;
        }
        if(left != null) res.next = left;
        if(right != null) res.next = right;
        while(res.next != null) res = res.next;
        return res;
    }
    private ListNode split(ListNode head, int cnt) {
        if(head == null) return head;
        for(int i = 1; i < cnt && head.next != null; i++) head = head.next;
        ListNode right = head.next;
        head.next = null;
        return right;
    }
    public ListNode sortList(ListNode head) {
        ListNode temp = head;
        int cnt = 0;
        while(temp != null) {
            ++cnt;
            temp = temp.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        for(int i = 1; i < cnt; i *= 2) {
            ListNode res = dummy;
            ListNode curr = dummy.next;
            while(curr != null) {
                ListNode left = curr;
                ListNode right = split(left, i);
                curr = split(right, i);
                res = merge(left, right, res);
            }
        }
        return dummy.next;
    }
}