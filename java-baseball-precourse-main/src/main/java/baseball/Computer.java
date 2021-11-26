package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public static final int DIGIT = 10;
    public static final int NUMBER_SIZE = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public int[] randomNumber = new int[NUMBER_SIZE];
    public int strike;
    public int ball;

    public Computer() {
        strike = 0;
        ball = 0;
        setRandomNumber();
    }

    public void setRandomNumber() {
        for (int i = 0; i < 3; i++) {
            randomNumber[i] = 0;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void setInitial() {
        strike = 0;
        ball = 0;
    }

    public void addStrike() {
        strike++;
    }

    public void addBall() {
        ball++;
    }

    public void makeRandomNumber() {
        boolean[] isUsed = new boolean[DIGIT];
        int index = 0;
        while (index < 3) {
            int eachNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!isUsed[eachNumber]) {
                randomNumber[index] = eachNumber;
                isUsed[eachNumber] = true;
                index++;
            }
        }
    }
}
