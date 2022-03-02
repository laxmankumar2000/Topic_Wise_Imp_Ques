package Tree.GFG;

/*

Complete the function to find spiral order traversal of a tree. For below tree, function should return 1, 2, 3, 4, 5, 6, 7.





Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40
 */

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class lvl_Order_spiral_form {

    public class Node {
        int data;
        Node left;
        Node right;
    }

    class Spiral {
        //Function to return a list containing the level order
        //traversal in spiral form.
        ArrayList<Integer> findSpiral(Node root) {
            ArrayList<Integer> al = new ArrayList<>();
            int lvl = 1;
            Queue<Node> main = new LinkedList<>();
            Queue<Node> helper = new LinkedList<>();
            if (root != null)
                main.add(root);
            while (!main.isEmpty()) {
                if (lvl % 2 == 0) {


                    while (!main.isEmpty()) {
                        Node curr = main.poll();
                        al.add(curr.data);
                        if (curr.left != null)
                            helper.add(curr.left);
                        if (curr.right != null)
                            helper.add(curr.right);

                    }
                    // System.out.print(lvl+"c"+ 2%2 +" ");
                    lvl++;
                    // al.add(20);
                    main = helper;
                    helper = new LinkedList<>();

                } else {
                    Stack<Node> st = new Stack<>();
                    while (!main.isEmpty()) {
                        Node curr = main.poll();
                        st.push(curr);
                        if (curr.left != null)
                            helper.add(curr.left);
                        if (curr.right != null)
                            helper.add(curr.right);
                    }
                    while (!st.isEmpty()) {
                        al.add(st.pop().data);
                    }
                    lvl++;


                    main = helper;
                    // System.out.print( main);
                    helper = new LinkedList<>();
                }
                // Node curr = q.poll();
                // al.add(curr.data);
            }


            return al;
        }

    }
}

/*
ArrayList<Integer> findSpiral(Node root)
   {
       Queue<Node> q = new LinkedList<>();
       ArrayList<Integer> al = new ArrayList<>();
       Stack<Integer> st = new Stack<>();

       if(root == null)
           return al;

       q.add(root);
       int size = 0;
       int count = 0;

       while(!q.isEmpty()) {
           size = q.size();
           count++;

           for(int i=0;i<size;i++) {

               Node temp = q.poll();
               st.push(temp.data);

               if(temp.left != null)
                   q.add(temp.left);

               if(temp.right != null)
                   q.add(temp.right);

           }

           if(count % 2 != 0) {
               while(!st.isEmpty())
                   al.add(st.pop());
           }

           else {
               for(Integer a:st)
                   al.add(a);

               st.clear();
           }
       }

       return al;


   }
 */
