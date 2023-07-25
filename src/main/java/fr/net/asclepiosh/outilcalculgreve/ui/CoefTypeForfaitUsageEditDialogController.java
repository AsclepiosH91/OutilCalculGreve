package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.model.CoefJournaliers;
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
	 * @param coefTypeForfaitUsageEditDialogStage
	 */
	public void setCoefJourEditDialogStage(Stage coefTypeForfaitUsageEditDialogStage) {
		this.coefTypeForfaitUsageEditDialogStage = coefTypeForfaitUsageEditDialogStage;
	}


	/**
	 * Sets the jour to be edited in the dialog.
	 *
	 * @param coefTypeForfaitUsage
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

		if (cForfaitODRATPField.getText() == null || cForfaitODRATPField.getText().length() == 0 || !StringUtil.isFloat(cForfaitODRATPField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cJohv RATP !\n";
		if (cSahvRField.getText() == null || cSahvRField.getText().length() == 0 || !StringUtil.isFloat(cSahvRField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cSahv RATP !\n";
		if (cDihvRField.getText() == null || cDihvRField.getText().length() == 0 || !StringUtil.isFloat(cDihvRField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cDihv RATP !\n";
		if (cJovRField.getText() == null || cJovRField.getText().length() == 0 || !StringUtil.isFloat(cJovRField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cJov RATP !\n";

		if (cJohvSField.getText() == null || cJohvSField.getText().length() == 0 || !StringUtil.isFloat(cJohvSField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cJohv SNCF !\n";
		if (cSahvSField.getText() == null || cSahvSField.getText().length() == 0 || !StringUtil.isFloat(cSahvSField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cSahv SNCF !\n";
		if (cDihvSField.getText() == null || cDihvSField.getText().length() == 0 || !StringUtil.isFloat(cDihvSField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cDihv SNCF !\n";
		if (cJovSField.getText() == null || cJovSField.getText().length() == 0 || !StringUtil.isFloat(cJovSField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cJov SNCF !\n";


		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(coefJourEditDialogStage);
			alert.setTitle("Champs non valides");
			alert.setHeaderText("Corrigez les champs non valides !");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}

}
