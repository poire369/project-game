package model;

import java.util.*;

public class AttackResult {

    private Country attackCountry;

    private Country defenseCountry;

    private List<Unit> resultAttackUnits;

    private List<Unit> resultDefenseUnits;

    public AttackResult(Country attackCountry,Country defenseCountry){
        this.attackCountry=attackCountry;
        this.defenseCountry=defenseCountry;
        resultAttackUnits = new ArrayList<>();
        resultDefenseUnits = new ArrayList<>();
    }

    public Country getAttackCountry() {
        return attackCountry;
    }

    public void setAttackCountry(Country attackCountry) {
        this.attackCountry = attackCountry;
    }

    public Country getDefenseCountry() {
        return defenseCountry;
    }

    public void setDefenseCountry(Country defenseCountry) {
        this.defenseCountry = defenseCountry;
    }

    public List<Unit> getResultAttackUnits() {
        return resultAttackUnits;
    }

    public void setResultAttackUnits(List<Unit> resultAttackUnits) {
        this.resultAttackUnits = resultAttackUnits;
    }

    public List<Unit> getResultDefenseUnits() {
        return resultDefenseUnits;
    }

    public void setResultDefenseUnits(List<Unit> resultDefenseUnits) {
        this.resultDefenseUnits = resultDefenseUnits;
    }
}
