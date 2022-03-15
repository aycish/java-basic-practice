package basic.io.other;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\java_practice\\newFile.txt");
		file.createNewFile();

		/* 열람할 수 있는 파일 속성 출력 */
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getPath());
		System.out.println(file.canRead());
		System.out.println(file.canWrite());

		file.delete();
	}
}
