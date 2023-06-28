package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.model.Jour;
import fr.net.asclepiosh.outilcalculgreve.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Dialog to edit details of a jour.
 *
 * @author Nicolas Torres
 **/
public class JourEditDialogController {

	@FXML
	private TextField numJourField;
	@FXML
	private TextField typeJourField;
	@FXML
	private TextField dateJourField;


	private Stage dialogStage;
	private Jour jour;
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
	public void setPerson(Jour jour) {
		this.jour = jour;


		numJourField.setText(jour.getNomJour());
		typeJourField.setText(jour.getTypeJour());

		dateJourField.setText(DateUtil.format(jour.getDateJour()));
		dateJourField.setPromptText("dd.mm.yyyy");
	}


	public void setJour(Jour jour) {
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
			jour.setNomJour(numJourField.getText());
			jour.setTypeJour(typeJourField.getText());

			jour.setDateJour(DateUtil.parse(dateJourField.getText()));

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

		if (typeJourField.getText() == null || typeJourField.getText().length() == 0) {
			errorMessage += "Ce n'est pas un type de jour valide !\n";
		}


		if (numJourField.getText() == null || numJourField.getText().length() == 0) {
			errorMessage += "Ce n'est pas un numéro de jour valide !\n";
		} else {
			// try to parse the number code into an int.
			try {
				Integer.parseInt(numJourField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Ce n'est pas un numéro de jour (doit être un entier) !\n";
			}
		}


		if (dateJourField.getText() == null || dateJourField.getText().length() == 0) {
			errorMessage += "Date non valide !\n";
		} else {
			if (!DateUtil.validDate(dateJourField.getText())) {
				errorMessage += "Date non valide. Utilisez le format jj.mm.aaaa !\n";
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
