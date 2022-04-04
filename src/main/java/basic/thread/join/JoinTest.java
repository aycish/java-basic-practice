package basic.thread.join;

public class JoinTest extends Thread {

	int start;
	int end;
	int total;

	public JoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public void run() {
		int num;
		for (num = start; num <= end; num++) {
			total += num;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread() + " : start");

		JoinTest jt1 = new JoinTest(1, 50);
		JoinTest jt2 = new JoinTest(51, 100);

		jt1.start();
		jt2.start();

		jt1.join();
		jt2.join();

		int returnTotal = jt1.total + jt2.total;

		System.out.println("jt1.total = " + jt1.total);
		System.out.println("jt2.total = " + jt2.total);

		System.out.println("returnTotal = " + returnTotal);
		System.out.println(Thread.currentThread() + " : end");
	}
}
