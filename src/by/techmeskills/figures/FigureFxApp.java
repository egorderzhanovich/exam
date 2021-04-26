package by.techmeskills.figures;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FigureFxApp extends Application {



    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Figures");
        Parent root = FXMLLoader.load(getClass().getResource("/view/mainScreenView.fxml"));
        window.setScene(new Scene(root,1024,600));
        window.setResizable(false);
        window.show();

    }

    public static void main(String[] args) {
        launch();

    }
}
