package basic.io.assistant;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {

		long millisecond = 0L;

		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.zip"))) {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.zip"));
			millisecond = System.currentTimeMillis();

			int index;
			while ((index = bis.read()) != -1) {
				bos.write(index);
			}

			millisecond = System.currentTimeMillis() - millisecond;
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(millisecond + " ms 소요");
	}

}
