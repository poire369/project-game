package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int playerId;

    private String playerName;

    private List<Country> countries;

    private List<Territory> territories;

    private int reinforceUnitCount;

    public Player(int playerId, String playerName, int reinforceUnitCount) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.reinforceUnitCount=reinforceUnitCount;
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

    public int getReinforceUnitCount() {
        return reinforceUnitCount;
    }

    public void setReinforceUnitCount(int reinforceUnitCount) {
        this.reinforceUnitCount = reinforceUnitCount;
    }
}
