package basic.io.other;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {

		RandomAccessFile rf = new RandomAccessFile("random.txt", "rw");

		/* integer -> 4바이트 이동 */
		rf.writeInt(100);
		/* 파일 포인터 위치 : 4*/
		System.out.println("파일 포인터 위치:" + rf.getFilePointer());

		/* double -> 8바이트 이동 */
		rf.writeDouble(3.14);
		/* 파일 포인터 위치 : 4 + 8 = 12*/
		System.out.println("파일 포인터 위치:" + rf.getFilePointer());

		/* UTF 인코딩 3*5 + 2*/
		rf.writeUTF("안녕하세요");
		/* 파일 포인터 위치 : 12 + 17*/
		System.out.println("파일 포인터 위치:" + rf.getFilePointer());

		/* 파일 포인터 0으로 위치시키기 */
		rf.seek(0);
		System.out.println("파일 포인터 위치:" + rf.getFilePointer());

		int i = rf.readInt();
		double d = rf.readDouble();
		String str = rf.readUTF();

		System.out.println("파일 포인터 위치:" + rf.getFilePointer());
		System.out.println(i);
		System.out.println(d);
		System.out.println(str);
	}
}
