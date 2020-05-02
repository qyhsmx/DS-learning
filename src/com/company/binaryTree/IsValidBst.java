package com.company.binaryTree;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class IsValidBst {


    public static void main(String[] args) {
        Node node1 = new Node(5,null,null);
        Node node2 = new Node(5,null,null);
        Node node = new Node(4,node1,node2);

        System.out.println(valid(node,null,null));
    }

    private static boolean valid(Node root,Integer min,Integer max){
        if(root==null)return true;
        if(min!=null && root.val<=min)return false;
        if(max!=null && root.val>=max)return false;
        return valid(root.left, min, root.val)
                && valid(root.right,root.val,max);

    }
//    private static boolean method(Node root){
//        if(root==null)return true;
//
//    }
//    private static int helper(Node root){
//
//    }

    private static class Node{
        int val;
        Node left;
        Node right;

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

