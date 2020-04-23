package coding_interview;
import java.util.*;
public class InOrderTraversal {
	
	public static List<Integer> inOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root==null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		while(root!=null || !stack.isEmpty()) {
			while(root!=null) {
				stack.push(root);
				root=root.left;
			}
			root=stack.pop();
			result.add(root.val);
			root=root.right;
		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = BFSTreeTraversal.createTree();
		List<Integer> result = inOrderTraversal(root);

	}

}
