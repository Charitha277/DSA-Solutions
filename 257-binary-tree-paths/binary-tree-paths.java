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
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        
        go(root,"");
        return ans;
    }
    void go(TreeNode node,String s){
        if(node == null) return ;
        s = s + node.val;
        if(node.left == null && node.right == null){
            ans.add(s);
            return ;
        }
        go(node.left, s + "->");
        go(node.right,s+"->");
    }
}