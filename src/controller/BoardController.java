package controller;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javax.swing.*;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;


import model.Board;

import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    private Board board;

    //BoardModel boardModel;
    @FXML
    private GridPane country1;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        //toutes les phases d'initialisation
        board= new Board();
        board.init();
    }

    @FXML
    private void handleAction(MouseEvent event){
        System.out.println("test");
    }

}

