package racingcar;

import utils.RandomUtils;

import java.util.ArrayList;

public class Game {
    public void playGame(ArrayList<Car> carList, String turn) {
        System.out.println("실행 결과");
        int t = Integer.parseInt(turn);
        for(int i = 0; i < t; i++){
            playTurn(carList);
        }
        printResult(carList, getMaxPosition(carList));
    }

    private int getMaxPosition(ArrayList<Car> carList){
        int maxScore = 0;
        for (Car car : carList) {
            maxScore = Math.max(maxScore, car.getPosition());
        }
        return maxScore;
    }

    private void printResult(ArrayList<Car> carList, int maxScore) {
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

    private void playTurn(ArrayList<Car> carList) {
        for (Car c : carList) {
            int goOrNot = RandomUtils.nextInt(0, 9);
            if(goOrNot >= 4)
                c.moveCar();
            c.printPosition();
        }
        System.out.println();
    }
}
