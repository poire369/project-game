package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import model.AttackResult;
import model.Country;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AttackResultController implements Initializable {

    private AttackResult attackResult;

    @FXML
    private Label playerAttack;

    @FXML
    private Label playerDefense;

    @FXML
    private Label countryAttack;

    @FXML
    private Label countryDefense;

    @FXML
    private TableView attackTabResult;

    @FXML
    private TableView defenseTabResult;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        attackResult = new AttackResult(new Country(1,"name1",Arrays.asList(1,2,3),1,"NA"),
                new Country(1,"name2",Arrays.asList(1,2,3),1,"NA"));
        playerAttack.setText(attackResult.getAttackCountry().getPlayer().getPlayerName());
        playerDefense.setText(attackResult.getDefenseCountry().getPlayer().getPlayerName());
        countryAttack.setText(attackResult.getAttackCountry().getCountryName());
        countryDefense.setText(attackResult.getDefenseCountry().getCountryName());
        List<List<String>> attackLine = new ArrayList<>();
        attackResult.getResultAttackUnits().forEach((k,v)->{
            attackLine.add(Arrays.asList(k.getUnitType().toString(),String.valueOf(k.getScore()),v?"ok":"detruit"));
        });
        ObservableList<List<String>> attackData = FXCollections.observableArrayList(attackLine);
        attackTabResult.setItems(attackData);
    }


}
