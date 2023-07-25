package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.MainApp;
import fr.net.asclepiosh.outilcalculgreve.model.JourDeGreves;
import fr.net.asclepiosh.outilcalculgreve.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class JourOverviewController {

	@FXML
	public TableView<JourDeGreves> jourTable;

	@FXML
	private TableColumn<JourDeGreves, String> nomJourColumn;
	@FXML
	public TableColumn<JourDeGreves,  String> dateJourColumn;

	@FXML
	private TableColumn<JourDeGreves, String> transportJourColumn;

	@FXML
	private Label nomJourLabel;
	@FXML
	private Label transportJourLabel;

	@FXML
	private Label dateJourLabel;

	// Reference to the main application.
	private MainApp mainApp;


	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public JourOverviewController() {
	}


	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		// Initialize the jour table with the three columns.
		nomJourColumn.setCellValueFactory(cellData -> cellData.getValue().nomJourProperty());

		dateJourColumn.setCellValueFactory(cellData -> cellData.getValue().dateJourProperty().asString());

		transportJourColumn.setCellValueFactory(cellData -> cellData.getValue().transportJourProperty());

		// Clear person details.
		showJourDetails(null);

		// Listen for selection changes and show the jour details when changed.
		jourTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showJourDetails(newValue));


	}




	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		jourTable.setItems(mainApp.getJourDeGrevesData());
	}


	/**
	 * Fills all text fields to show details about the jourDeGreves.
	 * If the specified jourDeGreves is null, all text fields are cleared.
	 *
	 * @param jourDeGreves the jourDeGreves or null
	 */
	private void showJourDetails(JourDeGreves jourDeGreves) {
		if (jourDeGreves != null) {
			// Fill the labels with info from the jourDeGreves object.
			transportJourLabel.setText(jourDeGreves.getTransportJour());
			nomJourLabel.setText(jourDeGreves.getNomJour());

			// We need to convert the date into a String!
			dateJourLabel.setText(DateUtil.format(jourDeGreves.getDateJour()));

		} else {
			// JourDeGreves is null, remove all the text.
			transportJourLabel.setText("");
			nomJourLabel.setText("");
			dateJourLabel.setText("");

		}
	}




	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new jour.
	 */
	@FXML
	public void handleNewJour() {

		JourDeGreves tempJourDeGreves = new JourDeGreves();

		tempJourDeGreves.setNomJour("JourDeGreves XXX");
		tempJourDeGreves.setTransportJour("RATP");

		// Set default value of the date to today
		tempJourDeGreves.setDateJour(LocalDate.now());

		boolean okClicked = mainApp.showJourEditDialog(tempJourDeGreves);
		if (okClicked) {
			mainApp.getJourDeGrevesData().add(tempJourDeGreves);
		}

	}





	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	public void handleEditJour() {
		JourDeGreves selectedPerson = jourTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			boolean okClicked = mainApp.showJourEditDialog(selectedPerson);
			if (okClicked) {
				showJourDetails(selectedPerson);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Aucune sélection");
			alert.setHeaderText("Aucun jour sélectionné");
			alert.setContentText("Veuillez sélectionner un jour dans la table.");

			alert.showAndWait();
		}

	}





	public void handleDeleteJour() {

		int selectedIndex = jourTable.getSelectionModel().getSelectedIndex();

		if (selectedIndex >= 0) {
			jourTable.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Aucune sélection");
			alert.setHeaderText("Aucun jour sélectionné");
			alert.setContentText("Veuillez sélectionner le jour à supprimer.");

			alert.showAndWait();
		}

	}











}
