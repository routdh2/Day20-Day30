package cracking_the_coding_interview;

import java.util.Arrays;

public class IsPermutation {
	//TC: O(n) SC: O(1)
	public static boolean isPermutation(String s1, String s2) {
		//check if the char set is ASCII or Unicode
		//we assume the char set is ASCII of size 128
		//Check if the chars are case sensitive or not
		//also check if we whitespaces matter
		//we assume chars are case sensitive and whitespaces do matter
		if(s1==null || s2==null)
			throw new IllegalArgumentException();
		if(s1.length()!=s2.length())
			return false;
		int[] arr = new int[128];
		for(int i=0;i<s1.length();i++) {
			char c = s1.charAt(i);
			arr[c]++;
		}
		for(int i=0;i<s2.length();i++) {
			char c = s2.charAt(i);
			arr[c]--;
			if(arr[c]<0)
				return false;
		}
		return true;
	}
	//TC: O(nlogn) SC: O(n)
	public static boolean isPermutationUsingSorting(String s1, String s2) {
		//check if they are case sensitive and do whitespaces matter
		if(s1==null || s2==null)
			throw new IllegalArgumentException();
		if(s1.length()!=s2.length())
			return false;
		char[] arr1=s1.toCharArray();
		char[] arr2=s2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return new String(arr1).equals(new String(arr2));
	}

	public static void main(String[] args) {
		System.out.println(isPermutation("dhananjay","hdjayanna"));
		System.out.println(isPermutation("abcddd", "djjdhh"));
		
		System.out.println(isPermutationUsingSorting("dhananjay","hdjayanna"));
		System.out.println(isPermutationUsingSorting("abcddd", "djjdhh"));

	}

}
