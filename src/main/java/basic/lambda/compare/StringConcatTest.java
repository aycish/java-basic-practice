package basic.lambda.compare;

public class StringConcatTest {
	public static void main(String[] args) {

		String s1 = "First";
		String s2 = "Second";

		/* 객체 지향 방식의 구현 */
		StringConcatImpl strImpl = new StringConcatImpl();
		strImpl.makeString(s1, s2);

		/* 람다식 구현. 클래스 생성이 필요 없다. */
		StringConcat concat = (f, s)-> System.out.println(f + "," + s);
		concat.makeString(s1,s2);

		/* 구체적인 로직 설명 */
		/*  하기와 같은 익명 클래스가 생성되어 동작하는 방식이다.
		*   StringConcat concat = new StringConcat() {
		*
		*       @Overide
		*       public void makeString(String s1, String s2) {
		*           System.out.println(s1 + "," + s2);
		*       }
		* }
		*
		*/
	}
}
