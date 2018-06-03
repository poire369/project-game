package utils;

import model.Unit;
import model.UnitType;

import java.util.List;
import java.util.stream.Collectors;

public class UnitUtils {

    public static int countInfantry(List<Unit> units){
        List<Unit> infantries = units.stream().filter(u->u.getUnitType()== UnitType.INFANTRY).collect(Collectors.toList());
        return infantries.size();
    }

    public static int countCavalry(List<Unit> units){
        List<Unit> cavalries = units.stream().filter(u->u.getUnitType()== UnitType.CAVALRY).collect(Collectors.toList());
        return cavalries.size();
    }

    public static int countArtillery(List<Unit> units){
        List<Unit> artilleries = units.stream().filter(u->u.getUnitType()== UnitType.ARTILLERY).collect(Collectors.toList());
        return artilleries.size();
    }

    public static Unit createInfantry(){
        return new Unit(UnitType.INFANTRY, 1, 1,6, 2, 1, 2);
    }

    public static Unit createCavalry(){
        return new Unit(UnitType.CAVALRY, 3, 2,7, 1, 3, 3);
    }

    public static Unit createArtillery(){
        return new Unit(UnitType.ARTILLERY, 7, 4,9, 3, 2, 1);
    }
}
