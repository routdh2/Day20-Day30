package coding_interview;

import java.util.*;
public class PreOrderTraversal {
	
	public static List<Integer> preOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root==null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			result.add(temp.val);
			if(temp.right!=null)
				stack.push(temp.right);
			if(temp.left!=null)
				stack.push(temp.left);
		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = BFSTreeTraversal.createTree();
		List<Integer> result = preOrderTraversal(root);

	}

}
