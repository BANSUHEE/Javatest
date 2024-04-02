/*inner class : outer class의 멤버를 내것처럼 사용할 수 있게 해주는 클래스
 *            : 특정목적 : outer class의 맞는 목적
 *            : event 처리시 주로 사용
 * 
 * 1.member inner class - 클래스 안에 있는 것.*** 많이 씀
 * 2.static inner class - static class Test
 * 3.local inner class - 함수 안에다가 클래스를 만든 것.
 * ex ) public class InnerClassExam {
	void disp() {
	class Test{
		
		}
	}
 * 4.anonymous inner class - 이름이 없는 클래스 이벤트 목적 ************제일 많이 씀 !
 * 
 * outer class
 * inner class
 */


//< member inner class,static inner class,local inner class 구분>
import jdk.incubator.vector.VectorOperators.Test;

public class InnerClassExam { // outer 클래스

	private int a;
	private static int b;

	public void dispTest() {
		
		
		 class Test { // 프로그램이 시작하기 전에 생성되기 때문에 outer .class 중에 static 변수 선언만 사용 !!!

			public void disp() { 
				System.out.println(a);
				System.out.println(b);
			}
		}
		Test test = new Test();
		test.disp();
	}

	public static void main(String[] age) {
//		InnerClassExam inner = new InnerClassExam();
//		InnerClassExam.Test test = inner.new Test();
//		// InnerClassExam.Test test = new InnerClassExam().new.Test();
//		test.disp();
		InnerClassExam inner = new InnerClassExam();
		inner.dispTest();
		
	}
}
