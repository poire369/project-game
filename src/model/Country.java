package model;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private int countryId;

    private String countryName;

    private List<Integer> adjacencyCountries;

    private boolean isEmpty;

    private int playerId;

    private List<Unit> units;

    private int territoryId;

    public Country(int countryId,
            String countryName,
            List<Integer> adjacencyCountries,
                   int territoryId)
    {
        this.countryId=countryId;
        this.countryName=countryName;
        this.adjacencyCountries = adjacencyCountries;
        this.territoryId=territoryId;
        this.isEmpty=true;
        this.playerId=-1;
        this.units = new ArrayList<>();
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<Integer> getAdjacencyCountries() {
        return adjacencyCountries;
    }

    public void setAdjacencyCountries(List<Integer> adjacencyCountries) {
        this.adjacencyCountries = adjacencyCountries;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public int getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(int territoryId) {
        this.territoryId = territoryId;
    }
}
