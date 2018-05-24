package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    int playerId;
    String playerName;
    List<Country> countries;
    List<Territory> territories;

    public Player(int playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
        countries=new ArrayList<>();
        territories= new ArrayList<>();
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Territory> getTerritories() {
        return territories;
    }

    public void setTerritories(List<Territory> territories) {
        this.territories = territories;
    }
}
