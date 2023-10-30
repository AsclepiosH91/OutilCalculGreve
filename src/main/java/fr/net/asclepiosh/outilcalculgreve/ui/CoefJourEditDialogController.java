package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.model.CoefJournaliers;
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
	private CoefJournaliers coefJournaliersData;
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
	 * @param coefJournaliers
	 */
	public void setCoefJournaliers(CoefJournaliers coefJournaliers) {

		this.coefJournaliersData = coefJournaliers;

		cJohvRField.setText(coefJournaliers.getCjohvR());
		cSahvRField.setText(coefJournaliers.getCsahvR());
		cDihvRField.setText(coefJournaliers.getCdihvR());
		cJovRField.setText(coefJournaliers.getCjovR());
		cSavRField.setText(coefJournaliers.getCsavR());
		cDivRField.setText(coefJournaliers.getCdivR());

		cJohvSField.setText(coefJournaliers.getCjohvS());
		cSahvSField.setText(coefJournaliers.getCsahvS());
		cDihvSField.setText(coefJournaliers.getCdihvS());
		cJovSField.setText(coefJournaliers.getCjovS());
		cSavSField.setText(coefJournaliers.getCsavS());
		cDivSField.setText(coefJournaliers.getCdivS());

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

			coefJournaliersData.setCjohvR(cJohvRField.getText());
			coefJournaliersData.setCsahvR(cSahvRField.getText());
			coefJournaliersData.setCdihvR(cDihvRField.getText());
			coefJournaliersData.setCjovR(cJovRField.getText());
			coefJournaliersData.setCsavR(cSavRField.getText());
			coefJournaliersData.setCdivR(cDivRField.getText());

			coefJournaliersData.setCjohvS(cJohvSField.getText());
			coefJournaliersData.setCsahvS(cSahvSField.getText());
			coefJournaliersData.setCdihvS(cDihvSField.getText());
			coefJournaliersData.setCjovS(cJovSField.getText());
			coefJournaliersData.setCsavS(cSavSField.getText());
			coefJournaliersData.setCdivS(cDivSField.getText());

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
