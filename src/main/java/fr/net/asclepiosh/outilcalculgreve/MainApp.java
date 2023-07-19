package fr.net.asclepiosh.outilcalculgreve;

import fr.net.asclepiosh.outilcalculgreve.model.CoefJour;
import fr.net.asclepiosh.outilcalculgreve.model.Jour;
import fr.net.asclepiosh.outilcalculgreve.model.JourListWrapper;
import fr.net.asclepiosh.outilcalculgreve.ui.CoefJourEditDialogController;
import fr.net.asclepiosh.outilcalculgreve.ui.JourEditDialogController;
import fr.net.asclepiosh.outilcalculgreve.ui.JourOverviewController;
import fr.net.asclepiosh.outilcalculgreve.ui.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.prefs.Preferences;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

	final Properties appProperties = new Properties();

    // ... AFTER THE OTHER VARIABLES ...

	/**
	 * The data as an observable list of Jours.
	 */
	private final ObservableList<Jour> jourData = FXCollections.observableArrayList();



	/**
	 * The data as an observable list of CoefJours.
	 */
	private final ObservableList<CoefJour> coefJourData = FXCollections.observableArrayList();


	/**
	 * Constructor
	 */
	public MainApp() {
		// Add some sample data
		jourData.add(new Jour("Jour 1", "RATP"));
		jourData.add(new Jour("Jour 2", "SNCF"));

	}

	/**
	 * Returns the data as an observable list of Jour.
	 * @return
	 */
	public ObservableList<Jour> getJourData() {
		return jourData;
	}


	/**
	 * Returns the data as an observable list of Jour.
	 * @return
	 */
	public ObservableList<CoefJour> getCoefJourData() {
		return coefJourData;
	}



    // ... THE REST OF THE CLASS ...

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }


    @Override
    public void start(Stage primaryStage) {


        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Outil de calcul grève");

        Image appIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icons/RATP.svg.png")));
        primaryStage.getIcons().add(appIcon);

        initRootLayout();

	    showJourOverview();

    }




	/**
     * Initializes the root layout and tries to load the last opened
     * person file.
     */
    public void initRootLayout() {
        try {

			// Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("views/RootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            //scene.getStylesheets().add(Objects.requireNonNull(MainApp.class.getResource("styles/cupertino-light.css")).toExternalForm());

            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

	        primaryStage.setResizable(false);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

	    // Try to load last opened person file.
	    File file = getJourFilePath();
	    if (file != null) {
		    loadJourDataFromFile(file);
	    }

    }



	/**
	 * Shows the jour overview inside the root layout.
	 */
	public void showJourOverview() {
		try {
			// Load jour overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/JourOverview.fxml"));
			AnchorPane jourOverview = loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(jourOverview);

			// Give the controller access to the main app.
			JourOverviewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Opens a dialog to edit details for the specified jour. If the user
	 * clicks OK, the changes are saved into the provided jour object and true
	 * is returned.
	 *
	 * @param jour the jour object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showJourEditDialog(Jour jour) {

		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/JourEditDialog.fxml"));
			AnchorPane page = loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editer un jour de grève");

			Image appIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icons/RATP.svg.png")));
			dialogStage.getIcons().add(appIcon);

			dialogStage.setResizable(false);


			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			JourEditDialogController controller = loader.getController();
			controller.setJourEditDialogStage(dialogStage);
			controller.setJour(jour);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}



	public boolean showCoefJourEditDialog(CoefJour coefJour) {

		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/CoefJourEditDialog.fxml"));
			AnchorPane page = loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editer les coefficients Journalier RATP et SNCF");

			Image appIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icons/RATP.svg.png")));
			dialogStage.getIcons().add(appIcon);

			dialogStage.setResizable(false);


			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the coefJour into the controller.
			CoefJourEditDialogController controller = loader.getController();
			controller.setCoefJourEditDialogStage(dialogStage);
			controller.setJour(coefJour);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}






	/**
	 * Returns the jour file preference, i.e. the file that was last opened.
	 * The preference is read from the OS specific registry. If no such
	 * preference can be found, null is returned.
	 *
	 * @return
	 */
	public File getJourFilePath() {
		Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		String filePath = prefs.get("filePath", null);

		return filePath != null ? new File(filePath) : null;
	}



	/**
	 * Sets the file path of the currently loaded file. The path is persisted in
	 * the OS specific registry.
	 *
	 * @param file the file or null to remove the path
	 */
	public void setJourFilePath(File file) {
		Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());

			// Update the stage title.
			primaryStage.setTitle("Outil Calcul Greve - " + file.getName());
		} else {
			prefs.remove("filePath");

			// Update the stage title.
			primaryStage.setTitle("Outil Calcul Grève");
		}
	}


	/**
	 * Loads jour data from the specified file. The current jour data will
	 * be replaced.
	 *
	 * @param file
	 */
	public void loadJourDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(JourListWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			// Reading XML from the file and unmarshalling.
			JourListWrapper wrapper = (JourListWrapper) um.unmarshal(file);

			jourData.clear();
			jourData.addAll(wrapper.getJours());



			// Save the file path to the registry.
			setJourFilePath(file);

		} catch (Exception e) { // catches ANY exception
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setHeaderText("Impossible de charger les données");
			alert.setContentText("Impossible de charger les données du fichier :\n" + file.getPath());

			alert.showAndWait();
		}
	}


	/**
	 * Saves the current jour data to the specified file.
	 *
	 * @param file
	 */
	public void saveJourDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(JourListWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Wrapping our jour data.
			JourListWrapper wrapper = new JourListWrapper();
			wrapper.setJours(jourData);

			// Marshalling and saving XML to the file.
			m.marshal(wrapper, file);

			// Save the file path to the registry.
			setJourFilePath(file);
		} catch (Exception e) { // catches ANY exception
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erreur");
			alert.setHeaderText("Impossible d'enregistrer les données");
			alert.setContentText("Impossible d'enregistrer les données dans le fichier :\n" + file.getPath());

			alert.showAndWait();
		}
	}


}
