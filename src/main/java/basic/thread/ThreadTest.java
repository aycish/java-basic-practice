package basic.thread;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {

		/* 메인 스레드 제어를 아름답게 하는 방법을 찾아보자 ,,
		* 현 방법의 경우, 종료되는 상태를 직접적으로 check하게 되는데,
		* 만약 생성하는 스레드의 priority가 변경되어 main thread의 우선순위가 변경되면 원하는 방식대로 동작하지 않음
		*/

		int i = 1;
		System.out.println("[INFO] class which extends Thread start  ----------------------");

		runThread();
		System.out.println("[INFO] class which extends Thread finish ----------------------");

		System.out.println("[INFO] class which implements Runnable start  ----------------------");
		runRunnableThread();

		System.out.println("[INFO] class which implements Runnable finish ----------------------");
	}

	static private void runThread () {
		MyThread th1 = new MyThread();
		MyThread th2 = new MyThread();

		th1.setName("th1");
		th2.setName("th2");

		th1.start();
		th2.start();

		while(th1.getState() != Thread.State.TERMINATED && th2.getState() != Thread.State.TERMINATED);
	}

	static private void runRunnableThread() {
		MyThreadRunnable myThreadRunnable = new MyThreadRunnable();

		Thread th1 = new Thread(myThreadRunnable);
		Thread th2 = new Thread(myThreadRunnable);

		th1.setName("Runnable - 1");
		th2.setName("Runnable - 2");

		th1.start();
		th2.start();

		while(th1.getState() != Thread.State.TERMINATED && th2.getState() != Thread.State.TERMINATED);
	}
}
