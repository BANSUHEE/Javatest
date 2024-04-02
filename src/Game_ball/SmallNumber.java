package Game_ball;
import java.util.Arrays;
/*                                          <작은 수 변경>
 * 
 * 구상한 설계 : 1) 1000 ~ 9999 정수를 for 반복문으로 표현 2)네 자리를 교차하기 위해 숫자타입을 배열로 변경 
 *            3) 정렬  4) 조건문을 사용하여 첫 번째가 0이면 자리 이동 
 *      함수 : 배열로 반복문과 조건문을 쓰자 ! 
 */
public class SmallNumber {

    public static void main(String[] args) {

        for (int i = 1000; i <= 9999; i++) { // 1000 ~ 9999 까지의 정수를 표현 !  
          
        	System.out.print(i);     // 정수 출력
            int[] array = getDigits(i); 
            // 매개변수 i 로 저장된 정수 값을 메소드 함수에 저장 ! return 값을 array [] 배열 저장 !
            

            // Arrays.sort 함수를 사용하여 배열 정렬
            Arrays.sort(array); 
           
            
            // 첫번째 숫자가 0이 아닌 조건 ! 
            if (array[0] == 0) { 
                for (int j = 1; j < 4; j++) { //array[0]== 0이라면, 자리이동 개시 !
                    if (array[j] != 0) { //혹시라도 배열 2번째가 0이 아니면 
                        array[0] = array[j]; //앞으로 이동 !
                        array[j] = 0; //0은 뒤로 이동 !
                        break;
                    }
                }
            }
            
            
            System.out.print("\t");
            for (int d = 0; d < 4; d++) { 
                System.out.print(array[d]); //정렬된 숫자 출력 
            }
            System.out.println(); // 한 번의 반복이 끝날 때마다 줄 바꿈
        }
    }

    // 각 자리의 숫자를 분리하여 배열에 저장하는 메서드
    private static int[] getDigits(int number) { //정수 숫자 입력 시 getDigits 메서드 만들기.
        int[] digits = new int[4];  //4개의 숫자를 담을 수 있는 변수 선언
        digits[0] = number / 1000; // 천의 자리 구하기  5487/1000 = 몫 : 5
        digits[1] = (number / 100) % 10; // 백의 자리 구하기 5487/100 = 몫 : 54 % 10 -> 나머지 : 4
        digits[2] = (number / 10) % 10; // 십의 자리 구하기 5487/10 몫 : 548 % 10 -> 나머지 : 8
        digits[3] = number % 10; // 일의 자리 구하기 5487 % 10 -> 나머지 : 7 
        return digits; // 배열 [5487] 출력 ! 
    }
}
