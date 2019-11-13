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
}