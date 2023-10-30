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
	private final StringProperty CjohvR;

	// Coéf samedi hors vacances scolaire RATP
	private final StringProperty CsahvR;

	// Coéf dimanche hors vacances scolaire RATP
	private final StringProperty CdihvR;

	// Coéf jour ouvré vacances scolaire RATP
	private final StringProperty CjovR;

	// Coéf samedi vacances scolaire RATP
	private final StringProperty CsavR;

	// Coéf dimanche vacances scolaire RATP
	private final StringProperty CdivR;

	// Coéf jour ouvré hors vacances scolaire SNCF
	private final StringProperty CjohvS;

	// Coéf samedi hors vacances scolaire SNCF
	private final StringProperty CsahvS;

	// Coéf dimanche hors vacances scolaire SNCF
	private final StringProperty CdihvS;

	// Coéf jour ouvré vacances scolaire SNCF
	private final StringProperty CjovS;

	// Coéf samedi vacances scolaire SNCF
	private final StringProperty CsavS;

	// Coéf dimanche vacances scolaire SNCF
	private final StringProperty CdivS;


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
		this.CjohvR = new SimpleStringProperty(cJohvR);
		this.CsahvR = new SimpleStringProperty(cSahvR);
		this.CdihvR = new SimpleStringProperty(cDihvR);
		this.CjovR = new SimpleStringProperty(cJovR);
		this.CsavR = new SimpleStringProperty(cSavR);
		this.CdivR = new SimpleStringProperty(cDivR);

		this.CjohvS = new SimpleStringProperty(cJohvS);
		this.CsahvS = new SimpleStringProperty(cSahvS);
		this.CdihvS = new SimpleStringProperty(cDihvS);
		this.CjovS = new SimpleStringProperty(cJovS);
		this.CsavS = new SimpleStringProperty(cSavS);
		this.CdivS = new SimpleStringProperty(cDivS);
	}

	/**
	 * Copy constructor
	 * @param orig instance of CoefJournaliers we want to copy
	 */
	public CoefJournaliers(final CoefJournaliers orig) {
		this.CjohvR = orig.CjohvR;
		this.CsahvR = orig.CsahvR;
		this.CdihvR = orig.CdihvR;
		this.CjovR = orig.CjovR;
		this.CsavR = orig.CsavR;
		this.CdivR = orig.CdivR;

		this.CjohvS = orig.CjohvS;
		this.CsahvS = orig.CsahvS;
		this.CdihvS = orig.CdihvS;
		this.CjovS = orig.CjovS;
		this.CsavS = orig.CsavS;
		this.CdivS = orig.CdivS;
	}

	public String getCjohvR() {
		return CjohvR.get();
	}

	public void setCjohvR(String cjohvR) {
		this.CjohvR.set(cjohvR);
	}

	public String getCsahvR() {
		return CsahvR.get();
	}

	public void setCsahvR(String csahvR) {
		this.CsahvR.set(csahvR);
	}

	public String getCdihvR() {
		return CdihvR.get();
	}

	public void setCdihvR(String cdihvR) {
		this.CdihvR.set(cdihvR);
	}

	public String getCjovR() {
		return CjovR.get();
	}

	public void setCjovR(String cjovR) {
		this.CjovR.set(cjovR);
	}

	public String getCsavR() {
		return CsavR.get();
	}

	public void setCsavR(String csavR) {
		this.CsavR.set(csavR);
	}

	public String getCdivR() {
		return CdivR.get();
	}

	public void setCdivR(String cdivR) {
		this.CdivR.set(cdivR);
	}

	public String getCjohvS() {
		return CjohvS.get();
	}

	public void setCjohvS(String cjohvS) {
		this.CjohvS.set(cjohvS);
	}

	public String getCsahvS() {
		return CsahvS.get();
	}

	public void setCsahvS(String csahvS) {
		this.CsahvS.set(csahvS);
	}

	public String getCdihvS() {
		return CdihvS.get();
	}

	public void setCdihvS(String cdihvS) {
		this.CdihvS.set(cdihvS);
	}

	public String getCjovS() {
		return CjovS.get();
	}

	public void setCjovS(String cjovS) {
		this.CjovS.set(cjovS);
	}

	public String getCsavS() {
		return CsavS.get();
	}

	public void setCsavS(String csavS) {
		this.CsavS.set(csavS);
	}

	public String getCdivS() {
		return CdivS.get();
	}

	public void setCdivS(String cdivS) {
		this.CdivS.set(cdivS);
	}
}
