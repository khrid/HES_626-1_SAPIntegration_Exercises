package sapserver;

import java.util.Properties;

import com.sap.conn.jco.ext.DataProviderException;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;

public class ProviderRFCDestination implements DestinationDataProvider {

	//Variable
	public static String SAP_SERVER ;
	private final Properties _destination;
	
	public ProviderRFCDestination(String destinationSID) {
			SAP_SERVER = destinationSID ;
			this._destination = new Properties();
			this._destination.setProperty(DestinationDataProvider.JCO_ASHOST, "vlhsapd20");
			this._destination.setProperty(DestinationDataProvider.JCO_SYSNR, "60");
			this._destination.setProperty(DestinationDataProvider.JCO_CLIENT, "100");
			this._destination.setProperty(DestinationDataProvider.JCO_USER, "M626E-03");
			this._destination.setProperty(DestinationDataProvider.JCO_PASSWD, "m626e-03");
			this._destination.setProperty(DestinationDataProvider.JCO_LANG, "EN");
			this._destination.setProperty(DestinationDataProvider.JCO_SAPROUTER, "/H/saprouter.hevs.ch/S/3299/H/");
	}
	
	@Override
	public Properties getDestinationProperties(String destinationName) throws DataProviderException {
		// TODO Auto-generated method stub
		return this._destination;
	}

	@Override
	public void setDestinationDataEventListener(DestinationDataEventListener eventListener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsEvents() {
		// TODO Auto-generated method stub
		return false;
	}

}
