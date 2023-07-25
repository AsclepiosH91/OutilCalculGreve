package fr.net.asclepiosh.outilcalculgreve.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for Coefs par type de forfait d'usage.
 *
 * @author Nicolas Torres
 */
public class CoefTypeForfaitUsage {

	// Coéf Forfait OD RATP
	private final StringProperty cForfaitODRATP;

	// Coéf Forfait T+NL+ RATP
	private final StringProperty cForfaitTNLRATP;

	// Coéf Forfait courts RATP
	private final StringProperty cForfaitCourtsRATP;

	// Coéf Forfait 100% RATP
	private final StringProperty cForfait100RATP;


	// Coéf Forfait OD SNCF
	private final StringProperty cForfaitODSNCF;

	// Coéf Forfait T+NL+ RATP
	private final StringProperty cForfaitTNLSNCF;

	// Coéf Forfait courts RATP
	private final StringProperty cForfaitCourtsSNCF;

	// Coéf Forfait 100% RATP
	private final StringProperty cForfait0SNCF;




	/**
	 * Constructor with some initial data.
	 *
	 * @param cForfaitODRATP
	 * @param cForfaitODRATP
	 * @param cForfaitCourtsRATP
	 * @param cForfait100RATP
	 * @param cForfaitODSNCF
	 * @param cForfaitTNLSNCF
	 * @param cForfaitCourtsSNCF
	 * @param cForfait0SNCF
	 *
	 */

	/**
	 * Default constructor.
	 */
	public CoefTypeForfaitUsage() {
		this(null, null, null, null, null, null, null, null);
	}



	public CoefTypeForfaitUsage(String cForfaitODRATP, String cForfaitTNLRATP, String cForfaitCourtsRATP, String cForfait100RATP, String cForfaitODSNCF, String cForfaitTNLSNCF, String cForfaitCourtsSNCF, String cForfait0SNCF) {

		this.cForfaitODRATP = new SimpleStringProperty(cForfaitODRATP);
		this.cForfaitTNLRATP = new SimpleStringProperty(cForfaitTNLRATP);
		this.cForfaitCourtsRATP = new SimpleStringProperty(cForfaitCourtsRATP);
		this.cForfait100RATP = new SimpleStringProperty(cForfait100RATP);

		this.cForfaitODSNCF = new SimpleStringProperty(cForfaitODSNCF);
		this.cForfaitTNLSNCF = new SimpleStringProperty(cForfaitTNLSNCF);
		this.cForfaitCourtsSNCF = new SimpleStringProperty(cForfaitCourtsSNCF);
		this.cForfait0SNCF = new SimpleStringProperty(cForfait0SNCF);

	}

	/**
	 * Copy constructor
	 * @param orig instance of CoefJournaliers we want to copy
	 */
	public CoefTypeForfaitUsage(final CoefTypeForfaitUsage orig) {
		this.cForfaitODRATP = orig.cForfaitODRATP;
		this.cForfaitTNLRATP = orig.cForfaitTNLRATP;
		this.cForfaitCourtsRATP = orig.cForfaitCourtsRATP;
		this.cForfait100RATP = orig.cForfait100RATP;

		this.cForfaitODSNCF = orig.cForfaitODSNCF;
		this.cForfaitTNLSNCF = orig.cForfaitTNLSNCF;
		this.cForfaitCourtsSNCF = orig.cForfaitCourtsSNCF;
		this.cForfait0SNCF = orig.cForfait0SNCF;

	}

	public String getcForfaitODRATP() {
		return cForfaitODRATP.get();
	}

	public void setcForfaitODRATP(String cForfaitODRATP) {
		this.cForfaitODRATP.set(cForfaitODRATP);
	}

	public String getcForfaitTNLRATP() {
		return cForfaitTNLRATP.get();
	}

	public void setcForfaitTNLRATP(String cForfaitTNLRATP) {
		this.cForfaitTNLRATP.set(cForfaitTNLRATP);
	}

	public String getcForfaitCourtsRATP() {
		return cForfaitCourtsRATP.get();
	}

	public void setcForfaitCourtsRATP(String cForfaitCourtsRATP) {
		this.cForfaitCourtsRATP.set(cForfaitCourtsRATP);
	}

	public String getcForfait100RATP() {
		return cForfait100RATP.get();
	}

	public void setcForfait100RATP(String cForfait100RATP) {
		this.cForfait100RATP.set(cForfait100RATP);
	}

	public String getcForfaitODSNCF() {
		return cForfaitODSNCF.get();
	}

	public void setcForfaitODSNCF(String cForfaitODSNCF) {
		this.cForfaitODSNCF.set(cForfaitODSNCF);
	}

	public String getcForfaitTNLSNCF() {
		return cForfaitTNLSNCF.get();
	}

	public void setcForfaitTNLSNCF(String cForfaitTNLSNCF) {
		this.cForfaitTNLSNCF.set(cForfaitTNLSNCF);
	}

	public String getcForfaitCourtsSNCF() {
		return cForfaitCourtsSNCF.get();
	}

	public void setcForfaitCourtsSNCF(String cForfaitCourtsSNCF) {
		this.cForfaitCourtsSNCF.set(cForfaitCourtsSNCF);
	}

	public String getcForfait0SNCF() {
		return cForfait0SNCF.get();
	}

	public void setcForfait0SNCF(String cForfait0SNCF) {
		this.cForfait0SNCF.set(cForfait0SNCF);
	}

}
