package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.game.exceptions.NotRegisteredException;

public class GameTest {
    Player player1 = new Player(1, "Peter", 10);
    Player player2 = new Player(2, "John", 11);
    Player player3 = new Player(3, "Tom", 8);
    Player player4 = new Player(4, "Bob", 15);
    Player player5 = new Player(5, "Patrick", 10);
    Player player6 = new Player(6, "Harry", 10);

    @Test
    public void playersWinScenario() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        Assertions.assertEquals(1, game.round("John", "Peter"));
        Assertions.assertEquals(2, game.round("Patrick", "Bob"));
    }

    @Test
    public void playersEqualsScenario() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        Assertions.assertEquals(0, game.round("Harry", "Patrick"));
        Assertions.assertEquals(0, game.round("Peter", "Patrick"));
    }

    @Test
    public void playerNotFound() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        Assertions.assertThrows(
                NotRegisteredException.class,
                () -> {
                    game.round("Somebody", "Someone");
                }
        );
    }
}
