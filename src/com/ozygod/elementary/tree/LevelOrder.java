package com.ozygod.elementary.tree;

import java.util.*;

/**
 * 二叉树的层序遍历
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnldjj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Deque<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(root);
        Deque<TreeNode> queue2 = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        while (!queue1.isEmpty()) {
            TreeNode tmp1 = queue1.poll();
            item.add(tmp1.val);
            if (queue1.isEmpty()) {
                result.add(item);
                item = new ArrayList<>();
            }
            if (tmp1.leftNode != null) queue2.offer(tmp1.leftNode);
            if (tmp1.rightNode != null) queue2.offer(tmp1.rightNode);

            if (!queue1.isEmpty()) continue;

            while (!queue2.isEmpty()) {
                TreeNode tmp2 = queue2.poll();
                item.add(tmp2.val);
                if (queue2.isEmpty()) {
                    result.add(item);
                    item = new ArrayList<>();
                }
                if (tmp2.leftNode != null) queue1.offer(tmp2.leftNode);
                if (tmp2.rightNode != null) queue1.offer(tmp2.rightNode);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        LevelOrder demo = new LevelOrder();
        System.out.println(demo.levelOrder(root));
    }
}
