package basic.thread;

public class MyThread extends Thread {

	public void run() {

		/* start메소드에서 호출된다. */
		int i = 0;
		for (i = 0; i < 10; i++) {
			System.out.println("[" + super.getName() + "]" +
				"num : " + i + "\t");
		}

		Thread.yield();
	}
}
