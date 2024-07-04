class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode node1, ListNode node2) {
        return node1.val - node2.val;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            tail.next = node;
            if (heap.isEmpty()) break;
            tail = tail.next;
            node = node.next;
            if (node != null) heap.add(node);
        }
        return head.next;
    }
}