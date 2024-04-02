package Inheritance;

import java.util.Scanner;

public class MemoryObject {
	private MyStack myStack;
	private MyQueue myQueue;
	Memory myMemory;
	Scanner sc = new Scanner (System.in);
	
	public MemoryObject() {  //queue 와 stack 메모리 자동 생성 -> 디폴트 생성자
		myStack =new MyStack();
		myQueue =new MyQueue();
	}

	public void mainDisplay() {
		System.out.println("1. 메모리 입력 2. 메모리 출력 3. 메모리 조회 4. 종료");
	}
	public void memorySelect() {
		System.out.println("어떤 메모리를 사용할까요 ?" +'\n'+"1.Stack 2.Queue");}
	
	public void dynamic(int a) {
		if(a == 1) {
			myMemory = myStack;
		} else {
			myMemory = myQueue;
		}
	}
	
	public void allView() {
		myMemory.allView();
	}
	
	
	public void input() {
		System.out.println("데이터를 입력해주세요.");
		myMemory.push(sc.nextInt());
		
		System.out.println("데이터 입력이 완료되었습니다.");
		
	}
	public void pop() {
		myMemory.pop();
		System.out.println("데이터 출력이 완료되었습니다.");
	
	}
}
