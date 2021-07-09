package trivia;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestGame {

    @Test
    @DisplayName("Spieler in PenaltyBox kommt raus, würfelt eine 3")
    void test_1() {
        Game game = new Game();
        Player spieler = new Player("John");
        spieler.setInPenaltyBox(true);
        game.players.add(spieler);

        game.roll(3);

        //assertThat(g)
    }
}
