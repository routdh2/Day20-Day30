package coding_interview;
import java.util.*;

public class ZigzagLevelOrderTraversal {
	
	public static void zigzagLevelOrderTraversal(TreeNode root) {
		if(root==null)
			return;
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean leftToRight=true;
		while(!queue.isEmpty()) {
			int size=queue.size();
			LinkedList<Integer> list = new LinkedList<>();
			for(int i=0;i<size;i++) {
				TreeNode temp = queue.poll();
				if(!leftToRight)
					list.add(0,temp.val);
				else
					list.add(temp.val);
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			result.add(list);
			leftToRight=!leftToRight;
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		TreeNode root = BFSTreeTraversal.createTree();
		zigzagLevelOrderTraversal(root);

	}

}
