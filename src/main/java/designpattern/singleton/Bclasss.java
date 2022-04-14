package designpattern.singleton;

public class Bclasss {

	private SocketClient socketClient;

	public Bclasss() {
		this.socketClient = SocketClient.getInstance();
	}

	public SocketClient getSocketClient() {
		return this.socketClient;
	}
}
