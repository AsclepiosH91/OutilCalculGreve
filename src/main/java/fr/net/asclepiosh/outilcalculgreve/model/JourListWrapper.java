package fr.net.asclepiosh.outilcalculgreve.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Helper class to wrap a list of Jours. This is used for saving the
 * list of Jours to XML.
 *
 * @author Nicolas Torres
 */
@XmlRootElement(name = "joursdegreve")
public class JourListWrapper {


	private List<Jour> jours;

	private CoefJour coefJours;

	@XmlElement(name = "jour")
	public List<Jour> getJours() {
			return jours;
		}
	public void setJours(List<Jour> jours) {
			this.jours = jours;
		}

	@XmlElement(name = "coefjournalier", required = true)
	public CoefJour getCoefJours() {
		return coefJours;
	}

	public void setCoefJours(CoefJour coefJours) {
		this.coefJours = coefJours;
	}
}

