package coding_interview2;

import java.util.*;
class GraphNode {
	int val;
	List<GraphNode> neighbors;
	
	public GraphNode() {
		val=0;
		neighbors=new ArrayList<>();
	}
	
	public GraphNode(int _val) {
		val=_val;
		neighbors=new ArrayList<>();
	}
	
	public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
		val=_val;
		neighbors=_neighbors;
	}
}

public class GraphDemo3 {
	
	public static GraphNode createGraph() {
		GraphNode start = new GraphNode(0);
		GraphNode one=new GraphNode(1);
		GraphNode two = new GraphNode(2);
		GraphNode three = new GraphNode(3);
		GraphNode four = new GraphNode(4);
		start.neighbors.addAll(Arrays.asList(one, four));
		one.neighbors.addAll(Arrays.asList(start,two,three,four));
		two.neighbors.addAll(Arrays.asList(one,three));
		three.neighbors.addAll(Arrays.asList(two,one,four));
		four.neighbors.addAll(Arrays.asList(start,one,three));
		return start;
	}
	
	public static List<Integer> BFSTraversal(GraphNode start) {
		List<Integer> result = new ArrayList<>();
		if(start==null)
			return result;
		Queue<GraphNode> queue = new LinkedList<>();
		HashSet<GraphNode> visited = new HashSet<>();
		queue.add(start);
		while(!queue.isEmpty()) {
			GraphNode temp = queue.poll();
			if(!visited.contains(temp)) {
				result.add(temp.val);
				visited.add(temp);
			}
			for(int i=0;i<temp.neighbors.size();i++) {
				GraphNode key = temp.neighbors.get(i);
				if(!visited.contains(key)) {
					queue.add(key);
				}
			}
		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		GraphNode start = createGraph();
		//traversal
		List<Integer> result = BFSTraversal(start);

	}

}
