package basic.exception;

public class BasicExceptionTest {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};

		/* out of bound exception 핸들링 예제 */
		try {
			for (int i = 0; i <= 5; i++) {
				System.out.println(arr[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.toString());
		}
	}
}
