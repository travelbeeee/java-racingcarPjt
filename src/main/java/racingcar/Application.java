package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분합니다)");
        String carNames = scanner.next();
        String[] carNameList = carNames.split(",");
        if(!checkCarNameInput(carNameList)){
            ErrorController.printError(ErrorCode.CARNAMEINPUTINVALID);
            return;
        }
        System.out.println("시도할 횟수는 몇회인가요?");
        String turn = scanner.next();
        if(!checkTurnInput(turn)){
            ErrorController.printError(ErrorCode.TURNINPUTINVALID);
            return;
        }
        playGame(makeCarList(carNameList), turn);
    }


    // 숫자로 이루어진 값
    private static boolean checkTurnInput(String turn) {
        for (int i = 0; i < turn.length(); i++){
            if(!('0' <= turn.charAt(i) && turn.charAt(i) <= '9'))
                return false;
        }
        return true;
    }

    // 1 ~ 5 글자 영문자
    private static boolean checkCarNameInput(String[] carNameList) {
        for (String carName: carNameList) {
            if(!lengthCheck(carName)) return false;
            if(!isAlpha(carName)) return false;
        }
        return true;
    }

    private static boolean isAlpha(String carName) {
        for(int i = 0; i < carName.length(); i++){
            char c = carName.charAt(i);
            if( !(('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')))
                return false;
        }
        return true;
    }

    private static boolean lengthCheck(String carName) {
        return (1 <= carName.length() && carName.length() <= 5);
    }


}
