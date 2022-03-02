package Tree.LeetCode;

/*

623. Add One Row to Tree
Medium

1205

170

Add to List

Share
Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:

Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.


Example 1:


Input: root = [4,2,6,3,1,5], val = 1, depth = 2
Output: [4,1,1,2,null,null,6,3,1,5]
Example 2:


Input: root = [4,2,null,3,1], val = 1, depth = 3
Output: [4,2,null,1,1,3,null,null,1]
 */

public class add_One_Row_To_Tree {

//     Definition for a binary tree node.
     public static class TreeNode {
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

    static class Solution {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if(root == null)
                return root;
            if(depth == 1)
            {
                TreeNode node1 = new TreeNode(val);
                node1.left=root;
                return node1;
            }
            return addOneRow1(root,val,1,depth);

        }
        static TreeNode addOneRow1(TreeNode root, int val, int curr, int depth)
        {
            if(root== null)
                return new TreeNode();
            if( curr == depth-1 )
            {
                TreeNode newnode = new TreeNode(val);
                TreeNode newnode1 = new TreeNode(val);
                TreeNode leftNode = root.left;
                TreeNode rightNode = root.right;



                root.left = newnode;
                root.right = newnode1;



                root.left.left = leftNode;
                root.left.right = null;
                root.right.left = null;

                root.right.right = rightNode;

            }

            if(curr<depth)
            {
                addOneRow1(root.left,val , curr+1,depth);
                addOneRow1(root.right,val,curr+1,depth);

            }
            return root;
        }
    }
}
