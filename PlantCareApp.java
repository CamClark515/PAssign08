//File: PlantCareApp
//Class: CSCI 1302
//Author: Cameron Clark, David Camp
//Created on: 11/13/2026
//Last Modified: 11/19/2026
//Description: GUI setting with buttons and text
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class PlantCareApp extends Application {

    private String selectedPlant = "";
    private String selectedStage = "";

    private ImageView plantImage;
    private Label imageStatus;
    private Label informationLabel;

    @Override
    public void start(Stage primaryStage) {

        // Application title
        Label title = new Label("PlantCare");

        title.setStyle(
            "-fx-font-size: 30px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #285C3A;"
        );

        Label subtitle = new Label(
            "Plant Growth and Care Monitoring"
        );

        // Plant selection
        Label plantLabel = new Label("Choose Your Plant");

        plantLabel.setStyle(
            "-fx-font-size: 19px;" +
            "-fx-font-weight: bold;"
        );

        ToggleGroup plantGroup = new ToggleGroup();

        GridPane plantGrid = new GridPane();

        plantGrid.setHgap(15);
        plantGrid.setVgap(15);
        plantGrid.setAlignment(Pos.CENTER);

        String[] plants = {
            "Tomato",
            "Pepper",
            "Potato",
            "Eggplant",
            "Chili Pepper",
            "Sweet Potato"
        };

        // Create plant buttons
        for (int i = 0; i < plants.length; i++) {

            ToggleButton plantButton =
                new ToggleButton(plants[i]);

            plantButton.setToggleGroup(plantGroup);

            plantButton.setPrefSize(140, 60);

            plantButton.setStyle(
                "-fx-font-size: 15px;" +
                "-fx-background-color: #E5F0E5;" +
                "-fx-text-fill: #285C3A;" +
                "-fx-background-radius: 10;"
            );

            plantButton.setOnAction(e -> {

                selectedPlant = plantButton.getText();

                imageStatus.setText(
                    "Selected plant: " + selectedPlant
                );

            });

            plantGrid.add(
                plantButton,
                i % 2,
                i / 2
            );
        }


        // Growth stage selection
        Label stageLabel = new Label("Select Growth Stage");

        stageLabel.setStyle(
            "-fx-font-size: 19px;" +
            "-fx-font-weight: bold;"
        );

        ToggleGroup stageGroup = new ToggleGroup();

        HBox stageBox = new HBox(10);

        stageBox.setAlignment(Pos.CENTER);

        String[] stages = {
            "Seed",
            "Seedling",
            "Mature"
        };

        // Create growth stage buttons
        for (int i = 0; i < stages.length; i++) {

            ToggleButton stageButton =
                new ToggleButton(stages[i]);

            stageButton.setToggleGroup(stageGroup);

            stageButton.setPrefSize(115, 45);

            stageButton.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-background-color: #E5F0E5;" +
                "-fx-text-fill: #285C3A;" +
                "-fx-background-radius: 10;"
            );

            stageButton.setOnAction(e -> {

                selectedStage = stageButton.getText();

            });

            stageBox.getChildren().add(stageButton);
        }


        // Plant picture
        plantImage = new ImageView();

        plantImage.setFitWidth(220);
        plantImage.setFitHeight(170);
        plantImage.setPreserveRatio(true);

        imageStatus = new Label(
            "Select a plant to begin."
        );


        // Information button
        Button informationButton =
            new Button("View Plant Information");

        informationButton.setPrefSize(250, 45);

        informationButton.setStyle(
            "-fx-background-color: #285C3A;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 15px;" +
            "-fx-background-radius: 10;"
        );


        // Information display
        informationLabel = new Label(
            "Select a plant and growth stage."
        );

        informationLabel.setWrapText(true);

        informationLabel.setMaxWidth(420);

        informationLabel.setStyle(
            "-fx-font-size: 14px;" +
            "-fx-padding: 15px;" +
            "-fx-background-color: #E5F0E5;" +
            "-fx-background-radius: 10;"
        );


        // Information button action
        informationButton.setOnAction(e -> {

            if (selectedPlant.isEmpty() ||
                selectedStage.isEmpty()) {

                informationLabel.setText(
                    "Please select a plant and growth stage."
                );

                return;
            }

            // Retrieve plant from database
            Plant plant =
                PlantDatabase.getPlant(selectedPlant);

            // Retrieve growth stage information
            PlantStageInfo info =
                plant.getStageInfo(selectedStage);

            // Display plant information
            informationLabel.setText(
                "PLANT: " + plant.getName() +

                "\n\nGROWTH STAGE: " + selectedStage +

                "\n\nHYDRATION NEEDS:\n" +
                info.getHydration() +

                "\n\nSUNLIGHT:\n" +
                info.getSunlight() +

                "\n\nSOIL pH:\n" +
                info.getSoilPH() +

                "\n\nNUTRIENTS:\n" +
                info.getNutrients() +

                "\n\nCARE INSTRUCTIONS:\n" +
                info.getCareInstructions()
            );

            // Update plant picture
            updatePlantImage();

        });


        // Main layout
        VBox layout = new VBox(15);

        layout.setPadding(new Insets(25));

        layout.setAlignment(Pos.TOP_CENTER);

        layout.getChildren().addAll(
            title,
            subtitle,
            plantLabel,
            plantGrid,
            stageLabel,
            stageBox,
            plantImage,
            imageStatus,
            informationButton,
            informationLabel
        );


        // Scrollable interface
        ScrollPane scrollPane = new ScrollPane(layout);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
            ScrollPane.ScrollBarPolicy.NEVER
        );


        // Main window
        BorderPane root = new BorderPane();

        root.setCenter(scrollPane);

        Scene scene = new Scene(root, 500, 800);

        primaryStage.setTitle("PlantCare");

        primaryStage.setScene(scene);

        primaryStage.show();

    }


    // Update plant picture based on selections
    private void updatePlantImage() {

        String plantFile = selectedPlant
            .toLowerCase()
            .replace(" ", "-");

        String stageFile = selectedStage
            .toLowerCase();

        String imagePath =
            "/images/" + plantFile + "-" +
            stageFile + ".jpg";

        var imageURL = getClass().getResource(imagePath);

        if (imageURL != null) {

            Image image =
                new Image(imageURL.toExternalForm());

            plantImage.setImage(image);

            imageStatus.setText(
                selectedPlant + " - " + selectedStage
            );

        } else {

            plantImage.setImage(null);

            imageStatus.setText(
                "Picture not available: " + imagePath
            );

        }

    }


    public static void main(String[] args) {

        launch(args);

    }

}
