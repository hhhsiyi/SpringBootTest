package com.hewen.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021/10/11
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 二叉树的中序遍历94题 {
    @Test
    public void test01() {
        TreeNode t2 = new TreeNode(9);
        TreeNode t4 = new TreeNode(15, null, null);
        TreeNode t5 = new TreeNode(7, null, new TreeNode(3));
        TreeNode t3 = new TreeNode(20, t4, t5);
        TreeNode t1 = new TreeNode(3, t2, t3);
        System.out.println(t1);
        System.out.println(inorderTraversal(t1));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
