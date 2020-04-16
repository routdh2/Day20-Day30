package coding_interview;
import java.util.*;
public class SubarraysWithProductLessThanTarget {
	
	public static void subarraysLessThanTarget(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<>();
		for(int start=0;start<arr.length;start++) {
			int product=1;
			List<Integer> list = new ArrayList<>();
			for(int end=start;end<arr.length;end++) {
				list.add(arr[end]);
				product=product*arr[end];
				if(product<target) {
					result.add(new ArrayList<>(list));
				}
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		subarraysLessThanTarget(new int[] {2,5,3,10}, 30);//[[2], [2, 5], [5], [5, 3], [3], [10]]
		subarraysLessThanTarget(new int[] {8,2,6,5}, 50);//[[8], [8, 2], [2], [2, 6], [6], [6, 5], [5]]

	}

}
