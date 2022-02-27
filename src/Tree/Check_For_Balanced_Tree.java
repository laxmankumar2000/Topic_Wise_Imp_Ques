package Tree;

/*
Given a binary tree, find if it is height balanced or not.
A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree.

A height balanced tree
        1
     /     \
   10      39
  /
5

An unbalanced tree
        1
     /
   10
  /
5

Example 1:

Input:
      1
    /
   2
    \
     3
Output: 0
Explanation: The max difference in height
of left subtree and right subtree is 2,
which is greater than 1. Hence unbalanced
Example 2:

Input:
       10
     /   \
    20   30
  /   \
 40   60
Output: 1
Explanation: The max difference in height
of left subtree and right subtree is 1.
Hence balanced.
 */
public class Check_For_Balanced_Tree {
    class Node
    {
        int data;
        Node left,right;

        Node(int d)
        {
            data = d;
            left = right = null;
        }
    }

    public static boolean isBalanced(Node root)
    {
        if(root == null)
            return true;
        int hl = ht(root.left);
        int hr = ht(root.right);

        int diff = Math.abs(hl-hr);

        if(diff>1)
            return false;

        boolean lh = isBalanced(root.left);
        boolean  rh =  isBalanced(root.right);
        return lh&&rh;
    }

    static int ht(Node root)
    {
        if (root == null)
        {
            return 0;
        }
        int left  = ht(root.left);
        int right = ht(root.right);

        return Math.max(left,right)+1;
    }

}
