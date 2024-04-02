//anonymous inner class 구조

package Stack;

public class InterExam2 {
	
	private int a;
	
	public void dispInter() {
		new AAA() {
			// 인터페이스이다 보니깐 객체로 만들 수 없다.
		
		 public void disp() {
			 System.out.println(a);
			 
		 }
	  }.disp();; 
	}

	public static void main(String[] args) {
		InterExam2 inter = new InterExam2();
		inter.dispInter();

	}

}
