package BinaryTree;

import FirstPackage.binaryTree;

import javax.swing.tree.TreeNode;
import java.util.Scanner;

public class BinaryTree {

    public static String[] str;
    public static int count;

    private BinaryTreeNode root;

    //初始化二叉树
    public static BinaryTreeNode BinaryTree(){
        BinaryTreeNode root = null;
        if (count >= str.length || str[count++].equals("#")) {
            root = null;
        } else {
            root = new BinaryTreeNode (str[count-1]);
         /*   root.lchild = createBtree();
            root.rchild = createBtree();*/
        }
        return root;

    }

    public BinaryTree(BinaryTreeNode root){
        this.root = root;
    }
    public void setRoot(BinaryTreeNode root){
        this.root = root;
    }
    public BinaryTreeNode getRoot(){
        return root;
    }


    public static  void PostOrder(BinaryTreeNode node){
        if(node!=null){
            PostOrder(node.getLeftChild());  //后根遍历左子树
            PostOrder(node.getRightChild());  //后根遍历右子树
            System.out.println(node);   //访问根节点
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            str = s.split(",");
            count = 0;
            BinaryTreeNode root = BinaryTree();
// 前序遍历
           /* preTraverse(root);
            System.out.println();
// 中序遍历
            inTraverse(root);
            System.out.println();*/

// 后序遍历
            PostOrder(root);
            System.out.println();

        }

    }
}







