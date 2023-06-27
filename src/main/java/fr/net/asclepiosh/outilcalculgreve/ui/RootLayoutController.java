package fr.net.asclepiosh.outilcalculgreve.ui;

import fr.net.asclepiosh.outilcalculgreve.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;
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


    @FXML
    private void mniNew() {

    }



    @FXML
    private void mniOpen() {

    }


	public void mniClose(ActionEvent actionEvent) {
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

		alert.showAndWait();
	}
}
