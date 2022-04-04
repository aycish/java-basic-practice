package basic.thread.multi;

public class SyncMain {

	public static Bank myBank = new Bank();

	public static int getDeposit() {
		return myBank.getMoney();
	}

	public static void saveDeposit(int amount) {
		myBank.saveMoney(amount);
	}

	public static void withdrawDeposit(int amount) {
		myBank.withdrawMoney(amount);
	}

	public static void main(String[] args) {
		Person park = new Person("Park", ActionType.SAVE);
		Person kim = new Person("Kim", ActionType.WITHDRAW);

		park.start();

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		kim.start();
	}
}
