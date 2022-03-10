package basic.io;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInTest {
	public static void main(String[] args) {
		int input;

		System.out.println("알파벳 여러 개를 쓰고, [Enter]를 누르세요");

		try {
			InputStreamReader irs = new InputStreamReader(System.in);
			while ((input = irs.read()) != '\n') {
				System.out.println("ascii : " + input);
				System.out.println("char : " + (char)input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
