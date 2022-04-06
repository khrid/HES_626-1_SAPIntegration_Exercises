package sapserver;

import java.util.Properties;

import com.sap.conn.jco.ext.DataProviderException;
import com.sap.conn.jco.ext.ServerDataEventListener;
import com.sap.conn.jco.ext.ServerDataProvider;

public class ProviderRFCServer implements ServerDataProvider {
	//Variable
	public static String SAP_SERVER ;
	private final Properties _server;
	
	public ProviderRFCServer(String serverSID) {
		SAP_SERVER = serverSID ;
		this._server = new Properties();
		this._server.setProperty(ServerDataProvider.JCO_PROGID, "ID_RFCSERVER_E27");
		this._server.setProperty(ServerDataProvider.JCO_GWHOST, "vlhsapd20");
		this._server.setProperty(ServerDataProvider.JCO_GWSERV, "3360");
		this._server.setProperty(ServerDataProvider.JCO_SAPROUTER, "/H/saprouter.hevs.ch/S/3299/H/");
		this._server.setProperty(ServerDataProvider.JCO_CONNECTION_COUNT, "2");
	}
	
	@Override
	public Properties getServerProperties(String serverName) throws DataProviderException {
		// TODO Auto-generated method stub
		return this._server; 
	}

	@Override
	public void setServerDataEventListener(ServerDataEventListener eventListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsEvents() {
		// TODO Auto-generated method stub
		return false;
	}

}
