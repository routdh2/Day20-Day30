package coding_interview;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
	
	public static int findMaxDepthOfBinaryTree(TreeNode root) {
		if(root==null)
			return 0;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count=1;
		int max_count=Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
			int size=queue.size();
			
			for(int i=0;i<size;i++) {
				TreeNode temp = queue.poll();
				if(temp.left==null && temp.right==null)
					max_count=Math.max(max_count, count);
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			count++;
		}
		return max_count;
	}

	public static void main(String[] args) {
		TreeNode root = BFSTreeTraversal.createTree();
		System.out.println(findMaxDepthOfBinaryTree(root));

	}

}
