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

	private List<JoursDeGreveOuPollution> joursDeGreveOuPollutionData;

	private CoefJournaliers coefJoursData;

	private CoefTypeForfaitUsage coefTypeForfaitUsageData;

	private CoefPartDevolue coefPartDevolueData;

	private CoefAjust coefAjustData;


	@XmlElement(name = "joursdegreves", required = true)
	public List<JoursDeGreveOuPollution> getJours() {
			return joursDeGreveOuPollutionData;
		}
	public void setJours(List<JoursDeGreveOuPollution> joursDeGreveOuPollutions) {
			this.joursDeGreveOuPollutionData = joursDeGreveOuPollutions;
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

	@XmlElement(name = "coefPartDevolue", required = true)
	public CoefPartDevolue getCoefPartDevolueData() {
		return coefPartDevolueData;
	}

	public void setCoefPartDevolueData(CoefPartDevolue coefPartDevolueData) {
		this.coefPartDevolueData = coefPartDevolueData;
	}


	@XmlElement(name = "coefAjustements", required = true)
	public CoefAjust getCoefAjustData() {
		return coefAjustData;
	}

	public void setCoefAjustData(CoefAjust coefAjustData) {
		this.coefAjustData = coefAjustData;
	}


}

