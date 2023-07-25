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
@XmlRootElement(name = "donneescalculgreve")
public class DataWrapper {


	private List<JourDeGreves> jourDeGreves;

	private CoefJournaliers coefJoursData;

	private CoefTypeForfaitUsage coefTypeForfaitUsageData;

	@XmlElement(name = "joursdegreves", required = true)
	public List<JourDeGreves> getJours() {
			return jourDeGreves;
		}
	public void setJours(List<JourDeGreves> jourDeGreves) {
			this.jourDeGreves = jourDeGreves;
		}

	@XmlElement(name = "coefjournalier", required = true)
	public CoefJournaliers getCoefJoursData() {
		return coefJoursData;
	}

	public void setCoefJoursData(CoefJournaliers coefJoursData) {
		this.coefJoursData = coefJoursData;
	}

	@XmlElement(name = "coeftypeforfaitusage", required = true)
	public CoefTypeForfaitUsage getCoefTypeForfaitUsageData() {
		return coefTypeForfaitUsageData;
	}

	public void setCoefTypeForfaitUsageData(CoefTypeForfaitUsage coefTypeForfaitUsageData) {
		this.coefTypeForfaitUsageData = coefTypeForfaitUsageData;
	}


}

