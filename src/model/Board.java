package model;

import controller.BoardController;
import utils.BoardUtils;
import utils.CountryUtils;
import utils.UnitUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private List<Country> countries;

    private List<Player> players;

    private List<Territory> territories;

    private BoardController controller;

    private int playerCount;

    private Player currentPlayer;

    private ActionType actionType;

    public Board(){
        players=new ArrayList<>();
        territories= new ArrayList<>();
        countries = new ArrayList<>();
        actionType=ActionType.REINFORCE;
    }

    public void init(BoardController controller){
        this.countries =  BoardUtils.initCountry();
        this.territories= BoardUtils.initTerritory(countries);
        this.controller=controller;
    }

    private void assignCountries(){
        List<Country> coutriesList = new ArrayList<>(countries);
        Collections.shuffle(coutriesList);
        while(!coutriesList.isEmpty()){
            players.forEach(p->{
                if(coutriesList.isEmpty())
                    return;
                Country tempCountry =coutriesList.get(0);
                p.getCountries().add(tempCountry);
                Country c = CountryUtils.getCountryById(countries,tempCountry.getCountryId());
                c.setPlayer(p);
                coutriesList.remove(tempCountry);
            });
        }
        players.forEach(p->{
            System.out.println("nom du joueur "+p.getPlayerName());
            p.getCountries().forEach(c->System.out.println(c.getCountryName()));
        });
    }

    public void createPlayers(List<String> playersName){
        playerCount = playersName.size();
        int unitStartCount = playerInitCountUnit();
        for(int idPlayer=1;idPlayer<playersName.size()+1;idPlayer++){
            players.add(new Player(idPlayer,playersName.get(idPlayer-1),unitStartCount));
        }
        currentPlayer=players.get(0);
        players.forEach(p-> System.out.println(p.getPlayerName()));
        assignCountries();
        players.forEach(p->p.setReinforceUnitCount(p.getReinforceUnitCount()-p.getCountries().size()));

    }

    private int playerInitCountUnit(){
        return 40 - (this.playerCount-2)*5;
    }

    //reinforce
    public String reinforce(int infantryCount,int cavalryCount,int artilleryCount,String countryName){
        int totalUnitCost = infantryCount+cavalryCount*3+artilleryCount*7;
        Country country = CountryUtils.getCountryByName(countries,countryName);
        if(currentPlayer.getReinforceUnitCount()<totalUnitCost){
            return "Le nombre d'unite est superieure a celui disponible";
        }
        if(country.getPlayer().getPlayerId()!=currentPlayer.getPlayerId()){
            return "Ce pays ne vous appartient pas";
        }
        for(int i=0;i<infantryCount;i++){
            Unit infantry = UnitUtils.createInfantry();
            country.getUnits().add(infantry);
            currentPlayer.setReinforceUnitCount(currentPlayer.getReinforceUnitCount()-1);
        }
        for(int i=0;i<cavalryCount;i++){
            Unit cavalry = UnitUtils.createCavalry();
            country.getUnits().add(cavalry);
            currentPlayer.setReinforceUnitCount(currentPlayer.getReinforceUnitCount()-3);
        }
        for(int i=0;i<artilleryCount;i++){
            Unit artillery = UnitUtils.createArtillery();
            country.getUnits().add(artillery);
            currentPlayer.setReinforceUnitCount(currentPlayer.getReinforceUnitCount()-7);
        }
        //System.out.println(UnitUtils.countInfantry(country.getUnits()));
        //System.out.println(UnitUtils.countCavalry(country.getUnits()));
        //System.out.println(UnitUtils.countArtillery(country.getUnits()));
        return "ok";
    }

    public void nextPlayer(){
        int playerCurrentIndice = playerCurrentIndice();
        if(playerCurrentIndice<players.size()-1){
            currentPlayer = players.get(playerCurrentIndice+1);
        }else {
            currentPlayer = players.get(0);
            if(actionType==ActionType.REINFORCE){
                actionType=ActionType.MOVE_OR_ATTACK;
            } else {
                initTour();
                actionType=ActionType.REINFORCE;
            }
        }
    }

    private void initTour(){
        players.forEach(p->p.setReinforceUnitCount(5));
    }

    private int playerCurrentIndice(){
        for(int i=0;i<players.size();i++){
            if(players.get(i)==currentPlayer){
                return i;
            }
        }
        return -1;
    }

    public String isAttackOK(String attackCountryString, int infantryCount, int cavalryCount, int artilleryCount, String attackCountry2String){
        Country attackCountry = CountryUtils.getCountryByName(countries,attackCountryString);
        Country attackCountry2 = CountryUtils.getCountryByName(countries,attackCountry2String);
        int somme = infantryCount+cavalryCount+artilleryCount;
        //verifier que la somme des 3 count est < a 3
        if(somme>3){
            return "somme des unites superieure a 3";
        }
        //verifier que la somme est strict inférieure au nombre d'unité sur le pays
        if(attackCountry.getUnits().size()<=somme){
            return "il doit vous restez au moins une unite pour attaquer";
        }

        //verifier que l'on ne s'attaque pas sois meme
        if(attackCountry.getPlayer().getPlayerId()==attackCountry2.getPlayer().getPlayerId()){
            return "vous ne pouvez pas vous attaquez vous meme";
        }

        //verifier que le pays qui attaque possede bien les unites quil faut
        if(!(UnitUtils.countInfantry(attackCountry.getUnits())>=infantryCount)){
            return "nombre d'infanteries insuffisants";
        }
        if(!(UnitUtils.countArtillery(attackCountry.getUnits())>=cavalryCount)){
            return "nombre de cavaleries insuffisants";
        }
        if(!(UnitUtils.countArtillery(attackCountry.getUnits())>=artilleryCount)){
            return "nombre d'artilleries insuffisants";
        }
        return "OK";
    }

    public AttackResult attack(String attackCountryString, int infantryCount, int cavalryCount, int artilleryCount, String defenseCountryString){
        Country attackCountry = CountryUtils.getCountryByName(countries,attackCountryString);
        Country defenseCountry = CountryUtils.getCountryByName(countries,defenseCountryString);
        List<Unit> attackUnits = new ArrayList<>();
        if(infantryCount>0) {
            List<Unit> temp = UnitUtils.getUnits(attackCountry.getUnits(), UnitType.INFANTRY);
            System.out.println(temp.size());
            attackUnits.addAll(temp.subList(0,infantryCount));
        }
        if(cavalryCount>0) {
            List<Unit> temp = UnitUtils.getUnits(attackCountry.getUnits(), UnitType.CAVALRY);
            attackUnits.addAll(temp.subList(0,infantryCount));
        }
        if(artilleryCount>0) {
            List<Unit> temp = UnitUtils.getUnits(attackCountry.getUnits(), UnitType.ARTILLERY);
            attackUnits.addAll(temp.subList(0,infantryCount));
        }
        attackUnits.forEach(u->System.out.println(u.getUnitType()));
        Attack attack  = new Attack(attackCountry,attackUnits,defenseCountry);
        AttackResult attackResult = attack.simulAttack();
        return attackResult;
    }

    public void updateAttack(AttackResult attackResult){
        Country attackCountry=attackResult.getAttackCountry();
        Country defenseCountry = attackResult.getDefenseCountry();
        List<Unit> attackUnitDestroyed = attackResult.getResultAttackUnits().stream().filter(u->u.getStatus().equals("detruit")).collect(Collectors.toList());
        List<Unit> defenseUnitDestroyed = attackResult.getResultDefenseUnits().stream().filter(u->u.getStatus().equals("detruit")).collect(Collectors.toList());
        attackUnitDestroyed.forEach(u->attackCountry.getUnits().remove(u));
        defenseUnitDestroyed.forEach(u->defenseCountry.getUnits().remove(u));
        Player attackPlayer = attackCountry.getPlayer();
        Player defensePlayer = defenseCountry.getPlayer();
        if(defenseCountry.getUnits().size()==0){
            defenseCountry.setPlayer(attackCountry.getPlayer());
            defenseCountry.setUnits(attackResult.getResultAttackUnits().stream().filter(u->u.getStatus().equals("ok")).collect(Collectors.toList()));
            defensePlayer.getCountries().remove(defenseCountry);
            attackPlayer.getCountries().add(defenseCountry);
            attackResult.getResultAttackUnits().forEach(u->attackCountry.getUnits().remove(u));
        }
        if(defensePlayer.getCountries().size()==0){
            players.remove(defensePlayer);
        }
    }

    //getter and setter

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Territory> getTerritories() {
        return territories;
    }

    public void setTerritories(List<Territory> territories) {
        this.territories = territories;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }
}
