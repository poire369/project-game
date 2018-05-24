package model;

public class Unit {

    private UnitType unitType;

    private int cout;

    private int puissance;

    private int attackPriority;

    private int defensePriority;

    public Unit(UnitType unitType, int cout, int puissance, int attackPriority, int defensePriority) {
        this.unitType = unitType;
        this.cout = cout;
        this.puissance = puissance;
        this.attackPriority = attackPriority;
        this.defensePriority = defensePriority;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public int getAttackPriority() {
        return attackPriority;
    }

    public void setAttackPriority(int attackPriority) {
        this.attackPriority = attackPriority;
    }

    public int getDefensePriority() {
        return defensePriority;
    }

    public void setDefensePriority(int defensePriority) {
        this.defensePriority = defensePriority;
    }
}
