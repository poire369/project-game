package model;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private int countryId;

    private String countryName;

    private List<Country> adjacencyCountries;

    private List<Integer> adjacencyCountriesId;

    private boolean isEmpty;

    private Player player;

    private List<Unit> units;

    private int territoryId;

    private String boardViewId;

    public Country(int countryId,
            String countryName,
            List<Integer> adjacencyCountriesId,
                   int territoryId,String boardViewId)
    {
        this.countryId=countryId;
        this.countryName=countryName;
        this.adjacencyCountriesId = adjacencyCountriesId;
        this.territoryId=territoryId;
        this.boardViewId=boardViewId;
        this.isEmpty=true;
        this.player=null;
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

    public List<Country> getAdjacencyCountries() {
        return adjacencyCountries;
    }

    public void setAdjacencyCountries(List<Country> adjacencyCountries) {
        this.adjacencyCountries = adjacencyCountries;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public String getBoardViewId() {
        return boardViewId;
    }

    public void setBoardViewId(String boardViewId) {
        this.boardViewId = boardViewId;
    }

    public List<Integer> getAdjacencyCountriesId() {
        return adjacencyCountriesId;
    }

    public void setAdjacencyCountriesId(List<Integer> adjacencyCountriesId) {
        this.adjacencyCountriesId = adjacencyCountriesId;
    }
}
