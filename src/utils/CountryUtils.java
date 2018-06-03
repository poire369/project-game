package utils;

import model.Country;

import java.util.List;
import java.util.stream.Collectors;

public class CountryUtils {

    private CountryUtils(){
        // nothing to do
    }

    public static Country getCountryById(List<Country> countries, int countryId){
        return countries.stream().filter(c->c.getCountryId()==countryId).collect(Collectors.toList()).get(0);
    }

    public static Country getCountryByName(List<Country> countries, String countryName){
        return countries.stream().filter(c->c.getCountryName().equals(countryName)).collect(Collectors.toList()).get(0);
    }

    public static Country getCountryByBoardViewId(List<Country> countries, String boardViewId){
        return countries.stream().filter(c->c.getBoardViewId().equals(boardViewId)).collect(Collectors.toList()).get(0);
    }


}
