/**
 * 
 */
package q101to150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import common.TreeNode;

/**
 * @author kje511
 *
 */
public class Q102BinaryTreeLevelOrderTraversal {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> curQueue = new LinkedList<TreeNode>(Arrays.asList(root));
        
        
        
        while (!curQueue.isEmpty()) {
            
            List<Integer> curResult = new ArrayList<Integer>();
            LinkedList<TreeNode> nextQueue = new LinkedList<TreeNode>();

            while (!curQueue.isEmpty()) {
                TreeNode node = curQueue.poll();

                curResult.add(node.val);
                if (node.left != null) {
                    nextQueue.add(node.left);
                }
                if (node.right != null) {
                    nextQueue.add(node.right);
                }
            }

            result.add(curResult);
            curQueue = nextQueue;

        }
        return result;
    }

}
