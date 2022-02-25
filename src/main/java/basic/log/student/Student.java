package basic.log.student;

import basic.log.UniLogger;

public class Student {

	private String name;
	UniLogger uniLogger = UniLogger.getLogger();

	public Student(String name) {
		if (name == null) {
			throw new StudentNameFormatException("name must not be null");
		}

		if (name.split(" ").length > 3) {
			throw new StudentNameFormatException("length of name is too long");
		}

		this.name = name;
	}

	public String getStudentName() {
		uniLogger.logFine("start getStudentName()");
		return name;
	}
}
