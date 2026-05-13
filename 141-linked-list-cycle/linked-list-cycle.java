/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
                // Create a unique dummy marker node
        ListNode dummy = new ListNode(0);
        
        ListNode curr = head;
        while (curr != null) {
            // If next points to dummy, we have been here before
            if (curr.next == dummy) {
                return true;
            }
            
            // Save next node, then point current node to dummy
            ListNode temp = curr.next;
            curr.next = dummy;
            curr = temp;
        }
        
        return false;      
    }
}