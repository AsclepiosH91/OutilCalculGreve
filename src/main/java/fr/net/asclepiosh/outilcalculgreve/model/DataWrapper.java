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
@XmlRootElement(name = "jours")
public class DataWrapper {


	private List<JourDeGreves> jourDeGreves;

	private CoefJournaliers coefJours;

	@XmlElement(name = "joursdegreves")
	public List<JourDeGreves> getJours() {
			return jourDeGreves;
		}
	public void setJours(List<JourDeGreves> jourDeGreves) {
			this.jourDeGreves = jourDeGreves;
		}

	@XmlElement(name = "coefjournalier", required = true)
	public CoefJournaliers getCoefJours() {
		return coefJours;
	}

	public void setCoefJours(CoefJournaliers coefJours) {
		this.coefJours = coefJours;
	}
}

