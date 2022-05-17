package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domein.Player;

import javax.management.relation.RelationServiceNotRegisteredException;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
public class Game extends Player {
    Player player = new Player();
    public Collection<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void register(Player players){this.players.add(players);}

    public Collection<Player> findAll() {
        return players;
    }

    public int round (String name1, String name2) {
        int strength1 = findStrength(name1);
        int strength2 = findStrength(name2);
        if (strength1 == 0) {
            throw new NotRegisterException("Ну ничего страшного...");
        }
        if (strength2 == 0) {
            throw new NotRegisterException("Ну ничего страшного...");
        }
        if (strength1 > strength2) {
            return 1;
        }
        if (strength1 < strength2) {
            return 2;
        }
        return 0;
    }

    public int findStrength(String name) {
        for (Player player: players) {
            if (player.getName().equals(name)) {
                return player.getStrength();
            }
        }
        return  0;
    }

}