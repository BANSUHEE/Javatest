package StackQueue1;

public abstract class Memory { //추상메서드
	protected int []arr; //클래스내에서만 접근이 가능하고 해당 클래스를 상속받은 하위 클래스에서도 접근이 가능한 배열이다.
	protected int top;
	
	public Memory() {
		arr = new int[5];
		top = 0;
	}
	
	public void push(int data) { //데이터 입력
		arr[top++] = data; 
	}
	
	public abstract int pop(); // 데이터 출력은 추상메서드로 각각 처리.
	
}
