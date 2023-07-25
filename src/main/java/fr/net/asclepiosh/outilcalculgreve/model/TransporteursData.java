package fr.net.asclepiosh.outilcalculgreve.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TransporteursData {

	public static ObservableList<Transporteurs> getTransportList() {
		Transporteurs RATP = new Transporteurs("0", "RATP");
		Transporteurs SNCF = new Transporteurs("1", "SNCF");
		Transporteurs RATPSNCF = new Transporteurs("2", "RATP-SNCF");

		return FXCollections.observableArrayList(RATP, SNCF, RATPSNCF);
	}

}
