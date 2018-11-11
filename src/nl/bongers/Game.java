package nl.bongers;

public class Game {

    private final static int TOTAL_TURNS = 10;

    private int currentRoll = 0;
    private int pinsForRoll[] = new int[21];

    public void roll(int pins) {
        pinsForRoll[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int index = 0;
        return calculateScore(score, index);
    }

    private int calculateScore(int score, int index) {
        for (int turn = 0; turn < TOTAL_TURNS; turn++) {
            if (isStrike(index)) {
                score += scoreStrike(index);
                index++;
            }
            else if (isSpare(index)) {
                score += scoreSpare(index);
                index += 2;
            }
            else {
                score += scoreDefaultTurn(index);
                index += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int index) {
        return pinsForRoll[index] == 10;
    }

    private boolean isSpare(int index) {
        return scoreDefaultTurn(index) == 10;
    }

    private int scoreStrike(int index) {
        return 10 + pinsForRoll[index + 1] + pinsForRoll[index + 2];
    }

    private int scoreSpare(int index) {
        return 10 + pinsForRoll[index + 2];
    }

    private int scoreDefaultTurn(int index) {
        return pinsForRoll[index] + pinsForRoll[index + 1];
    }
}
