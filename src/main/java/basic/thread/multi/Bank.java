package basic.thread.multi;

public class Bank {

	private int money = 10000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int amount) {
		this.money = amount;
	}

	/* synchronized 키워드를 사용하여 critical section에서의 동기화 문제 해결 */
	public synchronized void withdrawMoney(int withdrawAmount) {
		int deposit = this.getMoney();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		setMoney(deposit - withdrawAmount);
	}

	/* synchronized 키워드를 사용하여 critical section에서의 동기화 문제 해결 */
	public synchronized void saveMoney(int saveAmount) {

		int deposit = this.getMoney();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		setMoney(deposit + saveAmount);
	}
}
