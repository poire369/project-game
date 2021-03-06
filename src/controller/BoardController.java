package controller;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javax.swing.*;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;


import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.*;
import utils.CountryUtils;
import utils.PlayerUtils;
import utils.UnitUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class BoardController implements Initializable {

    private Board board;

    List<Pane> countryViews;

    @FXML
    private Pane NA_1;

    @FXML
    private Pane NA_2;

    @FXML
    private Pane NA_3;

    @FXML
    private Pane NA_4;

    @FXML
    private Pane NA_5;

    @FXML
    private Pane NA_6;

    @FXML
    private Pane NA_7;

    @FXML
    private Pane NA_8;

    @FXML
    private Pane NA_9;

    @FXML
    private Pane SA_1;

    @FXML
    private Pane SA_2;

    @FXML
    private Pane SA_3;

    @FXML
    private Pane SA_4;

    @FXML
    private Pane AF_1;

    @FXML
    private Pane AF_2;

    @FXML
    private Pane AF_3;

    @FXML
    private Pane AF_4;

    @FXML
    private Pane AF_5;

    @FXML
    private Pane AF_6;

    @FXML
    private Pane E_1;

    @FXML
    private Pane E_2;

    @FXML
    private Pane E_3;

    @FXML
    private Pane E_4;

    @FXML
    private Pane E_5;

    @FXML
    private Pane E_6;

    @FXML
    private Pane E_7;

    @FXML
    private Pane AU_1;

    @FXML
    private Pane AU_2;

    @FXML
    private Pane AU_3;

    @FXML
    private Pane AU_4;

    @FXML
    private Pane A_1;

    @FXML
    private Pane A_2;

    @FXML
    private Pane A_3;

    @FXML
    private Pane A_4;

    @FXML
    private Pane A_5;

    @FXML
    private Pane A_6;

    @FXML
    private Pane A_7;

    @FXML
    private Pane A_8;

    @FXML
    private Pane A_9;

    @FXML
    private Pane A_10;

    @FXML
    private Pane A_11;

    @FXML
    private Pane A_12;

    /*
     * Graphics elements for reinforce
     */

    @FXML
    private Label reinforcePlayerName;

    @FXML
    private Label reinforcePlayerUnit;

    @FXML
    private ChoiceBox reinforceCountry;

    @FXML
    private TextField reinforceNumberInfrantry;

    @FXML
    private TextField reinforceNumberCavalry;

    @FXML
    private TextField reinforceNumberArtillery;

    @FXML
    private Button reinforce;

    @FXML
    private Tab reinforceMenu;

    @FXML
    private Tab moveMenu;

    @FXML
    private Tab attackMenu;

    /*
     * Graphics elements for move
     */

    @FXML
    private ChoiceBox moveCountry1;

    @FXML
    private ChoiceBox moveCountry2;

    @FXML
    private TextField moveNumberInfrantry;

    @FXML
    private TextField moveNumberCavalry;

    @FXML
    private TextField moveNumberArtillery;

    @FXML
    private Button move;

    /*
     * Graphics elements for attack
     */

    @FXML
    private ChoiceBox attackCountry1;

    @FXML
    private ChoiceBox attackCountry2;

    @FXML
    private TextField attackNumberInfrantry;

    @FXML
    private TextField attackNumberCavalry;

    @FXML
    private TextField attackNumberArtillery;

    @FXML
    private Button attack;

    private boolean isCountryReinforce=false;

    @FXML
    private Label countArtilleryCountry;

    @FXML
    private Label countInfantryCountry;

    @FXML
    private Label countCavalryCountry;

    @FXML
    private Label playerBorderBottom;

    @FXML
    private Label playerBorderTop;

    @FXML
    private Label playerName;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        //toutes les phases d'initialisation
        this.board= new Board();
        board.init(this);
        this.countryViews=Arrays.asList(NA_1,NA_2,NA_3,NA_4,NA_5,NA_6,NA_7,NA_8,NA_9,
                SA_1,SA_2,SA_3,SA_4,
                E_1,E_2,E_3,E_4,E_5,E_6,E_7,
                AF_1,AF_2,AF_3,AF_4,AF_5,AF_6,
                AU_1,AU_2,AU_3,AU_4,
                A_1,A_2,A_3,A_4,A_5,A_6,A_7,A_8,A_9,A_10,A_11,A_12);

        attackCountry1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<? extends Object> observableValue, Object name1, Object name2) {
                Country country =CountryUtils.getCountryByName(board.getCountries(),String.valueOf(name2));
                attackCountry2.setItems(FXCollections.observableArrayList(country.getAdjacencyCountries().stream().map(c->c.getCountryName()).collect(Collectors.toList())));
            }
        });

        moveCountry1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<? extends Object> observableValue, Object name1, Object name2) {
                Country country =CountryUtils.getCountryByName(board.getCountries(),String.valueOf(name2));
                moveCountry2.setItems(FXCollections.observableArrayList(country.getAdjacencyCountries().stream().map(c->c.getCountryName()).collect(Collectors.toList())));
            }
        });
    }

    public void setPlayers(List<String> playersName){
        board.createPlayers(playersName);
        updateCountries(board.getCountries());
        initReinforce();
        updatePlayerInfo();
    }

    private void updatePlayerInfo(){
        int id = board.getCurrentPlayer().getPlayerId();
        playerBorderBottom.setStyle("-fx-background-color:"+PlayerUtils.PLAYERSCOLOR.get(id-1));
        playerBorderTop.setStyle("-fx-background-color:"+PlayerUtils.PLAYERSCOLOR.get(id-1));
        playerName.setText(board.getCurrentPlayer().getPlayerName());
    }

    private void initReinforce(){
        moveMenu.setDisable(true);
        attackMenu.setDisable(true);
        reinforceMenu.setDisable(false);
        reinforcePlayerName.setText(board.getCurrentPlayer().getPlayerName());
        reinforcePlayerUnit.setText(String.valueOf(board.getCurrentPlayer().getReinforceUnitCount()));
        reinforceCountry.setItems(FXCollections.observableArrayList(board.getCurrentPlayer().getCountries().stream().map(c->c.getCountryName()).collect(Collectors.toList())));
        reinforceNumberInfrantry.setText("");
        reinforceNumberCavalry.setText("");
        reinforceNumberArtillery.setText("");
    }

    private int playerInitCountUnit(int playerCount){
        return 40 - (playerCount-2)*5;
    }

    public Pane getCountryById(List<Pane> countries, String Id){
        return countries.stream().filter(p->p.getId().equals(Id)).collect(Collectors.toList()).get(0);
    }

    @FXML
    private void countryAction(MouseEvent event){
        String countryId = ((Pane)event.getSource()).getId();
        Country country = CountryUtils.getCountryByBoardViewId(board.getCountries(),countryId);
        countInfantryCountry.setText(String.valueOf(UnitUtils.countInfantry(country.getUnits())));
        countCavalryCountry.setText(String.valueOf(UnitUtils.countCavalry(country.getUnits())));
        countArtilleryCountry.setText(String.valueOf(UnitUtils.countArtillery(country.getUnits())));
    }

    @FXML
    private void handleAction(MouseEvent event){
        System.out.println("test");
    }

    public void updateCountries(List<Country> countries){
        countries.forEach(c->updateCountry(c));
    }

    public void updateCountry(Country country){
        Pane countryView = getCountryById(countryViews,country.getBoardViewId());
        countryView.setStyle("-fx-background-color:"+PlayerUtils.PLAYERSCOLOR.get(country.getPlayer().getPlayerId()-1));
    }

    public void updatePlayers(List<Player> players){
        players.forEach(p->updatePlayer(p));
    }

    public void updatePlayer(Player player){
        //mettre a jour les elements graphiques
    }

    @FXML
    private void reinforceAction(ActionEvent event){
        int infantryCount = Integer.parseInt(!reinforceNumberInfrantry.getText().equals("")?reinforceNumberInfrantry.getText():"0");
        int cavalryCount = Integer.parseInt(!reinforceNumberCavalry.getText().equals("")?reinforceNumberCavalry.getText():"0");
        int artilleryCount = Integer.parseInt(!reinforceNumberArtillery.getText().equals("")?reinforceNumberArtillery.getText():"0");
        String returnMessage = board.reinforce(infantryCount,cavalryCount,artilleryCount,reinforceCountry.getValue().toString());
        if(!returnMessage.equals("ok")){
            new Alert(Alert.AlertType.INFORMATION, returnMessage).showAndWait();
        }
        initReinforce();
    }

    @FXML
    private void nextPlayerAction(ActionEvent event){
        board.nextPlayer();
        updatePlayerInfo();
        if(board.getActionType()==ActionType.REINFORCE) {
            initReinforce();
        }else {
            initAttack();
        }
    }

    private void initAttack(){
        attackCountry1.setItems(FXCollections.observableArrayList(board.getCurrentPlayer().getCountries().stream().map(c->c.getCountryName()).collect(Collectors.toList())));
        moveCountry1.setItems(FXCollections.observableArrayList(board.getCurrentPlayer().getCountries().stream().map(c->c.getCountryName()).collect(Collectors.toList())));
        reinforceMenu.setDisable(true);
        moveMenu.setDisable(false);
        attackMenu.setDisable(false);
    }

    @FXML
    private void attackAction(ActionEvent event) throws IOException {
        int attackNumberInfrantryValue = !attackNumberInfrantry.getText().equals("")?Integer.valueOf(attackNumberInfrantry.getText()):0;
        int attackNumberCavalryValue = !attackNumberCavalry.getText().equals("")?Integer.valueOf(attackNumberCavalry.getText()):0;
        int attackNumberArtilleryValue = !attackNumberArtillery.getText().equals("")?Integer.valueOf(attackNumberArtillery.getText()):0;
        String isAttackOkMessage = board.isAttackOK(attackCountry1.getValue().toString()
                ,attackNumberInfrantryValue
                ,attackNumberCavalryValue
                ,attackNumberArtilleryValue
                ,attackCountry2.getValue().toString());
        if(!isAttackOkMessage.equals("OK")){
            new Alert(Alert.AlertType.INFORMATION, isAttackOkMessage).showAndWait();
        }else {
            AttackResult attackResult = board.attack(attackCountry1.getValue().toString()
                    , attackNumberInfrantryValue
                    , attackNumberCavalryValue
                    , attackNumberArtilleryValue
                    , attackCountry2.getValue().toString());
            launchAttackResultView(attackResult);
            board.updateAttack(attackResult);
            updateCountry(attackResult.getAttackCountry());
            updateCountry(attackResult.getDefenseCountry());
        }
        if(board.getPlayers().size()==1){
            new Alert(Alert.AlertType.INFORMATION, "vous avez gagnez!!!!").showAndWait();
        }

        //mettre a jour les pays qui ont attaqué
        //verifier que le joueur qui a été attaqué a toujours des unités
    }

    private void launchAttackResultView(AttackResult attackResult) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/AttackResult.fxml"));
        loader.load();
        AttackResultController controller = loader.getController();
        Parent boardGameView = loader.getRoot();
        controller.setAttackResult(attackResult);
        Scene boardGameScene = new Scene(boardGameView, 600, 473);
        Stage window = new Stage();
        window.setScene(boardGameScene);
        window.show();
    }

    @FXML
    private void moveAction(ActionEvent event){
        //condition ternaire java condition?resultat(si true):resultat(si false)
        int infantryCount = Integer.parseInt(!attackNumberInfrantry.getText().equals("")?attackNumberInfrantry.getText():"0");
        int cavalryCount = Integer.parseInt(!attackNumberCavalry.getText().equals("")?attackNumberCavalry.getText():"0");
        int artilleryCount = Integer.parseInt(!attackNumberArtillery.getText().equals("")?attackNumberArtillery.getText():"0");
    }

}

