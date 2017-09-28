package FxCardGame.UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mainStage.fxml"));
            primaryStage.setTitle("Hearts");
            primaryStage.setScene(new Scene(root, 1090, 568));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
