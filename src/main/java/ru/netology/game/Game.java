package ru.netology.game;

import ru.netology.game.exceptions.NotRegisteredException;

import java.util.ArrayList;

public class Game {

    private final ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    private Player findPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        throw new NotRegisteredException("Found no player with name '" + name + "'");
    }

    public int round(String playerName1, String playerName2) {
        int player1Strength = findPlayer(playerName1).getStrength();
        int player2Strength = findPlayer(playerName2).getStrength();
        if (player1Strength > player2Strength) {
            return 1;
        }
        if (player2Strength > player1Strength) {
            return 2;
        }
        return 0;
    }
}
