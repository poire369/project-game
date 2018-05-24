package model;

// création d'une liste (enum) unite
public enum UnitType {
    INFANTRY("INFANTRY"),
    CAVALERY("CAVALERY"),
    ARTILLERY("ARTILLERY");

    private String name;

    UnitType(String name){
        this.name=name;
    }
}
