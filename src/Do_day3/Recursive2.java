/*        < 재귀 함수 반복문 >
 */

package Do_day3;

import java.util.Scanner;

public class Recursive2 {
	
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int num = scanner.nextInt(); //사용자로부터 입력을 받음
	int NumResult = factorial(num); //메서드 대입
	
	System.out.println(num + "팩토리얼 :" + NumResult + "입니다.");
	}
	
	public static int factorial(int num) { //각 숫자를 곱해주는 메서드
		int result = 1; //모든 숫자의 첫자리 1
		for(int i =1;i<=num;i++) { //증가되는 수만큼 곱하기
			result *= i; //첫자리 * 증가되는 수 (result = result * i)
		} 
		return result; 
	} 
}
