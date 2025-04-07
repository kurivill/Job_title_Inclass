import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainView extends Application {
    @Override
    public void start(Stage primaryStage) {

        JobTitleController controller = new JobTitleController();
        ComboBox<String> languageSelector = new ComboBox<>();
        languageSelector.getItems().addAll("English", "French", "Chinese");
        languageSelector.setPromptText("Select Language");

        ListView<String> listView = new ListView<>();

        languageSelector.setOnAction(event -> {
            try {
                String selectedLanguage = languageSelector.getValue();

                ArrayList<String> titles = controller.getJobTitles(selectedLanguage);

                listView.getItems().clear();
                listView.getItems().addAll(titles);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });



        Label wordLabel = new Label("Word:");
        TextField wordField = new TextField();

        Label translationLabel = new Label("Translation:");
        TextField translationField = new TextField();

        Button addButton = new Button("Add/Update Translation");
        addButton.setOnAction(event -> {
            try {
                String selectedLanguage = languageSelector.getValue();
                String word = wordField.getText();
                String translation = translationField.getText();

                controller.addOrUpdateTranslation(selectedLanguage, word, translation);

                ArrayList<String> titles = controller.getJobTitles(selectedLanguage);
                listView.getItems().clear();
                listView.getItems().addAll(titles);

                wordField.clear();
                translationField.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        VBox layout = new VBox(10, languageSelector, listView, wordLabel, wordField, translationLabel, translationField, addButton);
        layout.setStyle("-fx-padding: 10;");

        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setTitle("Translation App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
