package controller;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javax.swing.*;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;


import javafx.scene.layout.Pane;
import model.Board;
import model.Country;
import model.Player;
import utils.PlayerUtils;

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


    @Override
    public void initialize(URL location, ResourceBundle resources){
        //toutes les phases d'initialisation
        board= new Board();
        board.init(this);
        countryViews=Arrays.asList(NA_1,NA_2,NA_3,NA_4,NA_5,NA_6,NA_7,NA_8,NA_9,
                SA_1,SA_2,SA_3,SA_4,
                E_1,E_2,E_3,E_4,E_5,E_6,E_7,
                AF_1,AF_2,AF_3,AF_4,AF_5,AF_6,
                AU_1,AU_2,AU_3,AU_4,
                A_1,A_2,A_3,A_4,A_5,A_6,A_7,A_8,A_9,A_10,A_11,A_12);
        //updateCountries(board.getCountries());
        //updatePlayers(board.getPlayers());
    }

    public void setPlayers(List<String> playersName){
        List<Player> players = new ArrayList<>();
        for(int idPlayer=1;idPlayer<playersName.size()+1;idPlayer++){
            players.add(new Player(idPlayer,playersName.get(idPlayer-1)));
        }
        board.setPlayers(players);
        board.getPlayers().forEach(p-> System.out.println(p.getPlayerName()));
        board.assignCountries();
        updateCountries(board.getCountries());
    }

    public Pane getCountryById(List<Pane> countries, String Id){
        return countries.stream().filter(p->p.getId().equals(Id)).collect(Collectors.toList()).get(0);
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
        countryView.setStyle("-fx-background-color:"+PlayerUtils.PLAYERSCOLOR.get(country.getPlayerId()-1));
    }

    public void updatePlayers(List<Player> players){
        players.forEach(p->updatePlayer(p));
    }

    public void updatePlayer(Player player){
        //mettre a jour les elements graphiques
    }

}

