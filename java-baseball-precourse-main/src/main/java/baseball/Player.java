package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public char[] inputNumber = new char[Computer.NUMBER_SIZE];

    public void scanInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumber = Console.readLine();
        saveInputNumber(inputNumber);
        isValidInput();
    }

    public boolean scanRestartNumber() {
        String inputNumber = Console.readLine();
        if (inputNumber.equals("1")) {
            return true;
        } else if (inputNumber.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }


    public void saveInputNumber(String inputNumber) {
        this.inputNumber = inputNumber.toCharArray();
    }

    public boolean hasDuplicateNumber() {
        if (inputNumber[0] == inputNumber[1] || inputNumber[1] == inputNumber[2] || inputNumber[0] == inputNumber[2]) {
            return true;
        }
        return false;
    }

    public boolean hasZero() {
        for (int i = 0; i < Computer.NUMBER_SIZE; i++) {
            if (inputNumber[i] == '0') {
                return true;
            }
        }
        return false;
    }

    public boolean isNumber() {
        for (char eachNumber : inputNumber) {
            if (!Character.isDigit(eachNumber)) return false;
        }
        return true;
    }

    public void isValidInput() throws IllegalArgumentException {
        if (inputNumber.length != 3 || hasDuplicateNumber() || hasZero() || !isNumber()) {
            throw new IllegalArgumentException();
        }
    }
}
