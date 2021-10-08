package BinaryTree;
import java.util.*;
/**
 * @author didi
 * @create 2021/9/18 6:57 下午
 * 打印二叉树
 */
public class OfferLevelOrder {
   /* public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];  //树为空

        Queue<TreeNode> queue = new LinkedList<>(){{ add(root); }};  // 新建队列 添加根节点
        ArrayList<Integer> ans = new ArrayList<>();    // 新建空数组

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();    // 队首出队：检索并删除此队列的头
            ans.add(node.val);     // 将该元素放到数组中
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }*/
}
