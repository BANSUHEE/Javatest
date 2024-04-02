package Stack;
/* 인터페이스는 추상클래스보다 더 추상화된 구조.
 * 상수, 추상메소드만 올 수 있다.
 * 
 * 인터페이스는 다중상속을 대체하는 게 주 목적.
 * 구현객체는 무조건 오버라이딩을 제공해야 객체를 생성할 수 있다.
 * 구현을 안 해도 추상클래스로 제공되서 객체를 생성할 수 없다.
 * public class InterPace implements AAA,BBB .... 나열 가능
 * 
 * 인터페이스끼리는 다중상속이 가능하다.
 */
public interface AAA {
	final static int A = 10; // 인터페이스는 변수를 상수로 쓸 수 있는 final 과 static 생략 가능
	int B = 30; // 생략한 문장.
	
	abstract void disp();//인터페이스는 추상메서드 밖에 못 오기 때문에 abstract 생략가능
}
