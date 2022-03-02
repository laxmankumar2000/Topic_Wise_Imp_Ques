package Tree.GFG;


/*

Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Return nodes from leftmost node to rightmost node.

Example 1:

Input:
      1
   /    \
  2      3
Output: 2 1 3
Example 2:

Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100

 */

import org.w3c.dom.Node;

import java.util.ArrayList;

public class Top_View_of_Binary_Tree {

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


    static class Solution
    {
        //Function to return a list of nodes visible from the top view
        //from left to right in Binary Tree.
        static ArrayList<Integer> topView(Node root)
        {
            // add your code
            // Queue<Integer> q = new LinkedList<>();
            // q.add(root.data);
            // while(!q.isEmpty())
            // {
            //     if(root.left!=null)
            //     {

            //     }
            // }
            ArrayList<Integer> al = new ArrayList<>();
            return sol(root,0,0,al);

        }
        static ArrayList<Integer> sol(Node root,int n ,int m ,ArrayList<Integer> al)
        {
            if(root == null)
                return new ArrayList<>();
            if(m==0)
                sol(root.left,n+1,m,al); al.add(root.data);
            if(n==0)
            {
                sol(root.right,n,m+1,al);
            }

            return al;
        }
    }
}
