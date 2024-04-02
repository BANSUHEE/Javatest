package Game_ball;
import java.util.*;
/*                                           < 정돈된 수 >
 * 
 * 구상한 설계 : 1) 입력받은 숫자를 배열로 변경  2) 작은 수 정렬 3) 정렬한 수를 숫자 타입으로 변경해서 출력
 *     함 수 :  반복문 + 정렬
 */
public class Sort_Number {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //사용자로부터 숫자를 입력받는다.
        System.out.print("네 자리 숫자를 입력하세요: ");
        
        int number = scanner.nextInt();
        
        int result = getSmalNumber(number);
        
        System.out.println("가장 작은 수로 변경된 숫자: " + result);

        scanner.close();
    }

    public static int getSmalNumber(int number) { //배열로 변경하여 정렬하는 함수
        int[] digits = new int[4]; 

        // 각 자릿수를 배열에 저장
        for (int i = 3; i >= 0; i--) {
            digits[i] = number % 10; //1578을 10으로 나눈 -> 몫 : 157 나머지 : 8
            number = number/10; // 몫 : 157  number 저장 ! -> 4번 반복 
        }

        // 배열을 정렬하여 가장 작은 수가 오도록 합니다.
        Arrays.sort(digits);

        // 숫자로 변환
        int result = 0;//숫자 타입으로 변경해서 저장할 변수를 초기화
        for (int digit : digits) { // 변수에 저장된 각 자릿수를 반복문을 통해 순회
            result = result * 10 + digit; // result = 0, 0*10+digit = 첫번째 자릿수
            							  // result = 1, 1*10+digit = 첫번째 자릿수 + 두번째 자릿수
        }
        return result;
    }
}
