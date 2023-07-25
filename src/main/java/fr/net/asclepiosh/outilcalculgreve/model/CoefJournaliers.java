package fr.net.asclepiosh.outilcalculgreve.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for Coefs journaliers.
 *
 * @author Nicolas Torres
 */
public class CoefJournaliers {

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
	public CoefJournaliers() {
		this(null, null, null, null, null, null, null, null, null, null, null, null);
	}


	public CoefJournaliers(String cJohvR, String cSahvR, String cDihvR, String cJovR, String cSavR, String cDivR, String cJohvS, String cSahvS, String cDihvS, String cJovS, String cSavS, String cDivS) {
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
	 * @param orig instance of CoefJournaliers we want to copy
	 */
	public CoefJournaliers(final CoefJournaliers orig) {
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

	public void setcJohvR(String cJohvR) {
		this.cJohvR.set(cJohvR);
	}

	public String getcSahvR() {
		return cSahvR.get();
	}

	public void setcSahvR(String cSahvR) {
		this.cSahvR.set(cSahvR);
	}

	public String getcDihvR() {
		return cDihvR.get();
	}

	public void setcDihvR(String cDihvR) {
		this.cDihvR.set(cDihvR);
	}

	public String getcJovR() {
		return cJovR.get();
	}

	public void setcJovR(String cJovR) {
		this.cJovR.set(cJovR);
	}

	public String getcSavR() {
		return cSavR.get();
	}

	public void setcSavR(String cSavR) {
		this.cSavR.set(cSavR);
	}

	public String getcDivR() {
		return cDivR.get();
	}

	public void setcDivR(String cDivR) {
		this.cDivR.set(cDivR);
	}

	public String getcJohvS() {
		return cJohvS.get();
	}

	public void setcJohvS(String cJohvS) {
		this.cJohvS.set(cJohvS);
	}

	public String getcSahvS() {
		return cSahvS.get();
	}

	public void setcSahvS(String cSahvS) {
		this.cSahvS.set(cSahvS);
	}

	public String getcDihvS() {
		return cDihvS.get();
	}

	public void setcDihvS(String cDihvS) {
		this.cDihvS.set(cDihvS);
	}

	public String getcJovS() {
		return cJovS.get();
	}

	public void setcJovS(String cJovS) {
		this.cJovS.set(cJovS);
	}

	public String getcSavS() {
		return cSavS.get();
	}

	public void setcSavS(String cSavS) {
		this.cSavS.set(cSavS);
	}

	public String getcDivS() {
		return cDivS.get();
	}

	public void setcDivS(String cDivS) {
		this.cDivS.set(cDivS);
	}
}