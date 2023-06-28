package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.MainApp;
import fr.net.asclepiosh.outilcalculgreve.model.Jour;
import fr.net.asclepiosh.outilcalculgreve.util.DateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class JourOverviewController {

	@FXML
	public TableView<Jour> jourTable;
	@FXML
	private TableColumn<Jour, String> numJourColumn;
	@FXML
	private TableColumn<Jour, String> typeJourColumn;

	@FXML
	private Label numJourLabel;
	@FXML
	private Label typeJourLabel;

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
		// Initialize the jour table with the two columns.
		numJourColumn.setCellValueFactory(cellData -> cellData.getValue().numJourProperty());
		typeJourColumn.setCellValueFactory(cellData -> cellData.getValue().typeJourProperty());

		// Clear person details.
		showJourDetails(null);

		// Listen for selection changes and show the jour details when changed.
		jourTable.getSelectionModel().selectedItemProperty().addListener(
			(observable, oldValue, newValue) -> showJourDetails(newValue));


	}




	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		jourTable.setItems(mainApp.getJourData());
	}


	/**
	 * Fills all text fields to show details about the jour.
	 * If the specified person is null, all text fields are cleared.
	 *
	 * @param jour the jour or null
	 */
	private void showJourDetails(Jour jour) {
		if (jour != null) {
			// Fill the labels with info from the jour object.
			typeJourLabel.setText(jour.getTypeJour());
			numJourLabel.setText(Integer.toString(jour.getNumJour()));

			// We need to convert the date into a String!
			dateJourLabel.setText(DateUtil.format(jour.getDateJour()));

		} else {
			// Jour is null, remove all the text.
			typeJourLabel.setText("");
			numJourLabel.setText("");
			dateJourLabel.setText("");

		}
	}





	public void handleNewJour(ActionEvent actionEvent) {
	}

	public void handleEditJour(ActionEvent actionEvent) {
	}

	public void handleDeleteJour(ActionEvent actionEvent) {
	}















}
