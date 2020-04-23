package coding_interview2;
import java.util.*;
public class DFSTraversal {
	
	public static List<Integer> DFSTraversal(GraphNode start) {
		List<Integer> result = new ArrayList<>();
		if(start==null)
			return result;
		Stack<GraphNode> stack = new Stack<>();
		HashSet<GraphNode> visited = new HashSet<>();
		stack.push(start);
		while(!stack.isEmpty()) {
			GraphNode temp = stack.pop();
			if(!visited.contains(temp)) {
				result.add(temp.val);
				visited.add(temp);
			}
			for(int i=0;i<temp.neighbors.size();i++) {
				GraphNode key=temp.neighbors.get(i);
				if(!visited.contains(key)) {
					stack.push(key);
				}
			}
		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		GraphNode start = GraphDemo3.createGraph();
		//traversal
		List<Integer> result = DFSTraversal(start);

	}

}
