package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.model.CoefAjust;
import fr.net.asclepiosh.outilcalculgreve.util.StringUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CoefAjustEditDialogController {

	public TextField cArt11AjustField;
	public TextField cCorrRDHTAjustField;
	public TextField cArtAutrRemunAjustField;
    public TextField cTCBBField;


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
     */
	public void setCoefAjustEditDialogStage(Stage coefAjustEditDialogStage) {
		this.coefAjustEditDialogStage = coefAjustEditDialogStage;
	}





	/**
	 * Sets the Coef to be edited in the dialog.
	 *
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
		var errorMessage = "";

		if (cArt11AjustField.getText().isBlank() || cArt11AjustField.getText().isEmpty() || !StringUtil.isFloat(cArt11AjustField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour l'ajustement du volet « Autres rémunérations », Article 1-1 !\n";
		if (cCorrRDHTAjustField.getText().isBlank() || cCorrRDHTAjustField.getText().isEmpty() || !StringUtil.isFloat(cCorrRDHTAjustField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le correctif de RD HT Ajusté !\n";
		if (cArtAutrRemunAjustField.getText().isBlank() || cArtAutrRemunAjustField.getText().isEmpty() || !StringUtil.isFloat(cArtAutrRemunAjustField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour l'ajustement de l'article 47-5, « Autres rémunérations » !\n";



		if (errorMessage.isEmpty()) {
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
