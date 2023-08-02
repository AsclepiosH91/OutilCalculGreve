package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.model.CoefAjust;
import fr.net.asclepiosh.outilcalculgreve.model.CoefPartDevolue;
import fr.net.asclepiosh.outilcalculgreve.util.StringUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CoefAjustEditDialogController {

	public TextField cArt11AjustField;
	public TextField cCorrRDHTAjustField;
	public TextField cArtAutrRemunAjustField;




	private Stage coefAjustEditDialogStage;
	private CoefAjust coefAjustData;
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
	 * @param coefAjustEditDialogStage
	 */
	public void setCoefAjustEditDialogStage(Stage coefAjustEditDialogStage) {
		this.coefAjustEditDialogStage = coefAjustEditDialogStage;
	}





	/**
	 * Sets the Coef to be edited in the dialog.
	 *
	 * @param coefAjust
	 */
	public void setCoefAjust(CoefAjust coefAjust) {

		this.coefAjustData = coefAjust;

		cArt11AjustField.setText(coefAjust.getcArt11Ajust());
		cCorrRDHTAjustField.setText(coefAjust.getcCorrRDHTAjust());
		cArtAutrRemunAjustField.setText(coefAjust.getcArtAutrRemunAjust());

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

			coefAjustData.setcArt11Ajust(cArt11AjustField.getText());
			coefAjustData.setcCorrRDHTAjust(cCorrRDHTAjustField.getText());
			coefAjustData.setcArtAutrRemunAjust(cArtAutrRemunAjustField.getText());

			okClicked = true;
			coefAjustEditDialogStage.close();


		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		coefAjustEditDialogStage.close();
	}





	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (cArt11AjustField.getText() == null || cArt11AjustField.getText().isEmpty() || !StringUtil.isFloat(cArt11AjustField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour l'ajustement à réaliser dans le volet « Autres rémunérations », Article 1-1 !\n";
		if (cCorrRDHTAjustField.getText() == null || cCorrRDHTAjustField.getText().isEmpty() || !StringUtil.isFloat(cCorrRDHTAjustField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour la part dévolue SNCF !\n";
		if (cArtAutrRemunAjustField.getText() == null || cArtAutrRemunAjustField.getText().isEmpty() || !StringUtil.isFloat(cArtAutrRemunAjustField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour la part dévolue SNCF !\n";



		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(coefAjustEditDialogStage);
			alert.setTitle("Champs non valides");
			alert.setHeaderText("Corrigez les champs non valides !");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}


}
