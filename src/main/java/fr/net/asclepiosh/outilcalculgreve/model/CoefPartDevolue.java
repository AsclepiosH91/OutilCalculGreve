package fr.net.asclepiosh.outilcalculgreve.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for Coefs part dévolue.
 *
 * @author Nicolas Torres
 */
public class CoefPartDevolue {

	// Coéf part dévolue à la RATP
	private final StringProperty cPartDevolueRATP;

	// Coéf part dévolue à la SNCF
	private final StringProperty cPartDevolueSNCF;




	/**
	 * Constructor with some initial data.
	 *
	 * @param cPartDevolueRATP
	 * @param cPartDevolueSNCF
	 *
	 */

	/**
	 * Default constructor.
	 */
	public CoefPartDevolue() {
		this(null, null);
	}


	public CoefPartDevolue(String cPartDevolueRATP, String cPartDevolueSNCF) {
		this.cPartDevolueRATP = new SimpleStringProperty(cPartDevolueRATP);
		this.cPartDevolueSNCF = new SimpleStringProperty(cPartDevolueSNCF);

	}

	/**
	 * Copy constructor
	 * @param orig instance of CoefJournaliers we want to copy
	 */
	public CoefPartDevolue(final CoefPartDevolue orig) {
		this.cPartDevolueRATP = orig.cPartDevolueRATP;
		this.cPartDevolueSNCF = orig.cPartDevolueSNCF;

	}

	public String getcPartDevolueRATP() {
		return cPartDevolueRATP.get();
	}

	public void setcPartDevolueRATP(String cPartDevolueRATP) {
		this.cPartDevolueRATP.set(cPartDevolueRATP);
	}

	public String getcPartDevolueSNCF() {
		return cPartDevolueSNCF.get();
	}

	public void setcPartDevolueSNCF(String cPartDevolueSNCF) {
		this.cPartDevolueSNCF.set(cPartDevolueSNCF);
	}

}
