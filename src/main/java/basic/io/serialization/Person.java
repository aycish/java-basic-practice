package basic.io.serialization;

import java.io.Serializable;

class Person implements Serializable {
	String name;
	String job;

	public Person() {
	}

	public Person(String name, String job) {
		this.name = name;
		this.job = job;
	}

	@Override
	public String toString() {
		return name + "," + job;
	}
}
