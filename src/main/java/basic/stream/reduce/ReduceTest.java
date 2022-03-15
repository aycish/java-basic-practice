package basic.stream.reduce;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class ReduceTest {
	public static void main(String[] args) {
		String[] strings = {"abcdefg", "한국말입니다.", "Good morning~!", "곤니찌와,,"};

		/* 람다식 활용하는 예시 */
		System.out.println(Arrays.stream(strings).reduce("", (s1, s2) -> {
			if (s1.getBytes().length >= s2.getBytes().length) {
				return s1;
			} else {
				return s2;
			}
		}));

		/* 구현한 클래스 활용하는 예시 */
		String str = Arrays.stream(strings).reduce(new CompareString()).get();
		System.out.println(str);
	}

	static class CompareString implements BinaryOperator<String> {

		@Override
		public String apply(String s1, String s2) {
			if (s1.getBytes().length >= s2.getBytes().length) {
				return s1;
			} else {
				return s2;
			}
		}
	}
}
