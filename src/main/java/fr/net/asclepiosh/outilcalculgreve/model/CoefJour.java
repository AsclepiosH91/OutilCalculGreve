package fr.net.asclepiosh.outilcalculgreve.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for Jour Coefs.
 *
 * @author Nicolas Torres
 */
public class CoefJour {

	// Coéf jour ouvré hors vacances scolaire RATP
	private final StringProperty cJohvR;

	// Coéf samedi hors vacances scolaire RATP
	private final StringProperty cSahvR;

	// Coéf dimanche hors vacances scolaire RATP
	private final StringProperty cDihvR;

	// Coéf jour ouvré vacances scolaire RATP
	private final StringProperty cJovR;

	// Coéf samedi vacances scolaire RATP
	private final StringProperty cSavR;

	// Coéf dimanche vacances scolaire RATP
	private final StringProperty cDivR;

	// Coéf jour ouvré hors vacances scolaire SNCF
	private final StringProperty cJohvS;

	// Coéf samedi hors vacances scolaire SNCF
	private final StringProperty cSahvS;

	// Coéf dimanche hors vacances scolaire SNCF
	private final StringProperty cDihvS;

	// Coéf jour ouvré vacances scolaire SNCF
	private final StringProperty cJovS;

	// Coéf samedi vacances scolaire SNCF
	private final StringProperty cSavS;

	// Coéf dimanche vacances scolaire SNCF
	private final StringProperty cDivS;


	/**
	 * Constructor with some initial data.
	 *
	 * @param cJohvR
	 * @param cSahvR
	 * @param cDihvR
	 * @param cJovR
	 * @param cSavR
	 * @param cDivR
	 * @param cJohvS
	 * @param cSahvS
	 * @param cDihvS
	 * @param cJovS
	 * @param cSavS
	 * @param cDivS
	 *
	 */



	/**
	 * Default constructor.
	 */
	public CoefJour() {
		this(null, null, null, null, null, null, null, null, null, null, null, null);
	}



	public CoefJour(String cJohvR, String cSahvR, String cDihvR, String cJovR, String cSavR, String cDivR, String cJohvS, String cSahvS, String cDihvS, String cJovS, String cSavS, String cDivS) {
		this.cJohvR = new SimpleStringProperty(cJohvR);
		this.cSahvR = new SimpleStringProperty(cSahvR);
		this.cDihvR = new SimpleStringProperty(cDihvR);
		this.cJovR = new SimpleStringProperty(cJovR);
		this.cSavR = new SimpleStringProperty(cSavR);
		this.cDivR = new SimpleStringProperty(cDivR);

		this.cJohvS = new SimpleStringProperty(cJohvS);
		this.cSahvS = new SimpleStringProperty(cSahvS);
		this.cDihvS = new SimpleStringProperty(cDihvS);
		this.cJovS = new SimpleStringProperty(cJovS);
		this.cSavS = new SimpleStringProperty(cSavS);
		this.cDivS = new SimpleStringProperty(cDivS);
	}

	/**
	 * Copy constructor
	 * @param orig instance of CoefJour we want to copy
	 */
	public CoefJour(final CoefJour orig) {
		this.cJohvR = orig.cJohvR;
		this.cSahvR = orig.cSahvR;
		this.cDihvR = orig.cDihvR;
		this.cJovR = orig.cJovR;
		this.cSavR = orig.cSavR;
		this.cDivR = orig.cDivR;
		this.cJohvS = orig.cJohvS;
		this.cSahvS = orig.cSahvS;
		this.cDihvS = orig.cDihvS;
		this.cJovS = orig.cJovS;
		this.cSavS = orig.cSavS;
		this.cDivS = orig.cDivS;
	}

	public String getcJohvR() {
		return cJohvR.get();
	}

	public StringProperty cJohvRProperty() {
		return cJohvR;
	}

	public void setcJohvR(String cJohvR) {
		this.cJohvR.set(cJohvR);
	}

	public String getcSahvR() {
		return cSahvR.get();
	}

	public StringProperty cSahvRProperty() {
		return cSahvR;
	}

	public void setcSahvR(String cSahvR) {
		this.cSahvR.set(cSahvR);
	}

	public String getcDihvR() {
		return cDihvR.get();
	}

	public StringProperty cDihvRProperty() {
		return cDihvR;
	}

	public void setcDihvR(String cDihvR) {
		this.cDihvR.set(cDihvR);
	}

	public String getcJovR() {
		return cJovR.get();
	}

	public StringProperty cJovRProperty() {
		return cJovR;
	}

	public void setcJovR(String cJovR) {
		this.cJovR.set(cJovR);
	}

	public String getcSavR() {
		return cSavR.get();
	}

	public StringProperty cSavRProperty() {
		return cSavR;
	}

	public void setcSavR(String cSavR) {
		this.cSavR.set(cSavR);
	}

	public String getcDivR() {
		return cDivR.get();
	}

	public StringProperty cDivRProperty() {
		return cDivR;
	}

	public void setcDivR(String cDivR) {
		this.cDivR.set(cDivR);
	}

	public String getcJohvS() {
		return cJohvS.get();
	}

	public StringProperty cJohvSProperty() {
		return cJohvS;
	}

	public void setcJohvS(String cJohvS) {
		this.cJohvS.set(cJohvS);
	}

	public String getcSahvS() {
		return cSahvS.get();
	}

	public StringProperty cSahvSProperty() {
		return cSahvS;
	}

	public void setcSahvS(String cSahvS) {
		this.cSahvS.set(cSahvS);
	}

	public String getcDihvS() {
		return cDihvS.get();
	}

	public StringProperty cDihvSProperty() {
		return cDihvS;
	}

	public void setcDihvS(String cDihvS) {
		this.cDihvS.set(cDihvS);
	}

	public String getcJovS() {
		return cJovS.get();
	}

	public StringProperty cJovSProperty() {
		return cJovS;
	}

	public void setcJovS(String cJovS) {
		this.cJovS.set(cJovS);
	}

	public String getcSavS() {
		return cSavS.get();
	}

	public StringProperty cSavSProperty() {
		return cSavS;
	}

	public void setcSavS(String cSavS) {
		this.cSavS.set(cSavS);
	}

	public String getcDivS() {
		return cDivS.get();
	}

	public StringProperty cDivSProperty() {
		return cDivS;
	}

	public void setcDivS(String cDivS) {
		this.cDivS.set(cDivS);
	}
}
