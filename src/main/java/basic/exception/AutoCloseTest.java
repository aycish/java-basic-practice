package basic.exception;

public class AutoCloseTest {
	public static void main(String[] args) {

		// AutoCloseableObject object = new AutoCloseableObject();
		// try(obj) -> java 9부터 사용 가능

		try (AutoCloseableObject object = new AutoCloseableObject()) {
			System.out.println("Do somthing ... ");
			throw new Exception();
		} catch (Exception e) {
			System.out.println("Exception ... !");
		}
		System.out.println("Finished .. ");
	}
}
