package basic.thread.multi;

public enum ActionType {
	SAVE(1),
	WITHDRAW(2);

	private final int value;

	ActionType(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
