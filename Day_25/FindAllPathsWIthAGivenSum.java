package coding_interview;
import java.util.*;
public class FIndAllPathsOfAGivenSum {
	
	public static List<List<Integer>> findAllPaths(TreeNode root,int sum) {
		if(root==null)
			return null;
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		findPaths(root,path,result,sum);
		return result;
	}
	
	public static void findPaths(TreeNode root,List<Integer> path, List<List<Integer>> result, int sum) {
		if(root==null) {
			return;
		}
		path.add(root.val);
		if(root.left==null && root.right==null && root.val==sum)
			result.add(new ArrayList<Integer>(path));
		else {
			findPaths(root.left,path,result,sum-root.val);
			findPaths(root.right,path,result,sum-root.val);
		}
		path.remove(path.size()-1);
	}

	public static void main(String[] args) {
		TreeNode root = BFSTreeTraversal.createTree();
		System.out.println(findAllPaths(root, 7));

	}

}
