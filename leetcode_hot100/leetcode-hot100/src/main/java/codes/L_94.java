package codes;

import java.util.ArrayList;
import java.util.List;

//给定一个二叉树的根节点 root ，返回它的 中序 遍历 。
//解题思路：递归法或迭代法
public class L_94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode node, List<Integer> list){
        if(node == null) return;

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
    public static void main(String[] args){
        //测试用例

    }
}
