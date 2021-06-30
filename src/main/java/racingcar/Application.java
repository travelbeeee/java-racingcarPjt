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

    private static ArrayList<Car> makeCarList(String[] carNameList) {
        ArrayList<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    private static void playGame(ArrayList<Car> carList, String turn) {
        System.out.println("실행 결과");
        int t = Integer.parseInt(turn);
        for(int i = 0; i < t; i++){
            playTurn(carList);
        }
        printResult(carList, getMaxPosition(carList));
    }

    private static int getMaxPosition(ArrayList<Car> carList){
        int maxScore = 0;
        for (Car car : carList) {
            maxScore = Math.max(maxScore, car.getPosition());
        }
        return maxScore;
    }

    private static void printResult(ArrayList<Car> carList, int maxScore) {
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxScore){
                winners.add(car.getName());
            }
        }
        System.out.print("최종 우승자: " );
        for (int i = 0; i < winners.size(); i++){
            if(i != 0)
                System.out.print(", ");
            System.out.print(winners.get(i));
        }
    }

    private static void playTurn(ArrayList<Car> carList) {
        for (Car c : carList) {
            int goOrNot = RandomUtils.nextInt(0, 9);
            if(goOrNot >= 4)
                c.moveCar();
            c.printPosition();
        }
        System.out.println();
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
