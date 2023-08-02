package fr.net.asclepiosh.outilcalculgreve.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for Coefs d'Ajustements.
 *
 * @author Nicolas Torres
 */
public class CoefAjust {

	// Coéf Article 1-1 Ajustement
	private final StringProperty cArt11Ajust;

	// Coéf Correctif RD HT Ajusté
	private final StringProperty cCorrRDHTAjust;

	// Coéf Article 47-5 Autre rémunérations Ajusté
	private final StringProperty cArtAutrRemunAjust;




	/**
	 * Constructor with some initial data.
	 *
	 * @param cArt11Ajust
	 * @param cCorrRDHTAjust
	 * @param cArtAutrRemunAjust
	 *
	 */

	/**
	 * Default constructor.
	 */
	public CoefAjust() {
		this(null, null, null);
	}


	public CoefAjust(String cArt11Ajust, String cCorrRDHTAjust, String cArtAutrRemunAjust) {
		this.cArt11Ajust = new SimpleStringProperty(cArt11Ajust);
		this.cCorrRDHTAjust = new SimpleStringProperty(cCorrRDHTAjust);
		this.cArtAutrRemunAjust = new SimpleStringProperty(cArtAutrRemunAjust);

	}

	/**
	 * Copy constructor
	 *
	 * @param orig instance of CoefAjust we want to copy
	 */
	public CoefAjust(final CoefAjust orig) {
		this.cArt11Ajust = orig.cArt11Ajust;
		this.cCorrRDHTAjust = orig.cCorrRDHTAjust;
		this.cArtAutrRemunAjust = orig.cArtAutrRemunAjust;

	}

	public String getcArt11Ajust() {
		return cArt11Ajust.get();
	}

	public StringProperty cArt11AjustProperty() {
		return cArt11Ajust;
	}

	public void setcArt11Ajust(String cArt11Ajust) {
		this.cArt11Ajust.set(cArt11Ajust);
	}

	public String getcCorrRDHTAjust() {
		return cCorrRDHTAjust.get();
	}

	public StringProperty cCorrRDHTAjustProperty() {
		return cCorrRDHTAjust;
	}

	public void setcCorrRDHTAjust(String cCorrRDHTAjust) {
		this.cCorrRDHTAjust.set(cCorrRDHTAjust);
	}

	public String getcArtAutrRemunAjust() {
		return cArtAutrRemunAjust.get();
	}

	public StringProperty cArtAutrRemunAjustProperty() {
		return cArtAutrRemunAjust;
	}

	public void setcArtAutrRemunAjust(String cArtAutrRemunAjust) {
		this.cArtAutrRemunAjust.set(cArtAutrRemunAjust);
	}
}
