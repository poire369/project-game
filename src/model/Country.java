package model;

import java.util.List;

public class Country {

    int countryId;
    String countryName;
    List<Integer> adjacencyCountries;
    boolean isEmpty;
    int playerId;

    public Country(int countryId,
            String countryName,
            List<Integer> adjacencyCountries,
            boolean isEmpty,
            int playerId){
        this.countryId=countryId;
        this.countryName=countryName;
        this.adjacencyCountries = adjacencyCountries;
        this.isEmpty=isEmpty;
        this.playerId=playerId;
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

}
