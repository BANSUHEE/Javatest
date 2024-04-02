/* <재귀함수>
 *  
 * 
 */
package Do_day3;

import java.util.Scanner;

public class Recursive {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in); // 팩토리얼을 계산할 정수
	        int num = scanner.nextInt();
	        int NumResult = factorial(num);  
	     //static 메서드는 다른 클래스에서 호출할 때 클래스 이름 뒤에다가 메서드 이름을 붙여줘야 한다.
	    
	        System.out.println(num + "의 팩토리얼은 " + NumResult + "입니다.");
	    }

	    // 팩토리얼을 계산하는 메서드
	    public static int factorial(int num) {
	        if (num == 1) {
	            return 1; // 0의 팩토리얼은 1이므로 1을 반환
	        } else {
	            return num * factorial(num - 1); // n과 (n-1)의 팩토리얼을 곱하여 반환
	        } 
	    }
	}

/* factorial(5) -> 5 * factorial(4) -> 4 * factorial(3) -> 3 * factorial(2)
 * -> 2 * factorial(1) -> 결과값 1이 나온다. !!! 
 */

