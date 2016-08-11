/**
 * 
 */
package q101to150;

import common.TreeNode;

/**
 * @author kje511
 *
 */
public class Q105ConstructBinaryTreefromPreorderandInorderTraversal {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    static private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        int rootVal = preorder[ps];
        TreeNode root = new TreeNode(rootVal);

        if (ps == pe) {
            return root;
        }

        int i;
        for (i = is; i <= ie; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
        }

        int inOrder_SplitIndex = i;
        int rightMostInLeftVal = inorder[i - 1];

        int j;
        for (j = ps + 1; j <= pe; j++) {
            if (preorder[j] == rightMostInLeftVal) {
                break;
            }
        }

        int preOrder_SplitIndex = j;

        TreeNode leftChild = buildTree(preorder, ps + 1, preOrder_SplitIndex, inorder, is, inOrder_SplitIndex - 1);

        TreeNode rightChild = buildTree(preorder, preOrder_SplitIndex + 1, pe, inorder, inOrder_SplitIndex + 2, ie);

        root.left = leftChild;
        root.right = rightChild;

        return root;
    }

}
