package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PlayerInitController implements Initializable {

    private List<String> playersName;

    @FXML
    ChoiceBox playerCountChoiceBox;

    @FXML
    TextField player1;

    @FXML
    TextField player2;

    @FXML
    TextField player3;

    @FXML
    TextField player4;

    @FXML
    TextField player5;

    @FXML
    TextField player6;

    @FXML
    Button launchGame;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playersName = new ArrayList<>();
        playerCountChoiceBox.setItems(FXCollections.observableArrayList(
                2, 3, 4,5,6));
    }

    @FXML
    private void launchGame(ActionEvent event) throws IOException {
        this.playersName.clear();
        addPlayer(player1.getText());
        addPlayer(player2.getText());
        addPlayer(player3.getText());
        //addPlayer(player4.getText());
        //addPlayer(player5.getText());
        //addPlayer(player6.getText());
        FXMLLoader loader = new FXMLLoader();
        Parent boardGameView = loader.load(getClass().getResource("../view/Board.fxml"));
        BoardController controller = (BoardController)loader.getController();
        playersName.forEach(p->{
               System.out.println(p);
        });
        //controller.setPlayers(playersName);
        Scene boardGameScene = new Scene(boardGameView, 1295, 918);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(boardGameScene);
        window.show();

    }

    private void addPlayer(String player){
        if(player.length()>0) {
            this.playersName.add(player);
        }
    }

}
