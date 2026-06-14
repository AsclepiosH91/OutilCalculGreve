package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.model.CoefAjust;
import fr.net.asclepiosh.outilcalculgreve.util.StringUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CoefAjustEditDialogController {

	public TextField cArt11AdjustField;
	public TextField cCorrRDHTAdjustField;
	public TextField cArtAutrRemunAdjustField;
    public TextField cTCBBField;


    private Stage coefAjustEditDialogStage;
	private CoefAjust coefAdjustData;
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
	public void setCoefAdjustEditDialogStage(Stage coefAjustEditDialogStage) {
		this.coefAjustEditDialogStage = coefAjustEditDialogStage;
	}





	/**
	 * Sets the Coef to be edited in the dialog.
	 *
     */
	public void setCoefAjust(CoefAjust coefAjust) {

		this.coefAdjustData = coefAjust;

		cArt11AdjustField.setText(coefAjust.getcArt11Ajust());
		cCorrRDHTAdjustField.setText(coefAjust.getcCorrRDHTAjust());
		cArtAutrRemunAdjustField.setText(coefAjust.getcArtAutrRemunAjust());

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

			coefAdjustData.setcArt11Ajust(cArt11AdjustField.getText());
			coefAdjustData.setcCorrRDHTAjust(cCorrRDHTAdjustField.getText());
			coefAdjustData.setcArtAutrRemunAjust(cArtAutrRemunAdjustField.getText());

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

		if (cArt11AdjustField.getText().isBlank() || cArt11AdjustField.getText().isEmpty() || !StringUtil.isFloat(cArt11AdjustField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour l'ajustement du volet « Autres rémunérations », Article 1-1 !\n";
		if (cCorrRDHTAdjustField.getText().isBlank() || cCorrRDHTAdjustField.getText().isEmpty() || !StringUtil.isFloat(cCorrRDHTAdjustField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le correctif de RD HT Ajusté !\n";
		if (cArtAutrRemunAdjustField.getText().isBlank() || cArtAutrRemunAdjustField.getText().isEmpty() || !StringUtil.isFloat(cArtAutrRemunAdjustField.getText()))
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
