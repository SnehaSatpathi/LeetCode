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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);
        // add first node of every list
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode head = null;
        ListNode tail = null;
        while (!pq.isEmpty()) {
            ListNode small = pq.poll();
            // first node
            if (head == null) {
                head = small;
                tail = small;
            }
            else {
                tail.next = small;
                tail = tail.next;
            }
            // add next node
            if (small.next != null) {
                pq.add(small.next);
            }
        }
        return head;
    }
}