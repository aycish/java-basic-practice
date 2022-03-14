package basic.io.assistant;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;

public class FileCopyTest {

	public static void main(String[] args) {

		long millisecond = 0L;

		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.zip"))) {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.zip"));
			millisecond = System.currentTimeMillis();

			int i ;
			while ((i = bis.read()) != -1) {
				bos.write(i);
			}

			millisecond = System.currentTimeMillis() - millisecond;
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(millisecond + " ms 소요");
	}


}
