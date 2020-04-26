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
	//Using stack we store the first half of elements in stack
	//and then we compare the rest with each popping from stack
	//TC: O(n) SC:O(n) where n is no of elements in stack
	public static boolean isPalindromeUsingStack(Node head) {
		if(head==null || head.next==null)
			return true;
		Stack<Integer> stack = new Stack<>();
		Node slowPtr=head,fastPtr=head;
		boolean flag=false;
		while(fastPtr!=null) {
			fastPtr=fastPtr.next;
			if(fastPtr!=null)
				fastPtr=fastPtr.next;
			else {
				flag=true;
				break;
			}
			stack.push(slowPtr.val);
			slowPtr=slowPtr.next;
		}
		if(flag)
			slowPtr=slowPtr.next;
		while(slowPtr!=null) {
			if(stack.pop()!=slowPtr.val)
				return false;
			slowPtr=slowPtr.next;
		}
		return true;
	}
	
	public static Node createList() {
		Node head=new Node(1);
		head.next=new Node(3);
		head.next.next=new Node(3);
		head.next.next.next=new Node(3);
		head.next.next.next.next=new Node(2);
		head.next.next.next.next.next=new Node(1);
		return head;
	}

	public static void main(String[] args) {
		Node head=createList();
		System.out.println(isPalindromeUsingStack(head));

	}

}
