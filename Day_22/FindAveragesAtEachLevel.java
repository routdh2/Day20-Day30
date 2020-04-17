package coding_interview;
import java.util.*;
public class LevelAveragesInBinaryTree {
	
	public static void findAveragesAtEachLevel(TreeNode root) {
		if(root==null)
			return;
		ArrayList<Double> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			double sum=0;
			for(int i=0;i<size;i++) {
				TreeNode temp = queue.poll();
				sum+=temp.val;
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			result.add(sum/size);
		}
		System.out.println(result);
		
	}

	public static void main(String[] args) {
		TreeNode root = BFSTreeTraversal.createTree();
		findAveragesAtEachLevel(root);

	}

}
