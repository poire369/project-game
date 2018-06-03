package utils;

import model.Country;
import model.Territory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoardUtils {

    private static String coutriesFilePath = "../resources/countries.txt";

    private static String territoriesFilePath = "../resources/territories.txt";

    private BoardUtils(){
        //nothing to do
    }

    /*
     * param String filePath
     * return  List<Country> countries
     */
    public static List<Country> initCountry(){
        List<Country> countries = new ArrayList<>();
        try {
            InputStream inputStream = BoardUtils.class.getResourceAsStream(coutriesFilePath);
            StringBuilder resultStringBuilder = new StringBuilder();
            try (BufferedReader br
                         = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    int countryId = Integer.parseInt(fields[0]);
                    String countryName = fields[1];
                    List<Integer> adjacencyCountries=Arrays.asList(fields[2].split(":")).stream().map(Integer::parseInt).collect(Collectors.toList());
                    int territoryId = Integer.parseInt(fields[3]);
                    String boardViewId = fields[4];
                    Country tempCountry = new Country(countryId,countryName,adjacencyCountries,territoryId,boardViewId);
                    countries.add(tempCountry);
                }
            }
        }catch (IOException exception){
            System.out.println("erreur initalisation des pays");
            return null;
        }

        //countries.forEach(c->System.out.println(c.getBoardViewId()+","+c.getCountryName()));

        return countries;
    }

    /*
     * param List<Country> countries
     * return  List<Territory> territories
     */
    public static List<Territory> initTerritory(List<Country> countries){
        List<Territory> territories = new ArrayList<>();
        try {
            InputStream inputStream = BoardUtils.class.getResourceAsStream(territoriesFilePath);
            StringBuilder resultStringBuilder = new StringBuilder();
            try (BufferedReader br
                         = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    int territoryId = Integer.parseInt(fields[0]);
                    String territoryName = fields[1];
                    List<Country> territoryCountries = countries.stream().filter(c->c.getTerritoryId()==territoryId).collect(Collectors.toList());
                    Territory tempTerritory = new Territory(territoryId,territoryName,countries);
                    territories.add(tempTerritory);
                }
            }
        }catch (IOException exception){
            System.out.println("erreur initalisation des territoires");
            return null;
        }

        return territories;
    }

}
