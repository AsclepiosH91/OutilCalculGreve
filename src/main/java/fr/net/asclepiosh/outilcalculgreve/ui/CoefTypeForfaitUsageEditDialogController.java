package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.model.CoefTypeForfaitUsage;
import fr.net.asclepiosh.outilcalculgreve.util.StringUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Dialog to edit details of a jour.
 *
 * @author Nicolas Torres
 **/
public class CoefTypeForfaitUsageEditDialogController {

	@FXML
	private TextField cForfaitODRATPField;
	@FXML
	private TextField cForfaitTNLRATPField;
	@FXML
	private TextField cForfaitCourtsRATPField;
	@FXML
	private TextField cForfait100RATPField;


	@FXML
	private TextField cForfaitODSNCFField;
	@FXML
	private TextField cForfaitTNLSNCFField;
	@FXML
	private TextField cForfaitCourtsSNCFField;
	@FXML
	private TextField cForfait0SNCFField;


	private Stage coefTypeForfaitUsageEditDialogStage;
	private CoefTypeForfaitUsage coefTypeForfaitUsage;
	private boolean okClicked = false;


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
	 */
	public void setCoefTypeForfaitUsageEditDialogStage(Stage coefTypeForfaitUsageEditDialogStage) {
		this.coefTypeForfaitUsageEditDialogStage = coefTypeForfaitUsageEditDialogStage;
	}




	/**
	 * Sets the jour to be edited in the dialog.
	 *
	 */
	public void setCoefTypeForfaitUsage(CoefTypeForfaitUsage coefTypeForfaitUsage) {

		this.coefTypeForfaitUsage = coefTypeForfaitUsage;

		cForfaitODRATPField.setText(coefTypeForfaitUsage.getcForfaitODRATP());
		cForfaitTNLRATPField.setText(coefTypeForfaitUsage.getcForfaitTNLRATP());
		cForfaitCourtsRATPField.setText(coefTypeForfaitUsage.getcForfaitCourtsRATP());
		cForfait100RATPField.setText(coefTypeForfaitUsage.getcForfait100RATP());

		cForfaitODSNCFField.setText(coefTypeForfaitUsage.getcForfaitODSNCF());
		cForfaitTNLSNCFField.setText(coefTypeForfaitUsage.getcForfaitTNLSNCF());
		cForfaitCourtsSNCFField.setText(coefTypeForfaitUsage.getcForfaitCourtsSNCF());
		cForfait0SNCFField.setText(coefTypeForfaitUsage.getcForfait0SNCF());

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

			coefTypeForfaitUsage.setcForfaitODRATP(cForfaitODRATPField.getText());
			coefTypeForfaitUsage.setcForfaitTNLRATP(cForfaitTNLRATPField.getText());
			coefTypeForfaitUsage.setcForfaitCourtsRATP(cForfaitCourtsRATPField.getText());
			coefTypeForfaitUsage.setcForfait100RATP(cForfait100RATPField.getText());

			coefTypeForfaitUsage.setcForfaitODSNCF(cForfaitODSNCFField.getText());
			coefTypeForfaitUsage.setcForfaitTNLSNCF(cForfaitTNLSNCFField.getText());
			coefTypeForfaitUsage.setcForfaitCourtsSNCF(cForfaitCourtsSNCFField.getText());
			coefTypeForfaitUsage.setcForfait0SNCF(cForfait0SNCFField.getText());

			okClicked = true;
			coefTypeForfaitUsageEditDialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		coefTypeForfaitUsageEditDialogStage.close();
	}


	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (cForfaitODRATPField.getText().isBlank() || cForfaitODRATPField.getText().isEmpty() || !StringUtil.isFloat(cForfaitODRATPField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le coefficient d'usage des Forfait OD RATP !\n";
		if (cForfaitTNLRATPField.getText().isBlank() || cForfaitTNLRATPField.getText().isEmpty() || !StringUtil.isFloat(cForfaitTNLRATPField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le coefficient d'usage des Forfait T+ NL+ RATP !\n";
		if (cForfaitCourtsRATPField.getText().isBlank() || cForfaitCourtsRATPField.getText().isEmpty() || !StringUtil.isFloat(cForfaitCourtsRATPField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le coefficient d'usage des Forfait courts RATP !\n";
		if (cForfait100RATPField.getText().isBlank() || cForfait100RATPField.getText().isEmpty() || !StringUtil.isFloat(cForfait100RATPField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le coefficient d'usage des Forfait 100% RATP !\n";

		if (cForfaitODSNCFField.getText().isBlank() || cForfaitODSNCFField.getText().isEmpty() || !StringUtil.isFloat(cForfaitODSNCFField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le coefficient d'usage des Forfait OD SNCF !\n";
		if (cForfaitTNLSNCFField.getText().isBlank() || cForfaitTNLSNCFField.getText().isEmpty() || !StringUtil.isFloat(cForfaitTNLSNCFField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le coefficient d'usage des Forfait T+ NL+ SNCF !\n";
		if (cForfaitCourtsSNCFField.getText().isBlank() || cForfaitCourtsSNCFField.getText().isEmpty() || !StringUtil.isFloat(cForfaitCourtsSNCFField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le coefficient d'usage des Forfait courts SNCF !\n";
		if (cForfait0SNCFField.getText().isBlank() || cForfait0SNCFField.getText().isEmpty() || !StringUtil.isFloat(cForfait0SNCFField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le coefficient d'usage des Forfait 0% SNCF !\n";


		if (errorMessage.isEmpty()) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(coefTypeForfaitUsageEditDialogStage);
			alert.setTitle("Champs non valides");
			alert.setHeaderText("Corrigez les champs non valides !");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}



}
