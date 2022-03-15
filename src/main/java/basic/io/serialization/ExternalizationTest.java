package basic.io.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizationTest {

	public static void main(String[] args) {
		ExPerson personLee = new ExPerson("이순신", "대표이사");
		ExPerson personKim = new ExPerson("김유신", "상무이사");

		try (FileOutputStream fos = new FileOutputStream("external.txt");
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(personLee);
			oos.writeObject(personKim);

		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		try (FileInputStream fis = new FileInputStream("external.txt"); ObjectInputStream ois = new ObjectInputStream(
			fis)) {

			ExPerson retPersonLee = (ExPerson)ois.readObject();
			ExPerson retPersonKim = (ExPerson)ois.readObject();

			System.out.println(retPersonLee);
			System.out.println(retPersonKim);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
