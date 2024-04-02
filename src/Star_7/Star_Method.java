package Star_7;

import java.util.Scanner;

public class Star_Method {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String answer;
		
		
		
		do {
			System.out.println("어떤 별을 만들어 볼까요? (1-6번 선택) : "); // 별 종류 선택
			int star = Star_Method.inputNum(sc); // 별 종류 입력
			switch (star) { // 별 종류에 따른 switch문
			case 1:
				Star_Method.star1();
				break;
			case 2:
				Star_Method.star2();
				break;
			case 3:
				Star_Method.star3();
				break;
			case 4:
				Star_Method.star4();
				break;
			case 5:
				Star_Method.star5();
				break;
			case 6:
				System.out.println("홀수 숫자를 입력해주세요 : ");
				int num = Star_Method.inputNum(sc); // 홀수 숫자 입력
				Star_Method.star6(num);
				break;

			}
			System.out.println("계속하겠습니까? (y/Y) : ");
			answer = Star_Method.inputString(sc);
		} while (answer.equals("Y") || answer.equals("y"));
		//equals 메서드는 객체의 내용이 같은 지를 비교한다.Object 클래스에서 상속되어
		//모든 자바 객체에서 사용할 수 있다.
		System.out.println("계산기가 종료되었습니다.");

	}

	public static int inputNum(Scanner sc) {
	//정적 메서드인 'inputNum'을 정의한다.
		return sc.nextInt();
	//nextInt 메서드(사용자로부터 (int)정수를 입력받고, 그 값을 호출해준다.
  //Scanner에서 다음으로 읽을 입력을 가져오고, 그 값을 반환한다.
	
	}

	public static String inputString(Scanner sc) {
		return sc.next();
	//next 메서드(사용자로부터 문자열 입력받고, 그 값을 호출해준다.
	//Scanner에서 다음으로 읽을 입력을 가져오고, 그 값을 반환한다.
	}

	public static void star1() {
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void star2() {
		int z = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < z; j++) {
				System.out.print("*");
			}
			System.out.println();
			z++;
		}
	}

	public static void star3() {
		int j = 0;
		int z = 0;
		for (int i = 0; i < 3; i++) {
			for (; j < (i + 1); j++) {
				for (; z < (2 - i); z++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			z = 0;
			j = 0;
			System.out.println();
		}

	}

	public static void star4() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

	public static void star5() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i <= 5 / 2) {
					if (i + j <= 5 / 2 - 1)
						System.out.print(" ");
					else if (j - i >= 5 / 2 + 1)
						System.out.print(" ");
					else
						System.out.print("*");
				} else if (i > 5 / 2) {
					if (i - j >= 5 / 2 + 1)
						System.out.print(" ");
					else if (i + j >= 5 / 2 * 3 + 1)
						System.out.print(" ");
					else
						System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	public static void star6(int 
			num) {
		if ((num % 2) == 0) {
			System.out.println("홀수 숫자를 입력해주세요. 종료합니다.");
		} else {
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					if (i <= num / 2) {
						if (i + j <= num / 2 - 1)
							System.out.print(" ");
						else if (j - i >= num / 2 + 1)
							System.out.print(" ");
						else
							System.out.print("*");
					} else if (i > num / 2) {
						if (i - j >= num / 2 + 1)
							System.out.print(" ");
						else if (i + j >= num / 2 * 3 + 1)
							System.out.print(" ");
						else
							System.out.print("*");
					}
				}
				System.out.println();
			}
		}

	}

}
