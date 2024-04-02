package Inheritance;

public class MyStack extends Memory{
	public MyStack() {
		
	}

	@Override
	public void pop() {
	if(getSize() >0) {
		super.myPrint(getSize() -1); //배열에 담긴 데이터 사이즈를 반환. -> 가장 마지막에 넣은 데이터 출력
		super.setArr(getSize() -1, 0);// 입력한 인덱스에 해당하는 메모리공간에 값을 set
			
			super.sizeRed(); //사이즈 감소 메서드
		} else {
			System.out.println("메모리에 데이터가 존재하지 않습니다.");
		}
	}
}
