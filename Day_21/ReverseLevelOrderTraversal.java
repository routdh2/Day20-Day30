package coding_interview;
import java.util.*;

public class ReverseLevelOrderTraversal {
	
	public static void reverseBFStraversal(TreeNode root) {
		if(root==null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new LinkedList<List<Integer>>();//tricky part
		queue.add(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=0;i<size;i++) {
				TreeNode temp = queue.poll();
				list.add(temp.val);
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			result.add(0,list);
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		TreeNode root = BFSTreeTraversal.createTree();
		reverseBFStraversal(root);

	}

}
