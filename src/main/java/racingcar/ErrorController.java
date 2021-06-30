package racingcar;

import java.util.HashMap;
import java.util.Map;

public class ErrorController {
    static Map<ErrorCode, String> errorMap = new HashMap<>();

    static{
        errorMap.put(ErrorCode.TURNINPUTINVALID, "시도 횟수는 숫자여야 합니다.");
        errorMap.put(ErrorCode.CARNAMEINPUTINVALID, "자동차 이름은 5자 이하 영어만 가능합니다.");
    }

    public static void printError(ErrorCode errorCode){
        System.out.println("[ERROR] " + errorMap.get(errorCode));
    }

}