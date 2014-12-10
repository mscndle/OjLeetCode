// Write a program to find the node at which the intersection of two singly linked lists begins.


// For example, the following two linked lists:

// A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗            
// B:     b1 → b2 → b3
// begin to intersect at node c1.


// Notes:

// If the two linked lists have no intersection at all, return null.
// The linked lists must retain their original structure after the function returns.
// You may assume there are no cycles anywhere in the entire linked structure.
// Your code should preferably run in O(n) time and use only O(1) memory.


class ListsIntersection {

	static class ListNode {
    	int val;
      	ListNode next;
      	
      	ListNode(int val) {
        	this.val = val;
         	this.next = null;
      	}
  	}

  	public static void main(String[] args) {
  		ListNode headA = new ListNode(1);
  		ListNode _2 = new ListNode(2);
  		ListNode _3 = new ListNode(3);
  		ListNode _4 = new ListNode(4);
  		ListNode _5 = new ListNode(5);
  		headA.next = _2;
  		_2.next = _3;
  		_3.next = _4;
  		_4.next = _5;

  		ListNode headB = new ListNode(6);
  		ListNode _7 = new ListNode(7);
  		ListNode _8 = new ListNode(8);
  		headB.next = _7;
  		_7.next = _8;
  		_8.next = _3;

  		ListNode res = getIntersectionNode(headA, headB);
  		if (res == null) {
  			System.out.println("null");
  		} else {
  			System.out.println(res.val);	
  		}


  	}

  	static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        int k = 0;

        // increment both till at least one reaches null
        // Then calculate number of nodes left for the other to reach null = k
        // In the 2nd run, start off the 2nd node k nodes later, and increment both nodes
        // Return the node when they meet, else return null
        while (tempA != null && tempB != null) {
        	tempA = tempA.next;
        	tempB = tempB.next;
        }

        if (tempA == null) {
        	while (tempB != null) {
        		k++;
        		tempB = tempB.next;
        	}

        	tempA = headA;
        	tempB = headB;
        	while (k > 0) {
        		tempB = tempB.next;
        		k--;
        	}

        } else if (tempB == null) {
        	while (tempA != null) {
        		k++;
        		tempA = tempA.next;
        	}

        	tempA = headA;
        	tempB = headB;
        	while (k > 0) {
        		tempA = tempA.next;
        		k--;
        	}
        }

        while (tempA != null && tempB != null) {
        	if (tempA == tempB) {
        		return tempA;
        	}
        	tempA = tempA.next;
        	tempB = tempB.next;
        }	

        return null;
    }


}