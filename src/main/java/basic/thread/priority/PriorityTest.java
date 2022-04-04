package basic.thread.priority;

public class PriorityTest {

	public static void main(String[] args) {
		int priority = 0;

		for (priority = Thread.MIN_PRIORITY; priority <= Thread.MAX_PRIORITY; priority++) {
			PriorityThread pt = new PriorityThread();
			pt.setPriority(priority);
			pt.start();
		}
	}
}
