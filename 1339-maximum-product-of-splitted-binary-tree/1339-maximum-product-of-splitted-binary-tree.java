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

    long total = 0;
    long ans = 0;
    int MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        total = sum(root);   // total sum of tree
        dfs(root);           // find max product
        return (int)(ans % MOD);
    }

    // find total sum
    long sum(TreeNode node) {
        if (node == null) return 0;
        return node.val + sum(node.left) + sum(node.right);
    }

    // find subtree sums and product
    long dfs(TreeNode node) {
        if (node == null) return 0;

        long s = node.val + dfs(node.left) + dfs(node.right);

        ans = Math.max(ans, s * (total - s));

        return s;
    }
}
