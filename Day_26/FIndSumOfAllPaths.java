package coding_interview;

public class FindSumOfAllPaths {
	
	public static int findSumOfPaths(TreeNode root) {
		return findSum(root,0);
	}
	private static int findSum(TreeNode currentNode, int pathSum) {
		if(currentNode==null)
			return 0;
		pathSum=pathSum*10+currentNode.val;
		if(currentNode.left==null && currentNode.right==null)
			return pathSum;
		return findSum(currentNode.left,pathSum)+findSum(currentNode.right,pathSum);
	}

	public static void main(String[] args) {
		TreeNode root=BFSTreeTraversal.createTree();
		System.out.println(findSumOfPaths(root));

	}

}
