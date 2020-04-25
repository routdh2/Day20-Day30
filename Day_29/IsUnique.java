package cracking_the_coding_interview;

import java.util.Arrays;

public class IsUnique {
	//TC: O(n) SC: O(1)
	public static boolean isUnique(String str) {
		//check error conditions
		//ask if String contains only ASCII chars or Unicode chars
		//We assume String contains only ASCII chars of 128 size
		//There is an extended ASCII format which contains 256 chars
		if(str==null)
			throw new IllegalArgumentException();
		if(str.length()>128)// if string size is more than 128, it definitely contains dups
			return false;
		boolean[] visited = new boolean[128];
		for(char c : str.toCharArray()) {
			if(visited[c])
				return false;
			else
				visited[c]=true;
		}
		return true;
	}
	
	//TC: O(nlogn) SC:O(n)(for sorting) doesn't use additional data structure
	public static boolean isUniqueUsingSorting(String str) {
		//we will assume the str contains ASCII char set of size 128
		if(str==null)
			throw new IllegalArgumentException();
		if(str.length()>128)
			return false;
		char[] arr = str.toCharArray();
		Arrays.sort(arr);// takes O(nlogn) time and may take O(n) space
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==arr[i-1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isUnique("dhananjay"));
		System.out.println(isUnique("abcdefgh"));
		
		System.out.println(isUniqueUsingSorting("dhananjay"));
		System.out.println(isUniqueUsingSorting("abcdefgh"));
	}

}
