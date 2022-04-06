package util;

import sapserver.SAPServer;

public class Launch {
	public static void main(String[] args) {
		SAPServer server = new SAPServer();
		server.runServer();
	}
}
