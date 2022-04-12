package basic.thread.wait;

public class Student extends Thread {

	public Student(String name) {
		super(name);
	}

	public void run() {
		try {
			String title = LibraryMain.library.lendBook();

			if (title == null) {
				System.out.println(getName() + " can't lend the book");
				return;
			}
			sleep(5000);
			LibraryMain.library.returnBook(title);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
