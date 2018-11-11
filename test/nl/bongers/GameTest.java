package nl.bongers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        this.game = new Game();
    }

    @Test
    public void testScoreAllGutter() {
        roll(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void testScoreAllOnes() {
        roll(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void testScoreDifferentPinCount() {
        game.roll(2);
        game.roll(6);
        game.roll(8);
        game.roll(9);
        roll(16, 0);
        assertEquals(25, game.score());
    }

    @Test
    public void testScoreOneSpare() {
        game.roll(6);
        game.roll(4);
        game.roll(4);
        roll(17, 0);
        assertEquals(18, game.score());
    }

    @Test
    public void testScoreOneStrike() {
        game.roll(10);
        game.roll(4);
        game.roll(4);
        roll(17, 0);
        assertEquals(26, game.score());
    }

    @Test
    public void testScoreOneStrikeAndOneSpare() {
        game.roll(10);
        game.roll(4);
        game.roll(6);
        roll(17, 0);
        assertEquals(30, game.score());
    }

    @Test
    public void testAllStrikes() {
        roll(12, 10);
        assertEquals(300, game.score());
    }

    private void roll(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }
}