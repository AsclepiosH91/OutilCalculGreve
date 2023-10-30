package fr.net.asclepiosh.outilcalculgreve.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TransportsOuPollutionData {

	public static ObservableList<TransportsOuPollution> getTransportOuPollutionList() {
		TransportsOuPollution RATP = new TransportsOuPollution("0", "RATP");
		TransportsOuPollution SNCF = new TransportsOuPollution("1", "SNCF");
		TransportsOuPollution RATPSNCF = new TransportsOuPollution("2", "RATP-SNCF");
		TransportsOuPollution Pollution = new TransportsOuPollution("3", "Journée Pollution");

		return FXCollections.observableArrayList(RATP, SNCF, RATPSNCF, Pollution);
	}

}
