package Tree.GFG;

/*

https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1/?page=2&category[]=Tree&sortBy=submissions#
Given a binary tree of size N, find its reverse level order traversal. ie- the traversal must begin from the last level.

Example 1:

Input :
        1
      /   \
     3     2

Output: 3 2 1
Explanation:
Traversing level 1 : 3 2
Traversing level 0 : 1
Example 2:

Input :
       10
      /  \
     20   30
    / \
   40  60

Output: 40 60 20 30 10
Explanation:
Traversing level 2 : 40 60
Traversing level 1 : 20 30
Traversing level 0 : 10
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Reverse_Level_Order_Traversal {

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}


    static class Tree
    {
        public ArrayList<Integer> reverseLevelOrder(Node root)
        {
                 // code here
                 ArrayList<Integer> al = new ArrayList<>();
                 Queue<Node> main= new LinkedList<>();
                 Queue<Node> helper= new LinkedList<>();
                 HashMap<Integer , ArrayList<Integer>> mp = new HashMap<>();
                 int lvl = 1;
                 if(root!=null)
                 main.add(root);
                 ArrayList<Integer> all = new ArrayList<>();
                 while(!main.isEmpty())
                 {

                     Node curr = main.poll();
                     all.add(curr.data);
                     if(curr.left!=null)
                     helper.add(curr.left);
                      if(curr.right!=null)
                     helper.add(curr.right);

                     if(main.isEmpty())
                     {
                         main = helper;
                         helper = new LinkedList<>();
                         mp.put(lvl,all);
                         lvl++;
                         all = new ArrayList<>();
                     }
                     // System.out.println(all);
                 }

                 int height = ht(root);

                 for(int i = height;i>0;i--)
                 {
                     if(mp.containsKey(i))
                     al.addAll(mp.get(i));
                     height--;
                 }
                 return al;

             }
             static int ht(Node root)
             {
                 if(root == null)
                 return 0;

                 return Math.max(ht(root.left),ht(root.right)) + 1;
        }
    }

}
