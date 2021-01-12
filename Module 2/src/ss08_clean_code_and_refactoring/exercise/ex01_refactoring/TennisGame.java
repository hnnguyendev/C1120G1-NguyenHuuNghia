package ss08_clean_code_and_refactoring.exercise.ex01_refactoring;

public class TennisGame {

    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String DEUCE = "Deuce";
    public static final String SUFFIX = "-All";
    public static final int MAX_SCORE = 4;
    public static final String ADVANTAGE_PLAYER1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER2 = "Advantage player2";
    public static final String WIN_FOR_PLAYER1 = "Win for player1";
    public static final String WIN_FOR_PLAYER2 = "Win for player2";


    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        int tempScore = 0;
        if (player1Score == player2Score) {
            calScore(player1Score, score);
        } else if (player1Score >= MAX_SCORE || player2Score >= MAX_SCORE) {
            int minusResult = player1Score - player2Score;
            boolean isAdvantagePlayer1 = minusResult == 1;
            boolean isAdvantagePlayer2 = minusResult == -1;
            boolean isWinPlayer = minusResult >= 2;

            if (isAdvantagePlayer1) {
                score = ADVANTAGE_PLAYER1;
            } else if (isAdvantagePlayer2) {
                score = ADVANTAGE_PLAYER2;
            } else if (isWinPlayer) {
                score = WIN_FOR_PLAYER1;
            } else {
                score = WIN_FOR_PLAYER2;
            }
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) {
                    tempScore = player1Score;
                } else {
                    score += "-";
                    tempScore = player2Score;
                }
                calTempScore(tempScore, score);
            }
        }
        return score;
    }

    public static void calScore(int playerScore, String score) {
        switch (playerScore) {
            case 0:
                score = LOVE + SUFFIX;
                break;
            case 1:
                score = FIFTEEN + SUFFIX;
                break;
            case 2:
                score = THIRTY + SUFFIX;
                break;
            case 3:
                score = FORTY + SUFFIX;
                break;
            default:
                score = DEUCE;
                break;
        }
    }

    public static void calTempScore(int tempScore, String score) {
        switch (tempScore) {
            case 0:
                score += LOVE;
                break;
            case 1:
                score += FIFTEEN;
                break;
            case 2:
                score += THIRTY;
                break;
            case 3:
                score += FORTY;
                break;
        }
    }
}
