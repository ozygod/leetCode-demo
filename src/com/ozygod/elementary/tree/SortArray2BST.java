package com.ozygod.elementary.tree;

/**
 * 将有序数组转换为二叉搜索树
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xninbt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SortArray2BST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return put(nums, 0, nums.length-1);
    }

    public TreeNode put(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.leftNode = put(nums, lo, mid-1);
        root .rightNode = put(nums, mid+1, hi);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        SortArray2BST demo = new SortArray2BST();
        System.out.println(demo.sortedArrayToBST(nums));
    }
}
