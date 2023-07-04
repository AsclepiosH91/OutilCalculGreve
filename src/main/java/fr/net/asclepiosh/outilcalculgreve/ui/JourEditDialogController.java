package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.model.Jour;
import fr.net.asclepiosh.outilcalculgreve.util.DateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * Dialog to edit details of a jour.
 *
 * @author Nicolas Torres
 **/
public class JourEditDialogController {

	@FXML
	private TextField nomJourField;


	@FXML
	private ComboBox<String> transportJourComboBox;

	@FXML
	private DatePicker dateJourField;


	private Stage dialogStage;
	private Jour jour;
	private boolean okClicked = false;


	private final ObservableList<String> transporteursData = FXCollections.observableArrayList();


	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Sets the stage of this dialog.
	 *
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}


	/**
	 * Sets the jour to be edited in the dialog.
	 *
	 * @param jour
	 */
	public void setJour(Jour jour) {

		// Add Transporteurs data
		transporteursData.addAll(Arrays.asList("RATP", "SNCF", "RATP+SNCF"));

		transportJourComboBox.setItems(transporteursData);

		this.jour = jour;

		nomJourField.setText(jour.getNomJour());


		transportJourComboBox.getSelectionModel().selectFirst();;
		dateJourField.setValue(jour.getDateJour());
		dateJourField.setPromptText("dd/mm/yyyy");
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {

		if (isInputValid()) {

			jour.setNomJour(nomJourField.getText());
			jour.setTransportJour(transportJourComboBox.getValue());

			jour.setDateJour(DateUtil.parse(DateUtil.format(dateJourField.getValue())));

			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}


	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (transportJourComboBox.getValue() == null || transportJourComboBox.getValue().length() == 0) {
			errorMessage += "Ce n'est pas un type de jour valide !\n";
		}


		if (nomJourField.getText() == null || nomJourField.getText().length() == 0) {
			errorMessage += "Ce n'est pas un nom de jour valide !\n";
		}


		dateJourField.getValue();
		if (dateJourField.getValue().toString().length() == 0) {
			errorMessage += "Date non valide !\n";
		} else {
			if (
				!DateUtil.validDate(DateUtil.format(dateJourField.getValue()))
			) {
				System.out.println(dateJourField.getValue().toString());
				errorMessage += "Date non valide. Utilisez le format jj/mm/aaaa !\n";
			}
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Champs non valides");
			alert.setHeaderText("Corrigez les champs non valides !");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}


}
