package StackQueue1;

public class MyQueue extends Memory{ 
	//FIFI
	
	private int front; //입력받을 변수
	
	@Override
	public int pop() { //Queue pop은 FIFI 방식
		
		return arr[front++]; //POP 메서드가 실행되면 front 변수만큼 제거.
	}
}


