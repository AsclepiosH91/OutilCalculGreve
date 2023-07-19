package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.model.CoefJour;
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
public class CoefJourEditDialogController {

	@FXML
	private TextField cJohvRField;
	@FXML
	private TextField cSahvRField;
	@FXML
	private TextField cDihvRField;
	@FXML
	private TextField cJovRField;
	@FXML
	private TextField cSavRField;
	@FXML
	private TextField cDivRField;

	@FXML
	private TextField cJohvSField;
	@FXML
	private TextField cSahvSField;
	@FXML
	private TextField cDihvSField;
	@FXML
	private TextField cJovSField;
	@FXML
	private TextField cSavSField;
	@FXML
	private TextField cDivSField;



	private Stage coefJourEditDialogStage;
	private CoefJour coefJour;
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
	 * @param coefJourEditDialogStage
	 */
	public void setCoefJourEditDialogStage(Stage coefJourEditDialogStage) {
		this.coefJourEditDialogStage = coefJourEditDialogStage;
	}


	/**
	 * Sets the jour to be edited in the dialog.
	 *
	 * @param coefJour
	 */
	public void setJour(CoefJour coefJour) {

		this.coefJour = coefJour;

		cJohvRField.setText(coefJour.getcJohvR());
		cSahvRField.setText(coefJour.getcSahvR());
		cDihvRField.setText(coefJour.getcDihvR());
		cJovRField.setText(coefJour.getcJovR());
		cSavRField.setText(coefJour.getcSavR());
		cDivRField.setText(coefJour.getcDivR());

		cJohvSField.setText(coefJour.getcJohvS());
		cSahvSField.setText(coefJour.getcSahvS());
		cDihvSField.setText(coefJour.getcDihvS());
		cJovSField.setText(coefJour.getcJovS());
		cSavSField.setText(coefJour.getcSavS());
		cDivSField.setText(coefJour.getcDivS());

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

			coefJour.setcJohvR(cJohvRField.getText());
			coefJour.setcSahvR(cSahvRField.getText());
			coefJour.setcDihvR(cDihvRField.getText());
			coefJour.setcJovR(cJovRField.getText());
			coefJour.setcSavR(cSavRField.getText());
			coefJour.setcDivR(cDivRField.getText());

			coefJour.setcJohvS(cJohvSField.getText());
			coefJour.setcSahvS(cSahvSField.getText());
			coefJour.setcDihvS(cDihvSField.getText());
			coefJour.setcJovS(cJovSField.getText());
			coefJour.setcSavS(cSavSField.getText());
			coefJour.setcDivS(cDivSField.getText());

			okClicked = true;
			coefJourEditDialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		coefJourEditDialogStage.close();
	}


	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (cJohvRField.getText() == null || cJohvRField.getText().length() == 0 || !StringUtil.isFloat(cJohvRField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cJohv RATP !\n";
		if (cSahvRField.getText() == null || cSahvRField.getText().length() == 0 || !StringUtil.isFloat(cSahvRField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cSahv RATP !\n";
		if (cDihvRField.getText() == null || cDihvRField.getText().length() == 0 || !StringUtil.isFloat(cDihvRField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cDihv RATP !\n";
		if (cJovRField.getText() == null || cJovRField.getText().length() == 0 || !StringUtil.isFloat(cJovRField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cJov RATP !\n";
		if (cSavRField.getText() == null || cSavRField.getText().length() == 0 || !StringUtil.isFloat(cSavRField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cSav RATP !\n";
		if (cDivRField.getText() == null || cDivRField.getText().length() == 0 || !StringUtil.isFloat(cDivRField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cDiv RATP !\n";

		if (cJohvSField.getText() == null || cJohvSField.getText().length() == 0 || !StringUtil.isFloat(cJohvSField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cJohv SNCF !\n";
		if (cSahvSField.getText() == null || cSahvSField.getText().length() == 0 || !StringUtil.isFloat(cSahvSField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cSahv SNCF !\n";
		if (cDihvSField.getText() == null || cDihvSField.getText().length() == 0 || !StringUtil.isFloat(cDihvSField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cDihv SNCF !\n";
		if (cJovSField.getText() == null || cJovSField.getText().length() == 0 || !StringUtil.isFloat(cJovSField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cJov SNCF !\n";
		if (cSavSField.getText() == null || cSavSField.getText().length() == 0 || !StringUtil.isFloat(cSavSField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cSav SNCF !\n";
		if (cDivSField.getText() == null || cDivSField.getText().length() == 0 || !StringUtil.isFloat(cDivSField.getText()))
			errorMessage += "Ce n'est pas une valeur valide pour le paramètre cDiv SNCF !\n";


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
