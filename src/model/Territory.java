package model;

import java.util.List;

public class Territory {

    private int territoryId;

    private String territoryName;

    private List<Country> countries;

    public Territory(int territoryId,
            String territoryName,
            List<Country> countries){
        this.territoryId=territoryId;
        this.territoryName=territoryName;
        this.countries=countries;
    }

    public int getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(int territoryId) {
        this.territoryId = territoryId;
    }

    public String getTerritoryName() {
        return territoryName;
    }

    public void setTerritoryName(String territoryName) {
        this.territoryName = territoryName;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
