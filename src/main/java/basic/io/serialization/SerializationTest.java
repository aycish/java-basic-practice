package basic.io.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
	String name;
	String job;

	public Person() {}

	public Person(String name, String job) {
		this.name = name;
		this.job = job;
	}

	@Override
	public String toString() {
		return name + "," + job;
	}
}

public class SerializationTest {

	public static void main(String[] args) {
		Person personLee = new Person("이순신", "대표이사");
		Person personKim = new Person("김유신", "상무이사");

		try(FileOutputStream fos = new FileOutputStream("serial.txt");
		    ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(personLee);
			oos.writeObject(personKim);

		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		try(FileInputStream fis = new FileInputStream("serial.txt");
		    ObjectInputStream ois = new ObjectInputStream(fis)) {

			Person retPersonLee = (Person)ois.readObject();
			Person retPersonKim = (Person)ois.readObject();

			System.out.println(retPersonLee);
			System.out.println(retPersonKim);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
