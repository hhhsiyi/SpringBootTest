package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/19
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 合并二叉树617题简单 {

    @Test
    public void test01() {
//        TreeNode t2 = new TreeNode(9);
//        TreeNode t4 = new TreeNode(15, null, null);
//        TreeNode t5 = new TreeNode(7, null, new TreeNode(3));
//        TreeNode t3 = new TreeNode(20, t4, t5);
//        TreeNode t1 = new TreeNode(3, t2, t3);
//        System.out.println(t1);
        //System.out.println(preorderTraversal(t1));
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        System.out.println(treeNode);//右树
        TreeNode tt1 = new TreeNode(1);
        TreeNode tt2 = new TreeNode(3);
        TreeNode tt3 = new TreeNode(2);
        TreeNode tt4 = new TreeNode(5);
        tt1.left = tt2;
        tt1.right = tt3;
        tt2.left = tt4;
        System.out.println(tt1);
        TreeNode treeNode5 = mergeTrees(tt1, treeNode);
        System.out.println(treeNode5);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode treeNode = new TreeNode(root1.val + root2.val);
        treeNode.left = mergeTrees(root1.left, root2.left);
        treeNode.right = mergeTrees(root1.right, root2.right);
        return treeNode;
    }
}
