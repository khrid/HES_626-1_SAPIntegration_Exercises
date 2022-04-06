package sapserver;

import com.sap.conn.jco.AbapClassException;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.server.JCoServerContext;
import com.sap.conn.jco.server.JCoServerFunctionHandler;

public class HandlerZ_FM_SUPPLIER2 implements JCoServerFunctionHandler {

	@Override
	public void handleRequest(JCoServerContext serverCtx, JCoFunction function)
			throws AbapException, AbapClassException {
		System.out.println("HandlerZ_FM_SUPPLIER2.handleRequest");
		// Get Import Parameter
		String iv_idDepartment = function.getImportParameterList().getString("IV_IDDEPARTMENT");

		// Get Export Paramter
		JCoTable et_suppliers = function.getExportParameterList().getTable("ET_SUPPLIERS");
		
		// try {
		//
		// }catch(AbapException e) {
		// throw new AbapException("EX_UNKNOWN");
		// }

		// Simulation d'une erreur
		if ("ER".equals(iv_idDepartment)) {
			throw new AbapException("EX_EMPTY");
		} else {

			// accès à la base de données
			et_suppliers.appendRow();
			et_suppliers.setRow(0);
			et_suppliers.setValue("ID_DEPARTMENT", iv_idDepartment);
			et_suppliers.setValue("ID_SUPPLIER", "224");
			et_suppliers.setValue("LASTNAME", "Crittin");
			et_suppliers.setValue("FIRSTNAME", "David");
			et_suppliers.setValue("ADDRESS", "RUE DES CHALLENGES");
			et_suppliers.setValue("POSTAL_CODE", "1920");
			et_suppliers.setValue("CITY", "MARTIGNY");
			et_suppliers.setValue("TEL", "0791234567");

			et_suppliers.appendRow();
			et_suppliers.setRow(1);
			et_suppliers.setValue("ID_DEPARTMENT", iv_idDepartment);
			et_suppliers.setValue("ID_SUPPLIER", "478");
			et_suppliers.setValue("LASTNAME", "John");
			et_suppliers.setValue("FIRSTNAME", "Wick");
			et_suppliers.setValue("ADDRESS", "Intercontinental Road");
			et_suppliers.setValue("POSTAL_CODE", "12345");
			et_suppliers.setValue("CITY", "New-York");
			et_suppliers.setValue("TEL", "555-***-****");
		}

		// System.out.println(et_suppliers);
		function.getExportParameterList().setValue("ET_SUPPLIERS", et_suppliers);

	}

}
