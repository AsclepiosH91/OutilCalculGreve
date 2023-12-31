package fr.net.asclepiosh.outilcalculgreve;

import fr.net.asclepiosh.outilcalculgreve.model.*;
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
import java.util.prefs.Preferences;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

	// ... AFTER THE OTHER VARIABLES ...

	/**
	 * The data as an observable list of Jours.
	 */
	private final ObservableList<JoursDeGreveOuPollution> joursDeGreveOuPollutionData = FXCollections.observableArrayList();


	/**
	 * The data of CoefJours.
	 */
	private CoefJournaliers coefJournaliersData;

	private CoefTypeForfaitUsage coefTypeForfaitUsageData;

	private CoefPartDevolue coefPartDevolueData;

	private CoefAjust coefAjustData;


	/**
	 * Constructor
	 */
	public MainApp() {

		initJourDeGreves();
		initCoefJournaliers();
		initCoefTypeForfaitUsage();
		initCoefPartDevolue();
		initCoefAjust();

	}


	/**
	 * Returns the data as an observable list of JoursDeGreveOuPollution.
	 * @return
	 */
	public ObservableList<JoursDeGreveOuPollution> getJourDeGrevesData() {
		return joursDeGreveOuPollutionData;
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

	public CoefPartDevolue getCoefPartDevolueData() {
		return coefPartDevolueData;
	}

	public CoefAjust getCoefAjustData() {
		return coefAjustData;
	}



	public void setCoefJour(final CoefJournaliers coefJournaliersData) {
		this.coefJournaliersData = coefJournaliersData;
	}

	public void setCoefTypeForfaitUsage(final CoefTypeForfaitUsage coefTypeForfaitUsageData) {
		this.coefTypeForfaitUsageData = coefTypeForfaitUsageData;
	}

	public void setCoefPartDevolue(final CoefPartDevolue coefPartDevolueData) {
		this.coefPartDevolueData = coefPartDevolueData;
	}

	public void setCoefAjust(final CoefAjust coefAjustData) {
		this.coefAjustData = coefAjustData;
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
		    loadDataFromFile(file);
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
	 * Opens a dialog to edit details for the specified joursDeGreveOuPollution. If the user
	 * clicks OK, the changes are saved into the provided joursDeGreveOuPollution object and true
	 * is returned.
	 *
	 * @param joursDeGreveOuPollution the joursDeGreveOuPollution object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showJourEditDialog(JoursDeGreveOuPollution joursDeGreveOuPollution) {

		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/JourEditDialog.fxml"));
			AnchorPane page = loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editer un jour de grève");

			SetStage(page, dialogStage);

			// Set the jour into the controller.
			JourEditDialogController controller = loader.getController();
			controller.setJourEditDialogStage(dialogStage);
			controller.setJour(joursDeGreveOuPollution);

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

			SetStage(page, dialogStage);

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


	public boolean showCoefTypeForfaitUsageEditDialog(CoefTypeForfaitUsage coefTypeForfaitUsage) {

		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/CoefTypeForfaitUsageEditDialog.fxml"));
			AnchorPane page = loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editer les coefficients des types de forfait d'usage RATP et SNCF");

			SetStage(page, dialogStage);

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




	public boolean showCoefPartDevolueEditDialog(CoefPartDevolue coefPartDevolue) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/CoefPartDevolueEditDialog.fxml"));
			AnchorPane page = loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editer la part d'évolue à la RATP et la SNCF");

			SetStage(page, dialogStage);

			// Set the coefTypeForfaitUsage into the controller.
			CoefPartDevolueEditController myController = loader.getController();
			myController.setCoefPartDevolueEditDialogStage(dialogStage);
			myController.setPartDevolue(coefPartDevolue);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return myController.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}




	public boolean showCoefAjustEditDialog(CoefAjust coefAjust) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/CoefAjustEditDialog.fxml"));
			AnchorPane page = loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editer les coefficients d'ajustement");

			SetStage(page, dialogStage);

			// Set the coefTypeForfaitUsage into the controller.
			CoefAjustEditDialogController myController = loader.getController();
			myController.setCoefAjustEditDialogStage(dialogStage);
			myController.setCoefAjust(coefAjust);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return myController.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}








	private void SetStage(AnchorPane page, Stage dialogStage) {

		Image appIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icons/RATP.svg.png")));
		dialogStage.getIcons().add(appIcon);

		dialogStage.setResizable(false);

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
	public void setFilePath(File file) {
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
	public void loadDataFromFile(File file) {

		if(file == null || !file.exists())
		{
			return;
		}

		try {
			JAXBContext context = JAXBContext.newInstance(DataWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			// Reading XML from the file and unmarshalling.
			DataWrapper myWrapper = (DataWrapper) um.unmarshal(file);

			joursDeGreveOuPollutionData.clear();
			joursDeGreveOuPollutionData.addAll(myWrapper.getJours());

			initCoefJournaliers();
			initCoefTypeForfaitUsage();
			initCoefPartDevolue();
			initCoefAjust();

			if(myWrapper.getCoefJoursData() != null) {
				coefJournaliersData = myWrapper.getCoefJoursData();
			}

			if(myWrapper.getCoefTypeForfaitUsageData() != null) {
				coefTypeForfaitUsageData = myWrapper.getCoefTypeForfaitUsageData();
			}

			if(myWrapper.getCoefPartDevolueData() != null) {
				coefPartDevolueData = myWrapper.getCoefPartDevolueData();
			}

			if(myWrapper.getCoefAjustData() != null) {
				coefAjustData = myWrapper.getCoefAjustData();
			}


			// Save the file path to the registry.
			setFilePath(file);

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
	public void saveDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(DataWrapper.class);
			Marshaller myMarshaller = context.createMarshaller();
			myMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Wrapping our jour data.
			DataWrapper myWrapper = new DataWrapper();

			myWrapper.setJours(joursDeGreveOuPollutionData);
			myWrapper.setCoefJoursData(coefJournaliersData);
			myWrapper.setCoefTypeForfaitUsageData(coefTypeForfaitUsageData);
			myWrapper.setCoefPartDevolueData(coefPartDevolueData);
			myWrapper.setCoefAjustData(coefAjustData);

			// Marshalling and saving XML to the file.
			myMarshaller.marshal(myWrapper, file);

			// Save the file path to the registry.
			setFilePath(file);

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
		joursDeGreveOuPollutionData.add(new JoursDeGreveOuPollution("Jour De Greve 1", "RATP"));
		joursDeGreveOuPollutionData.add(new JoursDeGreveOuPollution("Jour De Greve 2", "SNCF"));
		joursDeGreveOuPollutionData.add(new JoursDeGreveOuPollution("Jour De Greve 3", "RATP-SNCF"));
	}

	public void initCoefJournaliers()
	{
		// init default values
		coefJournaliersData = new CoefJournaliers();

		coefJournaliersData.setCjohvR("1.0000");
		coefJournaliersData.setCsahvR("0.8500");
		coefJournaliersData.setCdihvR("0.6000");
		coefJournaliersData.setCjovR("0.9100");
		coefJournaliersData.setCsavR("0.7400");
		coefJournaliersData.setCdivR("0.5500");

		coefJournaliersData.setCjohvS("1.0000");
		coefJournaliersData.setCsahvS("0.9600");
		coefJournaliersData.setCdihvS("0.7400");
		coefJournaliersData.setCjovS("0.9400");
		coefJournaliersData.setCsavS("0.8400");
		coefJournaliersData.setCdivS("0.6700");
	}


	public void initCoefTypeForfaitUsage() {
		// init default values
		coefTypeForfaitUsageData = new CoefTypeForfaitUsage();

		coefTypeForfaitUsageData.setcForfaitODRATP("0.3900");
		coefTypeForfaitUsageData.setcForfaitTNLRATP("0.9860");
		coefTypeForfaitUsageData.setcForfaitCourtsRATP("0.7307");
		coefTypeForfaitUsageData.setcForfait100RATP("1.0000");

		coefTypeForfaitUsageData.setcForfaitODSNCF("0.6100");
		coefTypeForfaitUsageData.setcForfaitTNLSNCF("0.0140");
		coefTypeForfaitUsageData.setcForfaitCourtsSNCF("0.2693");
		coefTypeForfaitUsageData.setcForfait0SNCF("0.0000");

	}

	public void initCoefPartDevolue() {
		// init default values
		coefPartDevolueData = new CoefPartDevolue();

		coefPartDevolueData.setcPartDevolueRATP("0.6920");
		coefPartDevolueData.setcPartDevolueSNCF("0.2550");

	}


	public void initCoefAjust() {
		// init default values
		coefAjustData = new CoefAjust();

		coefAjustData.setcArt11Ajust("0.7400");
		coefAjustData.setcCorrRDHTAjust("1.0420");
		coefAjustData.setcArtAutrRemunAjust("1.0420");

	}


}
