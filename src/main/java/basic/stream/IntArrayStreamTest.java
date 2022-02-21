package basic.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntArrayStreamTest {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};

		/* 기존 배열에 대한 사용법 */
		for (int num : arr) {
			System.out.println("num = " + num);
		}
		System.out.println();

		/* Stream을 사용해보자 */
		Arrays.stream(arr).forEach(n-> System.out.println("num[Stream] = " + n));

		/* 다양한 메서드들이 제공되므로 확인해보자.
		 *  중간 연산 예시
		 */
		IntStream is = Arrays.stream(arr);
		is.filter(n->n >= 3).forEach(n-> System.out.println(n));

	}
}
