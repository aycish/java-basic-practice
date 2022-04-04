package basic.thread.priority;

public class PriorityThread extends Thread {

	public void run() {
		int sum = 0;

		Thread th = Thread.currentThread();
		System.out.println(th + ": start");

		for (int index = 0; index <= 1000000; index++) {
			sum += index;
		}

		System.out.println(th.getPriority() + ": end" );
	}
}
