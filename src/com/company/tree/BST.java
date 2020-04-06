package com.company.tree;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class BST {
    public static void main(String[] args) {

    }
    public static class Node{
        int val;
        Node left;
        Node right;
    }
    private Node root;
    private Node delete(Node node,int target){

        if(node.val==target && node.left==null && node.right==null){

            return node;
        }

        return null;
    }
    private int deepth(Node node){
        if(node==null){
            return 0;
        }
        int val_l = deepth(node.left);
        int val_r = deepth(node.right);
        return Integer.max(val_r, val_l);
    }
    private void insert(BST tree,int val){
        Node root = tree.root;
        Node node = new Node();
        node.val=val;
        node.left=null;
        node.right=null;
        if(root==null){
            root = node;
            return;
        }
        Node temp = root;
        while (true){
            if(val>temp.val){
                if(temp.left==null){
                    temp.left=node;
                    return;
                }
                else {
                    temp = temp.left;
                }
            }
            else {
                if(temp.right==null){
                    temp.right=node;
                    return;
                }
                else {
                    temp = temp.right;
                }
            }
        }
    }
    private void preOrder(Node node){
        if(node!=null){
            System.out.print(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    private void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            System.out.print(node.val);
            inOrder(node.right);
        }
    }
    private void subOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            inOrder(node.right);
            System.out.print(node.val);
        }
    }
}
