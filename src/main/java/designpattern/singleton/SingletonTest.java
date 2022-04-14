package designpattern.singleton;

public class SingletonTest {

	public static void main(String[] args) {
		AClasss aClasss = new AClasss();
		Bclasss bclasss = new Bclasss();

		SocketClient aClient = aClasss.getSocketClient();
		SocketClient bClient = bclasss.getSocketClient();

		System.out.println("두 객체의 비교 값");
		System.out.println("--------------");
		System.out.println(aClient.equals(bClient));
	}
}
