package coding_interview;
import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val=val;
		this.left=null;
		this.right=null;
	}
}
public class BFSTreeTraversal {
	
	public static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		root.left=two;
		root.right=three;
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		two.left=four;
		two.right=five;
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		three.left=six;
		three.right=seven;
		return root;
	}
	public static void BFStraversal(TreeNode root) {
		if(root==null)
			return;
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size=queue.size();//tricky part
			ArrayList<Integer> level_items = new ArrayList<>();
			for(int i=0;i<size;i++) {
				
				TreeNode temp = queue.poll();
				level_items.add(temp.val);
				//process the polled item
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			result.add(new ArrayList<>(level_items));
			
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		TreeNode root = createTree();
		BFStraversal(root);
		

	}

}
