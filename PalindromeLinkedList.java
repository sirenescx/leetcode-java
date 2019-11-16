/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean isPalindrome1(ListNode head) {  
        if (head == null) {
            return true;
        }
        
        ListNode startHead = head;
        ListNode newHead = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode tempHead = new ListNode(head.val);
            tempHead.next = newHead;
            newHead = tempHead;
            head = head.next;
        }
        
        while (startHead != null) {
            if (startHead.val != newHead.val) {
                return false;
            }
            startHead = startHead.next;
            newHead = newHead.next;
        }
        
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        ArrayList<Integer> rList = new ArrayList<>(list);
        Collections.reverse(rList);
        return Objects.equals(rList, list);
    }

    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        
        ListNode pre = null;
        ListNode curr = newHead;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        
        ListNode p1 = head;
        ListNode p2 = pre;
        
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return true;
    }
}