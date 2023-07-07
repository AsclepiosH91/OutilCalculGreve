package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;


/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 *
 * @author Nicolas Torres
 */
public class RootLayoutController {


	// Reference to the main application
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


	/**
	 * Creates an empty Jour set.
	 */
	@FXML
    private void handleMniNew() {
	    mainApp.getJourData().clear();
	    mainApp.setJourFilePath(null);

    }


	/**
	 * Opens a File Chooser to let the user select a Jour set to load.
	 */
    @FXML
    private void handleMniOpen() {

	    FileChooser fileChooser = new FileChooser();

	    // Set extension filter
	    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
		    "fichiers XML (*.xml)", "*.xml");
	    fileChooser.getExtensionFilters().add(extFilter);

	    // Show save file dialog
	    File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

	    if (file != null) {
		    mainApp.loadJourDataFromFile(file);
	    }

    }


	/**
	 * Saves the file to the jour file that is currently open. If there is no
	 * open file, the "save as" dialog is shown.
	 */
	@FXML
	private void handleMniSave() {

		File jourFile = mainApp.getJourFilePath();

		if (jourFile != null) {
			mainApp.saveJourDataToFile(jourFile);
		} else {
			handleMniSaveAs();
		}

	}

	/**
	 * Opens a FileChooser to let the user select a file to save to.
	 */
	@FXML
	private void handleMniSaveAs() {

		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
			"fichiers XML (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

		if (file != null) {
			// Make sure it has the correct extension
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			mainApp.saveJourDataToFile(file);
		}

	}


	public void mniClose() {
		System.exit(0);
	}

	/**
	 * Opens an about dialog.
	 */
	@FXML
	public void mniAbout() throws IOException {

		Properties appProperties = new Properties();
		//Get App properties
		appProperties.load(this.getClass().getClassLoader().getResourceAsStream("project.properties"));

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Outil Calcul Grève");
		alert.setHeaderText("À propos de l'outil calcul grève\nVersion : "+ appProperties.getProperty("version"));
		alert.setContentText("Auteur : Nicolas Torres\nE-mail : nicolas.torres@ratp.fr");

		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(Objects.requireNonNull(MainApp.class.getResource("icons/RATP.svg.png")).toString())); // To add an icon

		alert.showAndWait();
	}
}
