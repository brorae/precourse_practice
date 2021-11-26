package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

	public Computer computer;
	public Player player;

	public Application(Computer computer, Player player) {
		this.computer = computer;
		this.player = player;
	}

	public static void main(String[] args) {
		Computer computer = new Computer();
		Player player = new Player();
		Application application = new Application(computer,player);
		application.computer.makeRandomNumber();
		System.out.print(application.computer.randomNumber[0]);
		System.out.print(application.computer.randomNumber[1]);
		System.out.println(application.computer.randomNumber[2]);
		player.playGame();
	}
	public void countBall(Computer computer, Player player) {
		if ((player.inputNumber[0] == computer.randomNumber[1] || player.inputNumber[0] == computer.randomNumber[2]) || (player.inputNumber[1] == computer.randomNumber[0] || player.inputNumber[1] == computer.randomNumber[2]) || (player.inputNumber[2] == computer.randomNumber[0] || player.inputNumber[2] == computer.randomNumber[1])) {
			computer.addBall();
		}
	}

	public void countStrike(char[] inputNumber) {
		for (int i=0;i<Computer.NUMBER_SIZE;i++) {
			if (computer.randomNumber[i] == inputNumber[i]-'0') {
				computer.addStrike();
			}
		}
	}


}

