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

  //Solution 1: create a new ListedList with reversed order,
  //interate both originla linkedlist and reversed linkedlist to check if current item have same value
    public boolean isPalindrome(ListNode head) {
        ListNode reverseNode = new ListNode();
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            ListNode temp = new ListNode(cur.val);
            temp.next = reverseNode;
            reverseNode = temp;
            cur = cur.next;
            count++;
        }

        for (int i = 0; i < count / 2; i++) {
            if (head.val != reverseNode.val) {
                return false;
            }
            head = head.next;
            reverseNode = reverseNode.next;
        }
        return true;
    }

    //Solution 2: in memory Solution (快慢指针)
    //利用快慢指针来找到linkedlist 的中间点， 然后reverse second half
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        ListNode cur2 = head;
        //利用快慢指针找到中间点
        while(cur2.next != null && cur2.next.next != null) {
            cur = cur.next;
            cur2 = cur2.next.next;

        }
        ListNode prev = null;
        ListNode reverseNode = cur.next;
        cur.next = null;
        while (reverseNode != null) {
            ListNode temp = reverseNode.next;
            reverseNode.next = prev;
            prev = reverseNode;
            reverseNode = temp;
        }
        cur = head;
        //be careful, also need to check prev node is null or not
        //if linkedlist only have 1 node, then prev will be null
        while (cur != null && prev != null) {
            if (cur.val != prev.val) {
                return false;
            }
            cur = cur.next;
            prev = prev.next;
        }
        return true;
    }
}
