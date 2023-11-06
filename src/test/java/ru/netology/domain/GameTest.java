package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class GameTest {

    @Test
    public void shouldWinFirstPlayerTest() {
        Player igor = new Player(3, "Игорь", 245);
        Player vazgen = new Player(4, "Вазген", 242);
        Game game = new Game();

        game.register(igor);
        game.register(vazgen);

        int actual = game.round("Игорь", "Вазген");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayerTest() {
        Player igor = new Player(3, "Игорь", 245);
        Player vazgen = new Player(4, "Вазген", 250);
        Game game = new Game();

        game.register(igor);
        game.register(vazgen);

        int actual = game.round("Игорь", "Вазген");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDrawGameTest() {
        Player igor = new Player(3, "Игорь", 245);
        Player vazgen = new Player(4, "Вазген", 245);
        Game game = new Game();

        game.register(igor);
        game.register(vazgen);

        int actual = game.round("Игорь", "Вазген");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRegisteredFirstPlayerTest() {
        Player igor = new Player(3, "Игорь", 245);
        Player vazgen = new Player(4, "Вазген", 245);
        Game game = new Game();

        game.register(igor);
        game.register(vazgen);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Шухрад", "Вазген")
        );
    }

    @Test
    public void shouldNotRegisteredSecondPlayerTest() {
        Player igor = new Player(3, "Игорь", 245);
        Player vazgen = new Player(4, "Вазген", 245);
        Game game = new Game();

        game.register(igor);
        game.register(vazgen);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Игорь", "Шухрад")
        );
    }
}
