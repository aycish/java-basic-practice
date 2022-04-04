package basic.thread.terminate;

import java.io.IOException;

public class TerminateThread extends Thread {

	private boolean flag = false;
	int num;

	public TerminateThread(String name) {
		super(name);
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void run() {

		while (!flag) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				System.out.println("[ " + getName() + " ] get interrupt");
				e.printStackTrace();
			}
		}

		System.out.println("[ " + getName() + " ] end");
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Main start.");
		TerminateThread threadA = new TerminateThread("A");
		TerminateThread threadB = new TerminateThread("B");
		TerminateThread threadC = new TerminateThread("C");

		threadA.start();
		threadB.start();
		threadC.start();

		int input = 0;

		while (true) {
			input = System.in.read();

			if (input == 'A') {
				threadA.setFlag(true);
			} else if (input == 'B') {
				threadB.setFlag(true);
			} else if (input == 'C') {
				threadC.setFlag(true);
			} else if (input == 'M') {
				threadA.setFlag(true);
				threadB.setFlag(true);
				threadC.setFlag(true);
				break;
			}
		}

		System.out.println("Main end.");
	}
}
