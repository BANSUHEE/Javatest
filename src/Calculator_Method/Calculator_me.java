package Calculator_Method;

//계산기 메서드
import java.util.Scanner;

public class Calculator_me {

	// field 는 class 안에서 선언된 변수들로 지속적으로 사용되어지는 변수이다.
	private int num1; // 첫 번째 연산자
	private int num2; // 두 번째 연산자
	private String op; // 부호 연산자
	private double result; // 연산 결과

	// constructor(생성자)
	// 접근 지정자(public)로 지정.
	// 디폴트 지정자를 명시적으로 만들 경우, 숨어 있는 디폴트는 제공하지 않는다.

	public Calculator_me() {  
	}

	public Calculator_me(int n, int n2, String op1) {

		num1 = n; // 첫 번째 피연산자 초기화
		num2 = n2; // 두 번째 피연산자 초기화
		op = op1; // 연산자 초기화
	}

	// method : setter(외부에서 주는 데이터를 입력하는 함수), getter(외부에서 필드값을 얻어가는 함수)
	// 외부에서 메소드를 통해 데이터에 접근하도록 유도하는 set
	// 외부에서 객체의 데이터를 읽을 때, 필드값을 가공하고 외부로 전달하는 get

	public void setNum1(int n) {   
		// 'n'은 메서드의 매개변수로 첫 번째 피연산자 설정 메서드
		num1 = n;
	}

	public int getNum1() { //첫 번째 피연산자 반환 메서드
		return num1;
	}

	public void setNum2(int n2) { 
		// 'n2'은 메서드의 매개변수로 두 번째 피연산자 설정 메서드
		num2 = n2;
	}

	public int getNum2() { //두 번째 피연산자 반환 메서드
		return num2;
	}

	public void setOp(String op1) {
	//'op'은 메서드의 매개변수로 부호 피연산자 설정 메서드
		String op = op1;
	}

	public String getOp() { // 부호 피연산자 반환 메서드
		return op;
	}

	public double getResult() { // 연산된 결과 반환 메서드
		return result;
	}


	public void plu(int num1, int num2) { // 더하기 연산 함수
		result= num1 + num2; // 더하기 연산 수행 후 결과 저장
	// return 이라는 변수를 선언하여 저장도 가능
	}

	public void min(int num1, int num2) { // 마이너스 함수
		result= num1 - num2; // 빼기 연산 수행 후 결과 저장
	}

	public void div(int num1, int num2) { // 나눗셈 함수
		result= num1 / num2; // 나누기 연산 수행 후 결과 저장
	}

	public void mul(int num1, int num2) { // 곱셈 함수
		result= num1 * num2; // 곱하기 연산 수행 후 결과 저장
	}
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); //키보드에서 입력을 받는다.

		int n = sc.nextInt(); // 첫 번째 피연산자 입력 받기

		String op = sc.next(); // 연산자 입력 받기

		int n2 = sc.nextInt(); // 두 번째 피연산자 입력 받기

		Calculator_me calc = new Calculator_me(n, n2, op); // Java2 객체 생성하여 초기화
		//생성된 객체를 'calc' 변수에 넣는다.
		
		switch(op) { // 입력된 연산에 따라 다른 연산 수행
		case "+" :
			calc.plu(n, n2); // 더하기 연산 수행 
            break;
         case "-" :
        	 calc.min(n, n2); //빼기 연산 수행
            break;
         case "/" :
        	 calc.div(n, n2); // 나누기 연산 수행
            break;
         case "*" :
        	 calc.mul(n, n2); // 곱하기 연산 수행
            break; // 이 외에 해당되지 않은 연산이 있을 경우, 출력
         default:
            System.out.println("연산자를 잘못입력하였습니다.");
      }System.out.println(calc.getNum1() + " " + calc.getOp() + " " + 
            calc.getNum2() + "="+ calc.getResult()); 
   }
}
		
	


