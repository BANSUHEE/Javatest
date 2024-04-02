package Stack;

import java.util.Scanner;

public class ExceptionExam2 {

	public static void main(String[] args) throws ArithmeticException, InterruptedException {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(3 / num);
		//try {
		Thread.sleep(3000);  //throws는 위임하겠다. 근데 sleep으로 인해 try ~ catch 을ㅇㅇㅇ
		//}catch(Interupted)
		System.out.println("Bye");
	}
}
