package hw4;

public class LockDListNode extends DListNode {
	private boolean isLocked;

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public LockDListNode(Object i, DListNode p, DListNode n, boolean isLocked) {
		super(i, p, n);
		this.isLocked = isLocked;
	}

	public LockDListNode(Object i, DListNode p, DListNode n) {
		super(i, p, n);
		isLocked = false;
	}

}
