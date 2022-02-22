package basic.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileExceptionTest {
	public static void main(String[] args) {
		FileInputStream fileInputStream = null;

		/* try - catch - finally 예시 */
		try {
			fileInputStream = new FileInputStream("test.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally block executing ... ");
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		/* try - with - resource 예시 (FileInputStream은 AutoCloseable 인터페이스를 구현하고 있다.) */
		try (FileInputStream fileInputStream2 = new FileInputStream("test.txt")) {
			System.out.println("Do something ... ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
