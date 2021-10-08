package BinaryTree;

public class BinaryTreeNode {

    private int data;  //数据
    private BinaryTreeNode lchild;  //左孩子
    private BinaryTreeNode rchild; //右孩子

    public BinaryTreeNode(String x) {


    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public BinaryTreeNode getLeftChild() {
        return lchild;
    }
    public void setLeftChild(BinaryTreeNode lchild) {
        this.lchild = lchild;
    }
    public BinaryTreeNode getRightChild() {
        return rchild;
    }
    public void setRightChild(BinaryTreeNode rchild) {
        this.rchild = rchild;
    }



}
