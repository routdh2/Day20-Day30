package coding_interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindLargestAteachLevel {
	
	public static void findLargestAtEachLevel(TreeNode root) {
		if(root==null)
			return;
		ArrayList<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			int level_max=Integer.MIN_VALUE;
			for(int i=0;i<size;i++) {
				TreeNode temp = queue.poll();
				level_max=Math.max(level_max, temp.val);
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			result.add(level_max);
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		TreeNode root = BFSTreeTraversal.createTree();
		findLargestAtEachLevel(root);
	}

}
