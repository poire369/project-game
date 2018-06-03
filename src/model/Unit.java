package model;

public class Unit {

    private UnitType unitType;

    private int cout;

    private int minPower;

    private int maxPower;

    private int attackPriority;

    private int defensePriority;

    private int move;

    public Unit(UnitType unitType, int cout, int minpPower,int maxPower, int attackPriority, int defensePriority, int move) {
        this.unitType = unitType;
        this.cout = cout;
        this.minPower = minPower;
        this.maxPower = maxPower;
        this.attackPriority = attackPriority;
        this.defensePriority = defensePriority;
        this.move=move;
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

    public int getMinPower() {
        return minPower;
    }

    public void setMinPower(int minPower) {
        this.minPower = minPower;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
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
