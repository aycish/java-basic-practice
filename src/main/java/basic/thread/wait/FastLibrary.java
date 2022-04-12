package basic.thread.wait;

import java.util.ArrayList;

public class FastLibrary {

	public ArrayList<String> shelf = new ArrayList<String> ();
	public FastLibrary() {
		shelf.add("칼의 노래1");
		shelf.add("칼의 노래2");
		shelf.add("칼의 노래3");
		shelf.add("칼의 노래4");
		shelf.add("칼의 노래5");
		shelf.add("칼의 노래6");
	}

	public synchronized String lendBook() throws InterruptedException {

		Thread t =Thread.currentThread();

		if (shelf.size() == 0) {
			System.out.println(t.getName() + " : waiting .. " );
			wait();
			System.out.println(t.getName() + " : finished waiting .. " );
		}

		if (shelf.size() > 0) {
			String book = shelf.remove(0);
			System.out.println(t.getName() + " : " + book + " lend");
			return book;
		} else {
			return null;
		}
	}

	public synchronized void returnBook(String book) {
		Thread t = Thread.currentThread();

		shelf.add(book);
		notify();
		System.out.println(t.getName() + " : " + book + " return");

	}
}
