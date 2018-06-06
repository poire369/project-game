package controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.AttackResult;
import model.Country;
import model.Unit;
import utils.UnitUtils;

import java.net.URL;
import java.util.*;
import java.util.List;

public class AttackResultController{

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

    @FXML
    private Button close;

    private void init(){
        playerAttack.setText(attackResult.getAttackCountry().getPlayer().getPlayerName());
        playerDefense.setText(attackResult.getDefenseCountry().getPlayer().getPlayerName());
        countryAttack.setText(attackResult.getAttackCountry().getCountryName());
        countryDefense.setText(attackResult.getDefenseCountry().getCountryName());
        initAttackView(attackTabResult,true);
        initAttackView(defenseTabResult,false);
    }


    public void setAttackResult(AttackResult attackResult){
        this.attackResult=attackResult;
        init();
    }

    private void initAttackView(TableView tableView,boolean isAttack){
        final TableColumn<AttackResultRow, String> unitColumn = new TableColumn<>("Unite");
        unitColumn.setCellValueFactory(param -> {
            final AttackResultRow tab = param.getValue();
            return new SimpleStringProperty(tab.getUnite());
        });
        final TableColumn<AttackResultRow, String> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setCellValueFactory(param -> {
            final AttackResultRow tab = param.getValue();
            return new SimpleStringProperty(tab.getScore());
        });
        final TableColumn<AttackResultRow, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(param -> {
            final AttackResultRow tab = param.getValue();
            return new SimpleStringProperty(tab.getStatus());
        });
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.getColumns().setAll(unitColumn, scoreColumn, statusColumn);
        List<AttackResultRow> attackLine = new ArrayList<>();
        if (isAttack) {
            attackResult.getResultAttackUnits().forEach((v) -> {
                attackLine.add(new AttackResultRow(v.getUnitType().toString(), String.valueOf(v.getScore()), v.getStatus()));
            });
        } else {
            attackResult.getResultDefenseUnits().forEach((v) -> {
                attackLine.add(new AttackResultRow(v.getUnitType().toString(), String.valueOf(v.getScore()), v.getStatus()));
            });
        }
        tableView .getItems().setAll(attackLine);
    }

    @FXML
    public void closeAction(ActionEvent event){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

    private class AttackResultRow{
        private StringProperty Unite;

        private StringProperty Score;

        private StringProperty Status;

        public AttackResultRow(String unit,String score,String status){
            this.Unite=new SimpleStringProperty(unit);
            this.Score=new SimpleStringProperty(score);
            this.Status=new SimpleStringProperty(status);
        }

        public String getUnite() {
            return Unite.get();
        }

        public StringProperty uniteProperty() {
            return Unite;
        }

        public void setUnite(String unite) {
            this.Unite.set(unite);
        }

        public String getScore() {
            return Score.get();
        }

        public StringProperty scoreProperty() {
            return Score;
        }

        public void setScore(String score) {
            this.Score.set(score);
        }

        public String getStatus() {
            return Status.get();
        }

        public StringProperty statusProperty() {
            return Status;
        }

        public void setStatus(String status) {
            this.Status.set(status);
        }
    }


}
