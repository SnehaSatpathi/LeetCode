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
    public ListNode deleteDuplicates(ListNode head) {
        // Handle empty list or single-node list
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        
        // Traverse the list until the second to last node
        while (current != null && current.next != null) {
            // If the next node has the same value, skip it
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                // Otherwise, move the pointer forward
                current = current.next;
            }
        }
        
        return head;
    }
}