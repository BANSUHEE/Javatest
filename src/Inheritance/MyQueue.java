package Inheritance;

public class MyQueue extends Memory{ //FIFO
	public MyQueue() {
	}

	@Override
	public void pop() {
		if(getSize()>0) {
			super.myPrint(0); //가장 맨 처음 값 반환.
			queueReset();
			super.sizeRed(); // 사이즈 감소
		} else {
			System.out.println("메모리에 데이터가 없습니다.");
		}		
	}
	
	//메서드에 매개변수를 넣지 않고 호출하는 경우는 필요한 작업을 수행하고 결과를 반환하거나, 
	//단순히 어떤 동작을 수행하는 경우
	public void queueReset() {
		for(int i=0; i < getSize()-1;i++) {
			super.setArr(i,getArr(i+1)); //A[i] 에다가 A[i+1] 을 넣겠다는 의미.
			
		}
	}
}
