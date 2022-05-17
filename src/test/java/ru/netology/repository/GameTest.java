package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domein.Player;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Player one = new Player(1,"Nikita", 99 );
    Player two = new Player(2, "Stas", 50);
    Player three = new Player(3, "Gena", 79);
    Player four = new Player(4, "Turbo", 40);
    Player five = new Player(5, "DushaM", 100);

    @Test
    public void searchUnRegister() {
        Game game = new Game();
        game.register(one);
        game.register(two);
        game.register(three);
        game.register(four);
        game.register(five);

        Collection<Player> expected = List.of(new Player[]{one, two, three, four, five});
        Collection<Player> actual = game.findAll();

        assertArrayEquals(new Collection[]{expected}, new Collection[]{actual});
    }

    @Test
    public void searchUnRegisterOne() {
        Game game = new Game();
        game.register(three);

        Collection<Player> expected = List.of(new Player[]{three});
        Collection<Player> actual = game.findAll();

        assertArrayEquals(new Collection[]{expected}, new Collection[]{actual});
    }

    @Test
    public void winInFirstRound() {
        Game game = new Game();
        game.register(one);
        game.register(five);

        int expected = 2;
        int actual = game.round("Nikita", "DushaM");

        assertEquals(expected, actual);
    }

    @Test
    public void winInSecondRound() {
        Game game = new Game();

        assertThrows(NotRegisterException.class, () -> {game.round("Гена", "Вася");});
    }
}