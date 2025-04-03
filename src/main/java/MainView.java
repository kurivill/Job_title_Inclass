import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {
    @Override
    public void start(Stage primaryStage) {
        ComboBox<String> languageSelector = new ComboBox<>();
        languageSelector.getItems().addAll("English", "French", "Chinese");
        languageSelector.setPromptText("Select Language");

        ListView<String> listView = new ListView<>();

        Label wordLabel = new Label("Word:");
        TextField wordField = new TextField();

        Label translationLabel = new Label("Translation:");
        TextField translationField = new TextField();

        Button addButton = new Button("Add/Update Translation");

        VBox layout = new VBox(10, languageSelector, listView, wordLabel, wordField, translationLabel, translationField, addButton);
        layout.setStyle("-fx-padding: 10;");

        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setTitle("Translation App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
