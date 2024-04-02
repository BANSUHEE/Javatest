package Game_ball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Baby_jin {
    	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //사용자로부터 입력받기
        System.out.print("6개의 숫자를 입력하세요: ");
        String userInput = scanner.next();
        scanner.close();
        //Baby_jin 객체 생성 및 Baby_jin 여부 확인
        Baby_jin babyJin = new Baby_jin();
        if (babyJin.isBabyGin(userInput)) {
            System.out.println("Baby-gin 이 아닙니다.");
        } else {
            System.out.println("Baby-gin 입니다.");
        }
    }
    //Baby_jin 여부를 확인하는 메서드
    public boolean isBabyGin(String str) {
    	//입력된 숫자를 각 자리수로 변환하여 리스트에 저장
        ArrayList<Integer> digits = convert(str);

        // 세 개의 연속된 숫자가 있는지 확인
        for (int i = 0; i <= 3; i++) {
            if (digits.get(i) == digits.get(i + 1) && digits.get(i) == digits.get(i + 2)) {
            	//Baby_jin 조건을 만족하는 경우 해당 숫자들을 리스트에서 제거하고 true 반환
                digits.remove(i);
                digits.remove(i);
                digits.remove(i);
                return true;
            }
        }

        // 연속된 세 숫자가 아니면서 세 숫자가 모두 같은지 확인
        for (int i = 0; i <= 3; i++) {
            if (Collections.frequency(digits, digits.get(i)) >= 3) {
            	//Baby_jin 조건을 만족하는 경우 해당 숫자들을 리스트에서 제거하고 true 반환
                digits.remove(i);
                digits.remove(i);
                digits.remove(i);
                return true;
            }
        }
        // Baby_jin 조건을 만족하지 않으면 false 반환
        return false;
    }
    // 입력된 문자열을 각 자리수로 변환하여 리스트에 저장하는 메서드
    private ArrayList<Integer> convert(String str) {
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            digits.add(Character.getNumericValue(str.charAt(i)));
        }
        return digits;
    }
}
