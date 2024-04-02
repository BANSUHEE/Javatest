package StackQueue1;
import java.util.Scanner;

public class MemoryExam {

	public static void main(String[] args) {
		
		MyStack ms = new MyStack(); //한개만 선언
		MyQueue mq = new MyQueue();
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("----시 작 --- ");
			System.out.println("어떤 구조로 데이터를 저장하시겠습니까 ? ");
			System.out.print("1.Stack 2.Queue 3.exit");
			int num = sc.nextInt(); //숫자 입력
			if(num == 1) {
				System.out.println("Stack 구조를 선택하였습니다.");
				while(true) {
					System.out.print("1.push(저장) 2.pop(출력) 3.back(뒤로가기)");
					int n = sc.nextInt(); //숫자 입력 
					if(n == 1) {
					System.out.print("숫자를 입력해주세요 : ");
						ms.push(sc.nextInt()); // 저장 
					}else if(n == 2) {
						System.out.println("숫자 출력 :  " + ms.pop()); //출력				
					}else break;
				} //제어문 끝 -> 다시 반복문 실행
			}else if(num == 2) {
				System.out.println("Queue 구조를 선택하였습니다.");
				
				while(true) {
				System.out.print("1.push(저장) 2.pop(출력) 3.back(뒤로가기)");
					int n = sc.nextInt(); //숫자 입력
					if(n == 1) {
				System.out.print("숫자를 입력해주세요 : ");
						mq.push(sc.nextInt());//저장
						
					}else if(n == 2) {
						System.out.println("숫자 출력 :  " + mq.pop()); //출력
					}else break;
				} //제어문 끝 -> 다시 반복문 실행
				
				
			}else System.exit(0);
		
		} while(true); 
		
	}

}


