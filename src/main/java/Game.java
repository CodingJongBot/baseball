public class Game {
    public String question;

    public GuessResult guess(String guessNumber) {
        assetIllegalArgument(guessNumber);
        return new GuessResult(guessNumber.equals(question), getStrikeCount(guessNumber), getBallCount(guessNumber));
    }


    private static void assetIllegalArgument(String guessNumber) {
        if (guessNumber == null) throw new IllegalArgumentException();
        if (guessNumber.length() != 3) throw new IllegalArgumentException();

        for (char number : guessNumber.toCharArray()) {
            if (number < '0' || number > '9') throw new IllegalArgumentException();
        }

        if (isDuplicateNumber(guessNumber)) throw new IllegalArgumentException();
    }

    private int getStrikeCount(String guessNumber) {
        int strikeCount = 0;
        for (int i = 0; i < guessNumber.length(); i++) {
            if (guessNumber.charAt(i) == question.charAt(i)) strikeCount++;
        }
        return strikeCount;
    }

    private int getBallCount(String guessNumber) {
        int ballCount = 0;
        for (int i =0; i < guessNumber.length();i++){
            if (guessNumber.charAt(i) == question.charAt((i+1)%3)
                    || guessNumber.charAt(i) == question.charAt((i+2)%3)
            ) ballCount++;
        }
        return ballCount;
    }

    private static boolean isDuplicateNumber(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1)
                || guessNumber.charAt(0) == guessNumber.charAt(2)
                || guessNumber.charAt(1) == guessNumber.charAt(2);
    }
}
