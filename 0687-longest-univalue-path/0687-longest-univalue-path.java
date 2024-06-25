/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxP =0;
    public int longestUnivaluePath(TreeNode root) {
          postOrder(root);
          return maxP;
    }
    int postOrder(TreeNode node){
        if(node==null) return 0;
        int left = postOrder(node.left);
        int right = postOrder(node.right);

        int LeftP=0;
        int rightp=0;

        if(node.left!=null && node.val==node.left.val){
            LeftP =left+1;
        } 
        if(node.right!=null && node.val==node.right.val){
            rightp =right+1;
        }
        maxP = Math.max(maxP,LeftP+rightp);
        return Math.max(LeftP,rightp); 
    }
}