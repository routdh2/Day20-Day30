package coding_interview;
import java.util.*;
public class PostOrderTraversal {
	
	public static List<Integer> postOrderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		if(root==null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			result.add(0,temp.val);
			if(temp.left!=null)
				stack.push(temp.left);
			if(temp.right!=null)
				stack.push(temp.right);
		}
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = BFSTreeTraversal.createTree();
		List<Integer> result = postOrderTraversal(root);

	}

}
