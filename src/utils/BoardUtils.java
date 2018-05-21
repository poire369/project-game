package utils;

import model.Country;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoardUtils {

    private BoardUtils(){
        //nothing to do
    }

    /*
     * param String filePath
     * return  List<Country> countries
     */
    public static List<Country> initCountry(String filePath){
        List<Country> countries = new ArrayList<>();
        try {
            InputStream inputStream = BoardUtils.class.getResourceAsStream(filePath);
            StringBuilder resultStringBuilder = new StringBuilder();
            try (BufferedReader br
                         = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    int countryId = Integer.parseInt(fields[0]);
                    String countryName = fields[1];
                    List<Integer> adjacencyCountries=Arrays.asList(fields[2].split(":")).stream().map(Integer::parseInt).collect(Collectors.toList());
                    boolean isEmpty = Boolean.getBoolean(fields[3]);
                    int playerId = Integer.parseInt(fields[4]);
                    Country tempCountry = new Country(countryId,countryName,adjacencyCountries,isEmpty,playerId);
                    countries.add(tempCountry);
                }
            }
        }catch (IOException exception){
            System.out.println("erreur initalisation des pays");
            return null;
        }

        return countries;
    }
}
