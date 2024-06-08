package addList;

public class AddLists {
	
	
	public static void main(String[] args) {

		ListNode l1, l2 = new ListNode();
		int list1[] = {3,7};
		int list2[] = {9,2};

		ListNode printNodes = new ListNode();
		
		l1 = makeList(list1);
		l2 = makeList(list2);
		
		printNodes = addTwoNumbers (l1,l2);

		while (printNodes != null) {
			System.out.println(printNodes.val);
			printNodes = printNodes.next;
		}
		
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode();
		ListNode resultRoot = new ListNode(0);
		int carry = 0;
		
		
		result = resultRoot;
		
		while (l1!=null  || l2!=null) {
			//Create New node for this digit
			result.next = new ListNode();
			result = result.next;
			
			
			if (l1 == null) {
				result.val = (l2.val + carry) % 10;
				carry = (l2.val + carry) / 10;
				l2 = l2.next;
			} else if (l2 == null) {
				result.val = (l1.val + carry) % 10;
				carry = (l1.val + carry) / 10;
				l1 = l1.next;
			} else {
				//have numbers in each list, add them, and see if we need to cary a value to the next node
				result.val = (l1.val + l2.val + carry) % 10;
				carry = (l1.val + l2.val +carry) / 10;
				l1=l1.next;
				l2=l2.next;
		}			
		}
		
		//If we've looped through everything and still have a value to carry, we need on more node 
		//for it.
		if (carry > 0) {
			result.next = new ListNode(carry);
		}
		//The first entry in list, resultRoot, is a placeholder so send back the
		//2nd node of the list
        return resultRoot.next;
    }

	public static ListNode makeList (int numList[]) {
		ListNode rootNode, newNode, curNode = new ListNode();
		curNode = null;
		rootNode=null;
		
		for (int i=0; i < numList.length ; i++) {
			if (i==0) {
				rootNode = new ListNode(numList[i]);
				curNode = rootNode;
			} else{
				newNode = new ListNode(numList[i]);
				curNode.next = newNode;
				curNode = newNode;
			}		
		}
		return rootNode;
		
	}
}
