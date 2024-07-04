class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        k = k % getLinkedListLength(head);
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; ++i) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
    }

    private int getLinkedListLength(ListNode head) {
        int len = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            ++len;
        }
        return len;
    }
}