package fr.net.asclepiosh.outilcalculgreve;

import fr.net.asclepiosh.outilcalculgreve.ui.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

	final Properties appProperties = new Properties();

    // ... AFTER THE OTHER VARIABLES ...





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

	    //Get App properties
		//appProperties.load(this.getClass().getClassLoader().getResourceAsStream("project.properties"));
	    // Display app version, artifactID and name
		//System.out.println(appProperties.getProperty("version"));
	    //System.out.println(appProperties.getProperty("artifactId"));
	    //System.out.println(appProperties.getProperty("name"));

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Outil de calcul Grève");

        Image appIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icons/RATP.svg.png")));
        primaryStage.getIcons().add(appIcon);

        initRootLayout();

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
            scene.getStylesheets().add(Objects.requireNonNull(MainApp.class.getResource("styles/primer-light.css")).toExternalForm());

            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}
