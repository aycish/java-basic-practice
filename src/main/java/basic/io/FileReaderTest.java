package basic.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {

		/* 문자를 핸들링하지 않아 깨져서 나온다. */
		try (FileInputStream fis = new FileInputStream("reader.txt")) {
			int i;

			while ((i = fis.read()) != -1) {
				System.out.print((char)i);
			}

 		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException occurred");
			e.printStackTrace();
		}

		/* 문자열이 오염되지 않고 잘 출력된다.*/
		try(FileReader fr = new FileReader("reader.txt")) {
			int i;
			while ((i = fr.read()) != -1) {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
