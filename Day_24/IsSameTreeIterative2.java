/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Problem Statment: https://leetcode.com/problems/same-tree
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        else if(p==null || q==null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()) {
            p=queue.poll();
            q=queue.poll();
            if(p==null && q==null)
                continue;
            else if(p==null || q==null)
                return false;
            if(p.val!=q.val)
                return false;
            queue.add(p.left);
            queue.add(q.left);
            queue.add(p.right);
            queue.add(q.right);
        }
        return true;
        
    }
}
