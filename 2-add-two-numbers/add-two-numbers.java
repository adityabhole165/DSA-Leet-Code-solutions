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
 import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger n1 = extract(l1);
        BigInteger n2 = extract(l2);
        BigInteger sum = n1.add(n2);

        return buildList(sum.toString());
    }

    private BigInteger extract(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while(node != null) {
            sb.insert(0,node.val);
            node = node.next;
        }
        return new BigInteger(sb.toString());
    }

    private ListNode buildList(String numStr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for(int i = numStr.length() - 1; i >= 0; i--){
            curr.next = new ListNode(numStr.charAt(i) - '0');
            curr = curr.next;
        }
        return dummy.next;
    }
}
