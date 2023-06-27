package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.MainApp;
import javafx.event.ActionEvent;

public class JourOverviewController {

	// Reference to the main application.
	private MainApp mainApp;



	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		//personTable.setItems(mainApp.getPersonData());
	}






	public void handleNewJour(ActionEvent actionEvent) {
	}

	public void handleEditJour(ActionEvent actionEvent) {
	}

	public void handleDeleteJour(ActionEvent actionEvent) {
	}















}
