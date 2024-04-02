package StackQueue1;

public class MyStack extends Memory{
	//FIFO 

	@Override
	public int pop() { //Stack pop은 FIFO
		
		return arr[--top];
		// push 마지막으로 입력된 배열의 숫자만큼 제거한다.
	}


}
