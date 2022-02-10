package basic.lambda;

public class ExampleTest {

	public static void main(String[] args) {
		/* 인터페이스에 선언해놓은 메서드 람다식으로 구현 */
		Add add = (x, y) -> {
			return x + y;
		};

		/* return문 포함하여 생략 가능 */
		//Add add = (x,y)-> x + y;

		System.out.println(add.add(3, 5));
	}
}
