package basic.lambda.compare;

public class LambdaTest {

	public static void main(String[] args) {

		PrintString lambdaStr = s -> System.out.println(s);
		lambdaStr.showString("lambda print");

		// 람다식을 매개변수로 사용
		showMyString(lambdaStr);

		// 람다식을 반환값으로 사용
		PrintString retStr = returnString();
		retStr.showString("Look.");
	}

	private static void showMyString(PrintString prtStr) {
		prtStr.showString("using lambda as parameter");
	}

	private static PrintString returnString() {
		return s -> System.out.println(s + "using lambda as return value");
	}
}
