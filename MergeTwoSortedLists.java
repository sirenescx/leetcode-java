/* Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the 
 * nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode currentNode = null;
        ListNode head = null;
        ListNode previousNode = null;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                currentNode = l1;
                l1 = l1.next;
            } else {
                currentNode = l2;
                l2 = l2.next;
            }

            if (previousNode != null) {
                previousNode.next = currentNode;
            } else {
                head = currentNode;
            }

            previousNode = currentNode;
        }

        if (l1 != null) {
            currentNode.next = l1;
        } else {
            currentNode.next = l2;
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return dummyHead.next;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2)
    {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }
    }
}