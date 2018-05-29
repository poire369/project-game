package controller;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javax.swing.*;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;


import model.Board;
import model.Country;
import model.Player;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    private Board board;

    @FXML
    private GridPane country1;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        //toutes les phases d'initialisation
        board= new Board();
        board.init(this);
        setPlayers(Arrays.asList("p1", "p2", "p3","p4"));
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
    }

    @FXML
    private void handleAction(MouseEvent event){
        System.out.println("test");
    }

    public void updateCountries(List<Country> countries){
        countries.forEach(c->updateCountry(c));
    }

    public void updateCountry(Country country){
        //mettre a jour les elements graphiques
    }

    public void updatePlayers(List<Player> players){
        players.forEach(p->updatePlayer(p));
    }

    public void updatePlayer(Player player){
        //mettre a jour les elements graphiques
    }

}

