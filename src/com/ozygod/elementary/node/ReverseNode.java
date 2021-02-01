package com.ozygod.elementary.node;

/**
 * 反转一个单链表。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnhm6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ReverseNode {
    public ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    public ListNode reverseNode1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] tmp = new int[]{5,4,3,2,1};
        ListNode node = null;
        for (int i : tmp) {
            ListNode old = node;
            node = new ListNode(i);
            node.next = old;
        }
        ReverseNode demo = new ReverseNode();
        System.out.println(node);
        System.out.println(demo.reverseNode1(node));
        System.out.println(node);
    }
}
