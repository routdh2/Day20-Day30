package coding_interview;

import java.util.HashSet;

public class HappyNumber {
	
	public static boolean isHappyNumber(int num) {
		HashSet<Integer> set = new HashSet<>();
		if(num==1)
			return true;
		set.add(num);
		while(num!=1) {
			 num = findSquareOfDigits(num);
			 if(set.contains(num))
				 return false;
			 else
				 set.add(num);
		}
		return true;
	}
	
	private static int findSquareOfDigits(int num) {
		int sum=0;
		while(num>0) {
			int rem=num%10;
			sum+=(rem*rem);
			num=num/10;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(isHappyNumber(12));
		System.out.println(isHappyNumber(23));

	}

}
