package FirstPackage;
/*二叉树的构建--深度优先遍历
* 先序遍历
* 中序遍历
* 后序遍历
* */

import java.util.*;

public class binaryTree {
    public static String[] str;
    public static int count;

    /**
     * 静态内部类，定义二叉树节点
     */
    static class TreeNode {
        public String data;  // 数据
        TreeNode lchild;   // 左孩子
        TreeNode rchild;   // 右孩子
        public TreeNode(String x) {
            this.data = x;
        }
    }

    /**
     * 根据前序序列递归构建二叉树
     * @return
     */

    public static TreeNode createBtree() {
        TreeNode root = null;
        if (count >= str.length || str[count++].equals("#")) {
            root = null;
        } else {
            root = new TreeNode(str[count - 1]);
            root.lchild = createBtree();
            root.rchild = createBtree();
        }
        return root;
    }

    /**
     * 前序遍历
     * @param root
     */

    public static void preTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preTraverse(root.lchild);
        preTraverse(root.rchild);

    }

    /**
     *  中序遍历
     * @param root
     */

    public static void inTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inTraverse(root.lchild);
        System.out.print(root.data + " ");
        inTraverse(root.rchild);

    }

    /**
     * 后序遍历
     * @param root
     */

    public static void postTraverse(TreeNode root) {
        if (root == null) {
           return;
        }
        postTraverse(root.lchild);
        postTraverse(root.rchild);
        System.out.print(root.data + " ");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            str = s.split(",");
            count = 0;
            TreeNode root = createBtree();
// 前序遍历
            preTraverse(root);
            System.out.println();   // 打印空行
// 中序遍历
            inTraverse(root);
            System.out.println();

// 后序遍历
            postTraverse(root);
            System.out.println();

        }

    }

}


