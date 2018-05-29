package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button buttonPlay;

    @FXML
    private void setPlayerSettings(ActionEvent event) throws IOException {

        Parent boardGameView = FXMLLoader.load(getClass().getResource("../view/PlayerInit.fxml"));
        Scene boardGameScene = new Scene(boardGameView, 600, 473);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(boardGameScene);
        window.show();

    }
}
