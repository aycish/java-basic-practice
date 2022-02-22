package basic.exception.password;

public class PasswordExampleTest {
	private String password;

	public static void main(String[] args) {
		PasswordExampleTest passwordExampleTest = new PasswordExampleTest();
		String[] passwords = {null, "ab12", "abcde", "abcd!12"};

		for (String password : passwords) {
			try {
				passwordExampleTest.setPassword(password);
				System.out.println("정상적으로 비밀번호가 설정되었습니다.");
			} catch (PasswordException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("Finished ... !");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws PasswordException {

		if (password == null) {
			throw new PasswordException("비밀번호로 null을 설정할 수 없습니다.");
		} else if (password.length() < 5) {
			throw new PasswordException("비밀번호의 길이는 5 이상이어야 합니다.");
		} else if (password.matches("[a-zA-Z]*")) {
			throw new PasswordException("특수문자나 숫자가 포함되어야 합니다.");
		}

		this.password = password;
	}
}
