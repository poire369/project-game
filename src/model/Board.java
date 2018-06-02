package model;

import controller.BoardController;
import utils.BoardUtils;
import utils.CountryUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private List<Country> countries;

    private List<Player> players;

    private List<Territory> territories;

    private BoardController controller;

    public Board(){
        players=new ArrayList<>();
        territories= new ArrayList<>();
        countries = new ArrayList<>();
        //constructor
    }

    public void init(BoardController controller){
        this.countries =  BoardUtils.initCountry();
        this.territories= BoardUtils.initTerritory(countries);
        this.controller=controller;
       // players.add(new Player(1,"p1"));
        //players.add(new Player(2,"p2"));

    }

    public void assignCountries(){
        List<Country> coutriesList = new ArrayList<>(countries);
        Collections.shuffle(coutriesList);
        while(!coutriesList.isEmpty()){
            players.forEach(p->{
                if(coutriesList.isEmpty())
                    return;
                Country tempCountry =coutriesList.get(0);
                p.getCountries().add(tempCountry);
                Country c = CountryUtils.getCountryById(countries,tempCountry.getCountryId());
                c.setPlayerId(p.getPlayerId());
                coutriesList.remove(tempCountry);
            });
        }
        players.forEach(p->{
            System.out.println("nom du joueur "+p.getPlayerName());
            p.getCountries().forEach(c->System.out.println(c.getCountryName()));
        });
    }

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
}
