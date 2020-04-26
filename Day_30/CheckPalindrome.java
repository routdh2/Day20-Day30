package cracking_the_coding_interview;
import java.util.*;
class Node {
	int val;
	Node next;
	public Node(int _val) {
		val=_val;
		next=null;
	}
}
//Program to check if a linked list is palindrome or not
//TC: O(n) SC: O(n) where n is no of elements in linked list
public class CheckPalindrome {
	
	public static boolean isPalindrome(Node head) {
		if(head==null || head.next==null)
			return true;
		//reverse the linked list and check for first half
		LinkedList<Integer> temp = new LinkedList<Integer>();
		Node ptr=head;
		while(ptr!=null) {
			temp.add(0,ptr.val);
			ptr=ptr.next;
		}
		ptr=head;
		for(int i=0;i<temp.size()/2;i++) {
			if(temp.get(i)!=ptr.val)
				return false;
			ptr=ptr.next;
		}
		return true;
	}
	
	public static Node createList() {
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(2);
		head.next.next.next.next=new Node(4);
		return head;
	}

	public static void main(String[] args) {
		Node head=createList();
		System.out.println(isPalindrome(head));

	}

}
