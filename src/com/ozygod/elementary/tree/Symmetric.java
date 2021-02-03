package com.ozygod.elementary.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn7ihv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
//        return check(root, root);
        return isSymmetric(root.leftNode, root.rightNode);
    }

    private boolean check(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(t1);
        queue.offer(t2);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if (n1 == null && n2 == null) continue;

            if ((n1 == null || n2 == null) || n1.val != n2.val) return false;

            queue.offer(n1.leftNode);
            queue.offer(n2.rightNode);

            queue.offer(n1.rightNode);
            queue.offer(n2.leftNode);
        }
        return true;
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if ((left == null || right == null) || left.val != right.val) return false;
        if (!isSymmetric(left.leftNode, right.rightNode)) return false;
        if (!isSymmetric(left.rightNode, right.leftNode)) return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        Symmetric demo = new Symmetric();
        System.out.println(demo.isSymmetric(root));
    }
}
