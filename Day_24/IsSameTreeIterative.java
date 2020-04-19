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
        Queue<TreeNode> pq = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        pq.add(p);
        qq.add(q);
        while(!pq.isEmpty() || !qq.isEmpty()) {
            p=pq.poll();
            q=qq.poll();
            if(p==null && q==null)
                continue;
            else if(p==null || q==null)
                return false;
            if(p.val!=q.val)
                return false;
            pq.add(p.left);
            pq.add(p.right);
            qq.add(q.left);
            qq.add(q.right);
        }
        if(!pq.isEmpty() || !qq.isEmpty())
            return false;
        return true;
        
    }
}
