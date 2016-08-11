/**
 * 
 */
package q101to150;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

/**
 * @author kje511
 *
 */
public class Q104MaximumDepthofBinaryTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int curLevel = 0;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>(Arrays.asList(root));
        
        while (!queue.isEmpty())  {
            curLevel ++;
            int size = queue.size();
            
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        return curLevel;
    }
}
