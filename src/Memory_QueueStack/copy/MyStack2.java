package Memory_QueueStack.copy;

public class MyStack2 extends Memory2 {

        public MyStack2() {
                // 디폴트 생성자.");
        }


        @Override
        public void pop() {// First in Last out (FILO)
                if (super.getSize() > 0) {
                        super.myPrint(super.getSize() - 1); // 가장 마지막에 넣은 데이터 출력
                        super.setArr(super.getSize() - 1, 0); // 빠져나간 데이터 리셋. 초기값 0 할당.


                        super.sizeRed(); // size 1감소.
                } else {
                        System.out.println("데이터가 존재하지 않습니다.");
                }
        }
}

