package fr.net.asclepiosh.outilcalculgreve;

import fr.net.asclepiosh.outilcalculgreve.model.Jour;
import fr.net.asclepiosh.outilcalculgreve.ui.JourEditDialogController;
import fr.net.asclepiosh.outilcalculgreve.ui.JourOverviewController;
import fr.net.asclepiosh.outilcalculgreve.ui.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

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
	 * Constructor
	 */
	public MainApp() {
		// Add some sample data
		jourData.add(new Jour("Jour 1", "Johv"));
		jourData.add(new Jour("Jour 2", "Johv"));

	}

	/**
	 * Returns the data as an observable list of Jour.
	 * @return
	 */
	public ObservableList<Jour> getJourData() {
		return jourData;
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
            scene.getStylesheets().add(Objects.requireNonNull(MainApp.class.getResource("styles/cupertino-light.css")).toExternalForm());

            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
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
			controller.setDialogStage(dialogStage);
			controller.setJour(jour);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}





















}
