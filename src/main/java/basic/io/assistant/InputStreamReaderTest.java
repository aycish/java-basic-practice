package basic.io.assistant;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
	public static void main(String[] args) {

		// try (FileInputStream fis = new FileInputStream("reader.txt")) { -> reader.txt의 한글 문자들이 깨져서 출력된다.
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream("reader.txt"))) {
			int i;
			while((i = isr.read())!= -1) {
				System.out.print((char)i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
