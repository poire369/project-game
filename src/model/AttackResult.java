package model;

import java.util.HashMap;
import java.util.Map;

public class AttackResult {

    private Country attackCountry;

    private Country defenseCountry;

    private Map<Unit,Boolean> resultAttackUnits;

    private Map<Unit,Boolean> resultDefenseUnits;

    public AttackResult(Country attackCountry,Country defenseCountry){
        this.attackCountry=attackCountry;
        this.defenseCountry=defenseCountry;
        resultAttackUnits = new HashMap<>();
        resultDefenseUnits = new HashMap<>();
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

    public Map<Unit, Boolean> getResultAttackUnits() {
        return resultAttackUnits;
    }

    public void setResultAttackUnits(Map<Unit, Boolean> resultAttackUnits) {
        this.resultAttackUnits = resultAttackUnits;
    }

    public Map<Unit, Boolean> getResultDefenseUnits() {
        return resultDefenseUnits;
    }

    public void setResultDefenseUnits(Map<Unit, Boolean> resultDefenseUnits) {
        this.resultDefenseUnits = resultDefenseUnits;
    }
}
