package basic.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsException {

	public static void main(String[] args) {
		ThrowsException test = new ThrowsException();

		try {
			test.loadClass("test.text", "testClass");
		} catch (ClassNotFoundException | FileNotFoundException e) {
			System.out.println("Class Not found exception ... !");
		} catch (Exception e) {
			/* default exception 처리. 혹시 모를 발생할 수 있는 익셉션 처리를 위함 제일 마지막에 위치 */
			System.out.println("Default Exception Handling ... !");
		}
	}

	/* 이 메서드를 호출하는 시점에 Exception을 핸들링하는 예제 */
	public Class loadClass(String fileName, String className) throws ClassNotFoundException, FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		Class cls = Class.forName(className);

		return cls;
	}
}
