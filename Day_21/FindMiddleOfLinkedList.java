package coding_interview;


public class FindMiddleOfLinkedList {
	
	public static ListNode findMiddle(ListNode head) {
		if(head==null)
			throw new IllegalArgumentException();
		ListNode slow=head,fast=head;
		while(fast!=null) {
			fast=fast.next;
			if(fast==null)
				return slow;
			if(fast!=null)
				fast=fast.next;
			slow=slow.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode first = new ListNode(2);
		head.next=first;
		ListNode second = new ListNode(3);
		first.next = second;
		ListNode third = new ListNode(4);
		second.next=third;
		ListNode fourth = new ListNode(5);
		third.next=fourth;
//		ListNode fifth = new ListNode(6);
//		fourth.next=fifth;
		System.out.println(findMiddle(head));

	}

}
