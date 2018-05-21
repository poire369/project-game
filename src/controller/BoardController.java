package controller;

import javafx.fxml.FXML;

import java.awt.event.ActionEvent;

public class BoardController {

    public void action(ActionEvent event){
        System.out.println(event.getID());
        System.out.println(event.getActionCommand());
        System.out.println(event.getModifiers());
        System.out.println(event.paramString());
        System.out.println(event.getSource().toString());
    }

}

