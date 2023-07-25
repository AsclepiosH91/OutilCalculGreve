package fr.net.asclepiosh.outilcalculgreve;

import fr.net.asclepiosh.outilcalculgreve.model.CoefJournaliers;
import fr.net.asclepiosh.outilcalculgreve.model.CoefTypeForfaitUsage;
import fr.net.asclepiosh.outilcalculgreve.model.JourDeGreves;
import fr.net.asclepiosh.outilcalculgreve.model.DataWrapper;
import fr.net.asclepiosh.outilcalculgreve.ui.*;
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
	private final ObservableList<JourDeGreves> jourDeGrevesData = FXCollections.observableArrayList();


	/**
	 * The data of CoefJours.
	 */
	private CoefJournaliers coefJournaliersData;

	private CoefTypeForfaitUsage coefTypeForfaitUsageData;


	/**
	 * Constructor
	 */
	public MainApp() {

		initJourDeGreves();
		initCoefJournaliers();
		initCoefTypeForfaitUsage();

	}


	/**
	 * Returns the data as an observable list of JourDeGreves.
	 * @return
	 */
	public ObservableList<JourDeGreves> getJourDeGrevesData() {
		return jourDeGrevesData;
	}

	/**
	 * Returns the data CoefJournaliers.
	 * @return
	 */
	public CoefJournaliers getCoefJournaliersData() {
		return coefJournaliersData;
	}

	public CoefTypeForfaitUsage getCoefTypeForfaitUsageData() {
		return coefTypeForfaitUsageData;
	}

	public void setCoefJour(final CoefJournaliers coefJournaliersData) {
		this.coefJournaliersData = coefJournaliersData;
	}

	public void setCoefTypeForfaitUsage(final CoefTypeForfaitUsage coefTypeForfaitUsageData) {
		this.coefTypeForfaitUsageData = coefTypeForfaitUsageData;
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

			// Set jour overview into the center of root layout.
			rootLayout.setCenter(jourOverview);

			// Give the controller access to the main app.
			JourOverviewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Opens a dialog to edit details for the specified jourDeGreves. If the user
	 * clicks OK, the changes are saved into the provided jourDeGreves object and true
	 * is returned.
	 *
	 * @param jourDeGreves the jourDeGreves object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showJourEditDialog(JourDeGreves jourDeGreves) {

		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/JourEditDialog.fxml"));
			AnchorPane page = loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editer un jourDeGreves de grève");

			SetStage(page, dialogStage, false);

			// Set the person into the controller.
			JourEditDialogController controller = loader.getController();
			controller.setJourEditDialogStage(dialogStage);
			controller.setJour(jourDeGreves);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}



	public boolean showCoefJourEditDialog(CoefJournaliers coefJournaliers) {

		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/CoefJourEditDialog.fxml"));
			AnchorPane page = loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editer les coefficients Journalier RATP et SNCF");

			SetStage(page, dialogStage, false);

			// Set the coefJournaliers into the controller.
			CoefJourEditDialogController controller = loader.getController();
			controller.setCoefJourEditDialogStage(dialogStage);
			controller.setCoefJournaliers(coefJournaliers);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}


	public boolean showCoefTypeForfaitUsageDialog(CoefTypeForfaitUsage coefTypeForfaitUsage) {

		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/CoefTypeForfaitUsageDialog.fxml"));
			AnchorPane page = loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editer les coefficients des types de forfait d'usage RATP et SNCF");

			SetStage(page, dialogStage, false);

			// Set the coefTypeForfaitUsage into the controller.
			CoefTypeForfaitUsageEditDialogController myController = loader.getController();
			myController.setCoefTypeForfaitUsageEditDialogStage(dialogStage);
			myController.setCoefTypeForfaitUsage(coefTypeForfaitUsage);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return myController.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	private void SetStage(AnchorPane page, Stage dialogStage, Boolean isResizable) {

		Image appIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icons/RATP.svg.png")));
		dialogStage.getIcons().add(appIcon);

		dialogStage.setResizable(isResizable);

		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(primaryStage);
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
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

		if(file == null || !file.exists())
		{
			return;
		}

		try {
			JAXBContext context = JAXBContext.newInstance(DataWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			// Reading XML from the file and unmarshalling.
			DataWrapper myWrapper = (DataWrapper) um.unmarshal(file);

			jourDeGrevesData.clear();
			jourDeGrevesData.addAll(myWrapper.getJours());

			initCoefJournaliers();
			if(myWrapper.getCoefJours() != null) {
				coefJournaliersData = myWrapper.getCoefJours();
			}

			// Save the file path to the registry.
			setJourFilePath(file);

		} catch (Exception e) { // catches ANY exception
			e.printStackTrace();

			Alert fileAlert = new Alert(Alert.AlertType.ERROR);
			fileAlert.setTitle("Erreur");
			fileAlert.setHeaderText("Impossible de charger les données");
			fileAlert.setContentText("Impossible de charger les données du fichier :\n" + file.getPath());

			fileAlert.showAndWait();
		}
	}



	/**
	 * Saves the current jour data to the specified file.
	 *
	 * @param file
	 */
	public void saveJourDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(DataWrapper.class);
			Marshaller myMarshaller = context.createMarshaller();
			myMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Wrapping our jour data.
			DataWrapper myWrapper = new DataWrapper();
			myWrapper.setJours(jourDeGrevesData);
			myWrapper.setCoefJours(coefJournaliersData);


			// Marshalling and saving XML to the file.
			myMarshaller.marshal(myWrapper, file);

			// Save the file path to the registry.
			setJourFilePath(file);

		} catch (Exception e) { // catches ANY exception
			e.printStackTrace();

			Alert fileAlert = new Alert(Alert.AlertType.ERROR);
			fileAlert.setTitle("Erreur");
			fileAlert.setHeaderText("Impossible d'enregistrer les données");
			fileAlert.setContentText("Impossible d'enregistrer les données dans le fichier :\n" + file.getPath());

			fileAlert.showAndWait();
		}
	}

	private void initJourDeGreves() {
		// init default values
		jourDeGrevesData.add(new JourDeGreves("Jour De Greve 1", "RATP"));
		jourDeGrevesData.add(new JourDeGreves("Jour De Greve 2", "SNCF"));
		jourDeGrevesData.add(new JourDeGreves("Jour De Greve 3", "RATP-SNCF"));
	}

	public void initCoefJournaliers()
	{
		// init default values
		coefJournaliersData = new CoefJournaliers();

		coefJournaliersData.setcJohvR("1.000");
		coefJournaliersData.setcSahvR("0.850");
		coefJournaliersData.setcDihvR("0.600");
		coefJournaliersData.setcJovR("0.910");
		coefJournaliersData.setcSavR("0.740");
		coefJournaliersData.setcDivR("0.550");

		coefJournaliersData.setcJohvS("1.000");
		coefJournaliersData.setcSahvS("0.960");
		coefJournaliersData.setcDihvS("0.740");
		coefJournaliersData.setcJovS("0.940");
		coefJournaliersData.setcSavS("0.840");
		coefJournaliersData.setcDivS("0.670");
	}


	public void initCoefTypeForfaitUsage() {
		// init default values
		coefTypeForfaitUsageData = new CoefTypeForfaitUsage();

		coefTypeForfaitUsageData.setcForfaitODRATP("1.000");
		coefTypeForfaitUsageData.setcForfaitTNLRATP("1.000");
		coefTypeForfaitUsageData.setcForfaitCourtsRATP("1.000");
		coefTypeForfaitUsageData.setcForfait100RATP("1.000");

		coefTypeForfaitUsageData.setcForfaitODSNCF("1.000");
		coefTypeForfaitUsageData.setcForfaitTNLSNCF("1.000");
		coefTypeForfaitUsageData.setcForfaitCourtsSNCF("1.000");
		coefTypeForfaitUsageData.setcForfait0SNCF("0.000");

	}
}
