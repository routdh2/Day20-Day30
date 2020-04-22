package coding_interview;

public class HasPathWIthGivenSeq {
	
	public static boolean hasPathWithSeq(TreeNode root, int[] seq) {
		if(root==null)
			return seq.length==0;
		return hasPathRec(root,seq,0);
	}
	
	private static boolean hasPathRec(TreeNode currentNode, int[] seq, int index) {
		if(currentNode==null)
			return false;
		if(currentNode.val!=seq[index] || index>=seq.length)
			return false;
		if(currentNode.left==null && currentNode.right==null && index==seq.length-1)
			return true;
		return hasPathRec(currentNode.left,seq,index+1) || hasPathRec(currentNode.right,seq,index+1);
	}

	public static void main(String[] args) {
		TreeNode root = BFSTreeTraversal.createTree();
		System.out.println(hasPathWithSeq(root,new int[] {1,2,6}));

	}

}
