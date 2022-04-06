package sapserver;

import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.ext.Environment;
import com.sap.conn.jco.server.DefaultServerHandlerFactory;
import com.sap.conn.jco.server.JCoServer;
import com.sap.conn.jco.server.JCoServerFactory;
import com.sap.conn.jco.server.JCoServerFunctionHandler;

public class SAPServer {
	// Variable
	private String _destinationSID;
	private String _serverSID;
	private JCoServer _server;

	// Constructor
	public SAPServer() {
		// Destination Provider
		this._destinationSID = "D20";
		ProviderRFCDestination _rfcdestination = new ProviderRFCDestination(this._destinationSID);
		Environment.registerDestinationDataProvider(_rfcdestination);
		// Server Provider
		this._serverSID = "D20";
		ProviderRFCServer _rfcserver = new ProviderRFCServer(this._serverSID);
		Environment.registerServerDataProvider(_rfcserver);
	}

	public void runServer() {
		// Connection to SAP (RFC Server ID & IP + Access to SAP Repository)
		try {
			this._server = JCoServerFactory.getServer(this._serverSID);
			// Access to the SAP Repository via JCoDestination
			this._server.setRepository(JCoDestinationManager.getDestination(this._destinationSID));
		} catch (JCoException ex) {
			System.out.println("Unable to create the server " + this._serverSID + ", because of " + ex.getMessage());
		}
		// ------------------------------------------------------------------------
		// Contain the LIST of SAP Function Module (FM) available in this RFC Server
		DefaultServerHandlerFactory.FunctionHandlerFactory factory = new DefaultServerHandlerFactory.FunctionHandlerFactory();
		// ------------------------------------------------------------------------
		// MAPPING SAP Function Module & Java Handler
		// Z_FM_TABLE
		JCoServerFunctionHandler handler = new HandlerZ_FM_SUPPLIER2();
		factory.registerHandler("Z_FM_RFCSERVER_SUPPLIER2_E27", handler);
		// ------------------------------------------------------------------------
		// Assignment the FM List to the RFC Server
		this._server.setCallHandlerFactory(factory);
		// Start the RFC Server
		this._server.start();
		System.out.println("RFC Server Start");
	}
}
