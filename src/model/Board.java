package model;

import utils.BoardUtils;

import java.util.List;

public class Board {

    List<Country> countries;

    List<Player> players;

    public Board(){
        //constructor
    }

    public void init(){
        BoardUtils.initCountry();
    }

}
