package com.hewen.leetcode;

import org.junit.Test;

/**
 * 2021/10/11
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class 平衡二叉树110题 {
    @Test
    public void test01() {
        TreeNode t2 = new TreeNode(9);
        TreeNode t4 = new TreeNode(15,null,null);
        TreeNode t5 = new TreeNode(7,null,new TreeNode(3));
        TreeNode t3 = new TreeNode(20,t4,t5);
        TreeNode t1 = new TreeNode(3,t2,t3);
        System.out.println(t1);
        System.out.println(isBalanced(t1));
    }

    public boolean isBalanced(TreeNode root) {
        // 首先计算左右子树的高度，
        // 如果左右子树的高度差是否不超过 11，
        // 再分别递归地遍历左右子节点，
        // 并判断左子树和右子树是否平衡。
        // 这是一个自顶向下的递归的过程。
        if (root==null)
            return true;
        else {
            return Math.abs(getHeight(root.left)-getHeight(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
        }
        //判断二叉树是否是平衡二叉树，类似于二叉树的前序遍历？
    }
    public int getHeight(TreeNode root){
        if (root==null){
            return 0;
        }
        else {
            return Math.max(getHeight(root.left),getHeight(root.right))+1;
        }
    }
}
