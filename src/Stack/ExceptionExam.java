/* < 예외처리 >
 * -정상적인 마무리를 수행하게 해주는거.
 * -try ~catch문
 * 
 * 
 */

package Stack;
import java.util.Scanner;
public class ExceptionExam extends Exception { // 상속처리해서 예외처리

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 // 예상되는 예외를 인식.
			String Num1 = sc.next();
			int num1 = Integer.parseInt(Num1);
			//Integer.parseInt : 문자열이 숫자열로 변환할 수 있다면 숫자로 정상적으로 리턴.
			System.out.println("숫자 값" + num1);
	}
}
