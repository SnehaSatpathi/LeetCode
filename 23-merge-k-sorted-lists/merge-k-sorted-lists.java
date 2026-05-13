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
        ArrayList<Integer> arr = new ArrayList<>();
        // take all values
        for (ListNode head : lists) {
            while (head != null) {
                arr.add(head.val);
                head = head.next;
            }
        }
        // sort values
        Collections.sort(arr);
        // if empty
        if (arr.size() == 0) {
            return null;
        }
        // make linked list
        ListNode head = new ListNode(arr.get(0));
        ListNode temp = head;
        for (int i = 1; i < arr.size(); i++) {
            temp.next = new ListNode(arr.get(i));
            temp = temp.next;
        }
        return head;
    }
}