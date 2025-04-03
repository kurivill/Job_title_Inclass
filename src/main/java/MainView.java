import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {
    @Override
    public void start(Stage primaryStage) {
        // ComboBox at the top
        ComboBox<String> languageSelector = new ComboBox<>();
        languageSelector.getItems().addAll("English", "French", "Chinese");
        languageSelector.setPromptText("Select Language");

        // ListView for displaying results
        ListView<String> listView = new ListView<>();

        // First text field with label
        Label wordLabel = new Label("Word:");
        TextField wordField = new TextField();

        // Second text field with label
        Label translationLabel = new Label("Translation:");
        TextField translationField = new TextField();

        // Button at the bottom
        Button addButton = new Button("Add/Update Translation");

        // Layout
        VBox layout = new VBox(10, languageSelector, listView, wordLabel, wordField, translationLabel, translationField, addButton);
        layout.setStyle("-fx-padding: 10;");

        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setTitle("Translation App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
