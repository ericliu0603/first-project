package hw5;

/* Set.java */

/**
 * A Set is a collection of Comparable elements stored in sorted order.
 * Duplicate elements are not permitted in a Set.
 **/
public class Set {
	/* Fill in the data fields here. */
	private List list;

	/**
	 * Set ADT invariants: 1) The Set's elements must be precisely the elements
	 * of the List. 2) The List must always contain Comparable elements, and
	 * those elements must always be sorted in ascending order. 3) No two
	 * elements in the List may be equal according to compareTo().
	 **/

	/**
	 * Constructs an empty Set.
	 *
	 * Performance: runs in O(1) time.
	 **/
	public Set() {
		list = new DList();
	}

	/**
	 * cardinality() returns the number of elements in this Set.
	 *
	 * Performance: runs in O(1) time.
	 **/
	public int cardinality() {
		return list.length();
	}

	/**
	 * insert() inserts a Comparable element into this Set.
	 *
	 * Sets are maintained in sorted order. The ordering is specified by the
	 * compareTo() method of the java.lang.Comparable interface.
	 *
	 * Performance: runs in O(this.cardinality()) time.
	 **/
	public void insert(Comparable c) {
		if (list.isEmpty()) {
			list.insertFront(c);
			return;
		}
		ListNode cur = list.front();

		while (true) {
			if (c.compareTo(cur.item) == 0) {
				return;
			} else if (c.compareTo(cur.item) > 0) {
				try {
					cur = cur.next();
				} catch (InvalidNodeException e) {
					break;
				}
			} else {
				try {
					cur.insertBefore(c);
				} catch (InvalidNodeException e1) {
					e1.printStackTrace();
				}
				return;
			}
		}
		list.insertBack(c);
		// ListNode next = null;
		// try {
		// next = cur.next();
		// if (!next.item().equals(c)) {
		// cur.insertAfter(c);
		// }
		// } catch (InvalidNodeException e) {
		// try {
		// cur.insertAfter(c);
		// } catch (InvalidNodeException e1) {
		// e1.printStackTrace();
		// }
		// }

	}

	/**
	 * union() modifies this Set so that it contains all the elements it started
	 * with, plus all the elements of s. The Set s is NOT modified. Make sure
	 * that duplicate elements are not created.
	 *
	 * Performance: Must run in O(this.cardinality() + s.cardinality()) time.
	 *
	 * Your implementation should NOT copy elements of s or "this", though it
	 * will copy _references_ to the elements of s. Your implementation will
	 * create new _nodes_ for the elements of s that are added to "this", but
	 * you should reuse the nodes that are already part of "this".
	 *
	 * DO NOT MODIFY THE SET s. DO NOT ATTEMPT TO COPY ELEMENTS; just copy
	 * _references_ to them.
	 **/
	public void union(Set s) {
		ListNode thisNode = list.front();
		ListNode thatNode = s.list.front();
		while (true) {
			if (thisNode.isValidNode() && thatNode.isValidNode()) {
				try {
					if (thisNode.item().equals(thatNode.item())) {
						thisNode = thisNode.next();
						thatNode = thatNode.next();
					} else if (((Comparable) thisNode.item())
							.compareTo(thatNode.item()) < 0) {
						thisNode = thisNode.next();
					} else {
						thisNode.insertAfter(thatNode.item());
						thatNode = thatNode.next();
					}
				} catch (InvalidNodeException e) {
					e.printStackTrace();
					return;
				}
			} else {
				break;
			}
		}
		thisNode = list.back();
		while (thatNode != null) {
			try {
				thisNode.insertAfter(thatNode.item());
				thatNode = thatNode.next();
			} catch (InvalidNodeException e) {
				return;
			}
		}
	}

	/**
	 * intersect() modifies this Set so that it contains the intersection of its
	 * own elements and the elements of s. The Set s is NOT modified.
	 *
	 * Performance: Must run in O(this.cardinality() + s.cardinality()) time.
	 *
	 * Do not construct any new ListNodes during the execution of intersect.
	 * Reuse the nodes of "this" that will be in the intersection.
	 *
	 * DO NOT MODIFY THE SET s. DO NOT CONSTRUCT ANY NEW NODES. DO NOT ATTEMPT
	 * TO COPY ELEMENTS.
	 **/
	public void intersect(Set s) {
		ListNode thisNode = list.front();
		ListNode thatNode = s.list.front();
		while (true) {
			if (thisNode.isValidNode()) {
				ListNode tmp = null;
				try {
					if (thatNode != null) {
						if (thisNode.item().equals(thatNode.item())) {
							thisNode = thisNode.next();
							thatNode = thatNode.next();
						} else if (((Comparable) thisNode.item())
								.compareTo(thatNode.item()) < 0) {
							tmp = thisNode.next();
							thisNode.remove();
							thisNode = tmp;
						} else {
							thatNode = thatNode.next();
						}

					} else {
						tmp = thisNode.next();
						thisNode.remove();
						thisNode = tmp;
					}
				} catch (InvalidNodeException e) {
					System.err.println(e);
					System.exit(0);
				}
			} else {
				break;
			}
		}
	}

	/**
	 * toString() returns a String representation of this Set. The String must
	 * have the following format: { } for an empty Set. No spaces before "{" or
	 * after "}"; two spaces between them. { 1 2 3 } for a Set of three Integer
	 * elements. No spaces before "{" or after "}"; two spaces before and after
	 * each element. Elements are printed with their own toString method,
	 * whatever that may be. The elements must appear in sorted order, from
	 * lowest to highest according to the compareTo() method.
	 *
	 * WARNING: THE AUTOGRADER EXPECTS YOU TO PRINT SETS IN _EXACTLY_ THIS
	 * FORMAT, RIGHT UP TO THE TWO SPACES BETWEEN ELEMENTS. ANY DEVIATIONS WILL
	 * LOSE POINTS.
	 **/
	@Override
	public String toString() {
		if (list.isEmpty()) {
			return "{}";
		}
		ListNode cur = list.front();
		String result = "{";
		while (cur.isValidNode() && cur != null) {
			try {
				result = result + " " + cur.item() + " ";
				cur = cur.next();
			} catch (InvalidNodeException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
		result = result + "}";
		return result;
	}

	public static void main(String[] argv) {
		System.out.println("test1");
		Set s = new Set();
		s.insert(new Integer(3));
		s.insert(new Integer(4));
		s.insert(new Integer(3));
		System.out.println("Set s = " + s);

		System.out.println("test2");
		Set s2 = new Set();
		s2.insert(new Integer(4));
		s2.insert(new Integer(5));
		s2.insert(new Integer(5));
		System.out.println("Set s2 = " + s2);

		System.out.println("test3");
		Set s3 = new Set();
		s3.insert(new Integer(5));
		s3.insert(new Integer(3));
		s3.insert(new Integer(8));
		System.out.println("Set s3 = " + s3);

		s.union(s2);
		System.out.println("After s.union(s2), s = " + s);

		s.intersect(s3);
		System.out.println("After s.intersect(s3), s = " + s);

		System.out.println("s.cardinality() = " + s.cardinality());
		// You may want to add more (ungraded) test code here.
	}
}
