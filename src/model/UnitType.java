package model;

// création d'une liste (enum) unite
public enum UnitType {
    INFANTRY("INFANTRY"),
    CAVALRY("CAVALRY"),
    ARTILLERY("ARTILLERY");

    private String name;

    UnitType(String name){
        this.name=name;
    }
}
