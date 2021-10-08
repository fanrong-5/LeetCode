package Test;


import java.util.Scanner;

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
     * 构建二叉树
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



    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            str = s.split(",");
            count = 0;
            TreeNode root = createBtree();


        }

    }

}


