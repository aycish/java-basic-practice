package basic.thread.multi;

public class Person extends Thread {

	private String name;
	private ActionType actionType;

	public ActionType getActionType() {
		return actionType;
	}

	public Person(String name, ActionType actionType) {
		setName(name);
		this.actionType = actionType;
	}

	public void run() {

		if (getActionType() == ActionType.SAVE) {
			System.out.println("[ " + getName() + " ] starts saving... ");
			SyncMain.saveDeposit(3000);
			System.out.println("[ " + getName() + " ] try to save 3000.");
			System.out.println("[ " + getName() + " ] result : " + SyncMain.getDeposit());
		} else if (getActionType() == ActionType.WITHDRAW) {
			System.out.println("[ " + getName() + " ] starts withdrawing... ");
			SyncMain.withdrawDeposit(3000);
			System.out.println("[ " + getName() + " ] try to withdraw 3000.");
			System.out.println("[ " + getName() + " ] result : " + SyncMain.getDeposit());
		}
	}
}
