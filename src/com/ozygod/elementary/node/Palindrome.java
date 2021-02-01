package com.ozygod.elementary.node;

/**
 * 回文链表
 * 
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode firstHalfNode = headHalfNode(head);
        ListNode lastHalfNode = reverseNode(firstHalfNode.next);

        ListNode p1 = head;
        ListNode p2 = lastHalfNode;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalfNode.next = reverseNode(lastHalfNode);
        return result;
    }

    private ListNode headHalfNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseNode(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] tmp = new int[]{1,1,2,2,2,1,1};
        ListNode head = null;
        for (int i : tmp) {
            ListNode old = head;
            head = new ListNode(i);
            head.next = old;
        }
        Palindrome demo = new Palindrome();
        System.out.println(head);
        System.out.println(demo.isPalindrome(head));
        System.out.println(head);
    }
}
