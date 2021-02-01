package com.ozygod.elementary.node;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class DeleteOrderNode {
    class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0, head);
        ListNode fast = head;
        ListNode low = tmp;
        while (fast != null) {
            if (n > 0) n--;
            else {
                low = low.next;
            }
            fast = fast.next;
        }
        low.next = low.next.next;
        return tmp.next;
    }

    public ListNode getInstance(int val) {
        return new ListNode(val);
    }

    public static void main(String[] args) {
        int[] tmp = new int[]{5,4,3,2,1};
        DeleteOrderNode demo = new DeleteOrderNode();
        ListNode node = null;
        for (int i : tmp) {
            ListNode old = node;
            node = demo.getInstance(i);
            node.next = old;
        }
        System.out.println(node);
        System.out.println(demo.removeNthFromEnd(node, 2));
        System.out.println(node);
    }
}
