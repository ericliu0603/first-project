package hw4;

public class LockDList extends DList {

	public void lockNode(DListNode node) {
		((LockDListNode) node).setLocked(true);
	}

	@Override
	protected DListNode newNode(Object item, DListNode prev, DListNode next) {
		return new LockDListNode(item, prev, next);
	}

	@Override
	public void remove(DListNode node) {
		if (node != null && ((LockDListNode) node).isLocked() == false) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			--size;
		}
	}

	public static void main(String args[]) {
		LockDList list = new LockDList();
		for (int i = 0; i < 10; ++i) {
			list.insertFront(i);
		}
		System.out.println(list + "; size: " + list.length());
		for (int i = 0; i < 10; ++i) {
			list.insertBack(i);
		}
		System.out.println(list + "; size: " + list.length());
		DListNode front = list.front();
		DListNode back = list.back();
		System.out.println(front.item);
		System.out.println(back.item);
		list.insertAfter(100, front);
		System.out.println(list + "; size: " + list.length());
		list.insertBefore(101, front);
		System.out.println(list + "; size: " + list.length());
		list.insertAfter(100, back);
		System.out.println(list + "; size: " + list.length());
		list.insertBefore(101, back);
		System.out.println(list + "; size: " + list.length());
		System.out.println(list.next(front).item);
		System.out.println(list.prev(front).item);
		list.remove(front);
		System.out.println(list + "; size: " + list.length());
		front = list.front();
		System.out.println(front.item);
		list.lockNode(front);
		list.remove(front);
		System.out.println(list + "; size: " + list.length());
	}
}
