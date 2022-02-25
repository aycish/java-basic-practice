package basic.log.student;

import basic.log.UniLogger;

public class StudentTest {
	public static void main(String[] args) {
		UniLogger uniLogger = UniLogger.getLogger();
		String name = null;

		try {
			Student student = new Student(name);
		} catch (StudentNameFormatException e) {
			uniLogger.logWarning(e.getMessage());
		}

		try {
			Student student = new Student("too long name will be inserted to create object");
		} catch (StudentNameFormatException e) {
			uniLogger.logWarning(e.getMessage());
		}

		Student student = new Student("unhee");
		System.out.println(student.getStudentName());
	}
}
