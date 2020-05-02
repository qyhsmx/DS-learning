package com.company.binaryTree;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class CommonAncestor {
    private static Node ca4bst(Node root,Node p,Node q){
        while (root!=null){
            if(root.val>p.val && root.val>q.val)
                root = root.left;
            else if(root.val<p.val && root.val<q.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }

    private static Node ca4bst2(Node root,Node p,Node q){
        if(root.val>p.val && root.val>q.val)
            return ca4bst2(root.left,p,q);
        if(root.val<p.val && root.val<q.val)
            return ca4bst2(root.right,p,q);
        return root;
    }

    private static Node ca4tree(Node root,Node p,Node q){
        if(root==null || root==p || root==q)return root;
        Node left = ca4tree(root.left,p,q);
        Node right = ca4tree(root.right,p,q);
        return left==null?right:right==null?left:root;

    }
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
