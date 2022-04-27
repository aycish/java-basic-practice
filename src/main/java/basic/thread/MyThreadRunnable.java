package basic.thread;

public class MyThreadRunnable implements Runnable {

	@Override
	public void run() {
		int i = 0;
		for (i = 0; i < 10; i++) {
			/* getName을 직접 호출할 수 없으므로, Thread 클래스의 static 메서드를 활용한다. */
			System.out.println("[" + getName() + "]" +
				"num : " + i + "\t");
		}
	}

	public String getName() {
		return Thread.currentThread().getName();
	}
}
