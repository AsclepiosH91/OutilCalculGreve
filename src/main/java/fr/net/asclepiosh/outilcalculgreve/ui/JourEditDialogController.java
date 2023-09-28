package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.model.JoursDeGreve;
import fr.net.asclepiosh.outilcalculgreve.model.Transporteurs;
import fr.net.asclepiosh.outilcalculgreve.model.TransporteursData;
import fr.net.asclepiosh.outilcalculgreve.util.DateUtil;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Dialog to edit details of a joursDeGreve.
 *
 * @author Nicolas Torres
 **/
public class JourEditDialogController {
	@FXML
	private TextField nomJourField;

	@FXML
	private ComboBox<Transporteurs> transportJourComboBox;

	@FXML
	private DatePicker dateJourField;

	private Stage jourEditDialogStage;
	private JoursDeGreve joursDeGreve;
	private boolean okClicked = false;



	private final ObservableList<Transporteurs> list = TransporteursData.getTransportList();


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
	public void setJourEditDialogStage(Stage jourEditDialogStage) {
		this.jourEditDialogStage = jourEditDialogStage;
	}


	/**
	 * Sets the joursDeGreve to be edited in the dialog.
	 *
	 * @param joursDeGreve
	 */
	public void setJour(JoursDeGreve joursDeGreve) {

		this.joursDeGreve = joursDeGreve;

		// Add Transporteurs data
		transportJourComboBox.setItems(list);

		int index = switch (joursDeGreve.getTransportJour()) {
			case "RATP" -> 0;
			case "SNCF" -> 1;
			case "RATP-SNCF" -> 2;
			default -> 0;
		};

		transportJourComboBox.getSelectionModel().select(index);

		nomJourField.setText(joursDeGreve.getNomJour());

		dateJourField.setValue(joursDeGreve.getDateJour());


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

			joursDeGreve.setNomJour(nomJourField.getText());
			joursDeGreve.setTransportJour(transportJourComboBox.getValue().getName());

			joursDeGreve.setDateJour(DateUtil.parse(DateUtil.format(dateJourField.getValue())));

			okClicked = true;
			jourEditDialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		jourEditDialogStage.close();
	}


	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (transportJourComboBox.getValue().getName() == null || transportJourComboBox.getValue().getName().isEmpty()) {
			errorMessage += "Ce n'est pas un transporteur valide !\n";
		}


		if (nomJourField.getText() == null || nomJourField.getText().isEmpty()) {
			errorMessage += "Ce n'est pas un nom de joursDeGreve valide !\n";
		}


		dateJourField.getValue();
		if (dateJourField.getValue().toString().isEmpty()) {
			errorMessage += "Date non valide !\n";
		} else {
			if (
				!DateUtil.validDate(DateUtil.format(dateJourField.getValue()))
			) {
				System.out.println(dateJourField.getValue().toString());
				errorMessage += "Date non valide. Utilisez le format jj/mm/aaaa !\n";
			}
		}

		if (errorMessage.isEmpty()) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.initOwner(jourEditDialogStage);
			alert.setTitle("Champs non valides");
			alert.setHeaderText("Corrigez les champs non valides !");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}

}
