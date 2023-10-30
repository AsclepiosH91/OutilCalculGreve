package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.model.CoefPartDevolue;
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
public class CoefPartDevolueEditController {

	@FXML
	private TextField cPartDevolueRATPField;
	@FXML
	private TextField cPartDevolueSNCFField;



	private Stage coefPartDevolueEditDialogStage;
	private CoefPartDevolue coefPartDevolueData;
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
	public void setCoefPartDevolueEditDialogStage(Stage coefPartDevolueEditDialogStage) {
		this.coefPartDevolueEditDialogStage = coefPartDevolueEditDialogStage;
	}


	/**
	 * Sets the jour to be edited in the dialog.
	 *
     */
	public void setPartDevolue(CoefPartDevolue coefPartDevolue) {

		this.coefPartDevolueData = coefPartDevolue;

		cPartDevolueRATPField.setText(coefPartDevolue.getcPartDevolueRATP());
		cPartDevolueSNCFField.setText(coefPartDevolue.getcPartDevolueSNCF());

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

			coefPartDevolueData.setcPartDevolueRATP(cPartDevolueRATPField.getText());
			coefPartDevolueData.setcPartDevolueSNCF(cPartDevolueSNCFField.getText());

			okClicked = true;
			coefPartDevolueEditDialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		coefPartDevolueEditDialogStage.close();
	}


	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (cPartDevolueRATPField.getText().isBlank() || cPartDevolueRATPField.getText().isEmpty() || !StringUtil.isFloat(cPartDevolueRATPField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour la part dévolue RATP !\n";
		if (cPartDevolueSNCFField.getText().isBlank() || cPartDevolueSNCFField.getText().isEmpty() || !StringUtil.isFloat(cPartDevolueSNCFField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour la part dévolue SNCF !\n";


		if (errorMessage.isEmpty()) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(coefPartDevolueEditDialogStage);
			alert.setTitle("Champs non valides");
			alert.setHeaderText("Corrigez les champs non valides !");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}

}
