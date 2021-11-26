package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public Computer computer;
    public Player player;
    public boolean continueGame = true;

    public Application(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        Application application = new Application(computer, player);
        application.computer.makeRandomNumber();
        System.out.print(application.computer.randomNumber[0]);
        System.out.print(application.computer.randomNumber[1]);
        System.out.println(application.computer.randomNumber[2]);
        while (application.continueGame) {
            application.player.scanInputNumber();
            application.countBall();
            application.countStrike();
            application.printHint();
            application.confirmThreeStrike();
            application.computer.setInitial();
            if (!application.continueGame) {
                if (application.player.scanRestartNumber()) {
                    application.continueGame = true;
                    application.computer.makeRandomNumber();
                }
            }

        }
    }

    public void countBall() {
        if (player.inputNumber[0] - '0' == computer.randomNumber[1] || player.inputNumber[0] - '0' == computer.randomNumber[2]) {
            computer.addBall();
        }
        if (player.inputNumber[1] - '0' == computer.randomNumber[0] || player.inputNumber[1] - '0' == computer.randomNumber[2]) {
            computer.addBall();
        }
        if (player.inputNumber[2] - '0' == computer.randomNumber[0] || player.inputNumber[2] - '0' == computer.randomNumber[1]) {
            computer.addBall();
        }
    }

    public void countStrike() {
        for (int i = 0; i < Computer.NUMBER_SIZE; i++) {
            if (computer.randomNumber[i] == player.inputNumber[i] - '0') {
                computer.addStrike();
            }
        }
    }

    public void printHint() {
        if (computer.ball != 0) {
            System.out.print(computer.ball + "볼 ");
        }
        if (computer.strike != 0) {
            System.out.print(computer.strike + "스트라이크");
        }
        if (computer.ball == 0 && computer.strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public void confirmThreeStrike() {
        if (computer.strike == 3) {
            continueGame = false;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

}

