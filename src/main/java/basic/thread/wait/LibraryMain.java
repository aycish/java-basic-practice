package basic.thread.wait;

public class LibraryMain {

	public static FastLibrary library = new FastLibrary();

	public static void main(String[] args) {
		Student std1 = new Student("std1");
		Student std2 = new Student("std2");
		Student std3 = new Student("std3");
		Student std4 = new Student("std4");
		Student std5 = new Student("std5");
		Student std6 = new Student("std6");
		Student std7 = new Student("std7");

		std1.start();
		std2.start();
		std3.start();
		std4.start();
		std5.start();
		std6.start();
		std7.start();

	}
}
