package designpattern.singleton;

public class AClasss {

	private SocketClient socketClient;

	public AClasss() {
		this.socketClient = SocketClient.getInstance();
	}

	public SocketClient getSocketClient() {
		return this.socketClient;
	}
}
