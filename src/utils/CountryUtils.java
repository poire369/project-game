package utils;

import model.Country;

import java.util.List;

public class CountryUtils {

    private CountryUtils(){
        // nothing to do
    }

    public static Country getCountryById(List<Country> countries, int countryId){
        for(Country country : countries){
            if(country.getCountryId()==countryId)
                return country;
        }
        return null;
    }
}
