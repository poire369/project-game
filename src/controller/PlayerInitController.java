package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import java.util.Arrays;
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

    private List<TextField>  players;

    @FXML
    Button launchGame;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playersName = new ArrayList<>();
        playerCountChoiceBox.setItems(FXCollections.observableArrayList(
                2, 3, 4,5,6));
        playerCountChoiceBox.setValue(6);
        playerCountChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                changePlayerCount(Integer.parseInt(playerCountChoiceBox.getItems().get((Integer) number2).toString()));
            }
        });
        players = Arrays.asList(player1,player2,player3,player4,player5,player6);

    }

    /*
     * update TextFields disable property
     * according to playerCountChoiceBox value
     */
    private void changePlayerCount(int numberPlayer){
        switch (numberPlayer) {
            case 2: disablePlayerName(players.subList(2,6));
                    break;
            case 3: disablePlayerName(players.subList(3,6));
                    enablePlayerName(players.subList(2,3));
                    break;
            case 4: disablePlayerName(players.subList(4,6));
                    enablePlayerName(players.subList(2,4));
                    break;
            case 5 : disablePlayerName(players.subList(5,6));
                    enablePlayerName(players.subList(2,5));
                     break;
            case 6 : enablePlayerName(players.subList(2,6));
                     break;
        }
    }

    private void enablePlayerName(List<TextField> playersName){
        playersName.forEach(p->p.setDisable(false));
    }

    private void disablePlayerName(List<TextField> playersName){
        playersName.forEach(p->p.setDisable(true));
    }

    /*
     * action trigger when player click on Play Button
     */
    @FXML
    private void launchGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/Board.fxml"));
        loader.load();
        BoardController controller = loader.getController();
        Parent boardGameView = loader.getRoot();
        addPlayersName();
        controller.setPlayers(playersName);
        Scene boardGameScene = new Scene(boardGameView, 1295, 918);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(boardGameScene);
        window.show();

    }

    private void addPlayersName(){
        this.playersName.clear();
        for(TextField player : players) {
            if (player.isDisable()==false) {
                this.playersName.add(player.getText());
            }
        }
    }

}
