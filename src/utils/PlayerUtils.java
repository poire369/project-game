package utils;

import model.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerUtils {

    public static final List<String> PLAYERSCOLOR = Arrays.asList("yellow","blue","green","red","black","pink");

    public static Player getPlayerById(List<Player> players, int id){
        return players.stream().filter(p->p.getPlayerId()==id).collect(Collectors.toList()).get(0);
    }
}
