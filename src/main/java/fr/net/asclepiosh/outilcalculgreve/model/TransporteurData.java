package fr.net.asclepiosh.outilcalculgreve.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TransporteurData {

	public static ObservableList<Transporteur> getTransportList() {
		Transporteur RATP = new Transporteur("01", "RATP");
		Transporteur SNCF = new Transporteur("02", "SNCF");
		Transporteur RATPSNCF = new Transporteur("03", "RATP & SNCF");

		return FXCollections.observableArrayList(RATP, SNCF, RATPSNCF);
	}

}
