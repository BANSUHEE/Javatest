package Memory_QueueStack.copy;
public class MyQueue2 extends Memory2 {

        public MyQueue2() {
                //디폴트 생성자
        }
        
        @Override
        public void pop() {//First in First out. (FIFO)
                if (super.getSize() > 0) { //배열에 들어간 숫자가 
                super.myPrint(0); //가장 처음에 들어간 값 반환.
                queueReset(); // 반환해주고 위치 전환
                super.sizeRed(); //사이즈 감소
                } else {
                        System.out.println("데이터가 존재하지 않습니다.");
                }
        }
        
        public void queueReset() { //위치 전환 메서드
                
                for (int i=0 ; i < super.getSize()-1; i++){
                        super.setArr(i,super.getArr(i+1)); 
                        // 만약 size가 3이라면, 
                        //0위치에 1을넣고, 1위치에 2를넣고, 끝~!
                }
        }


}
