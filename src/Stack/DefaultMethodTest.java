package Stack;

public class DefaultMethodTest {

	public static void main(String[] args) {
		Child c = new Chird();
		c.method1();
		c.method2();
		MyInterface.ststiMethod();
		MyInterface2.staticMethod();

	}

}



class Child extends Parent implements MyInterface, MyInterface2{
	public void method1() {
		System.out.println("method1() in Child"); //오버라이딩
	}
	
class Parent {
	public void method2() {
		System.out.println("method2() in Parent");
	}
	
	
interface MyInterface {
	default void method1() {
		System.out.println("method1() in Parent");
	}
	default void method2() {
		System.out.println("method2() in Parent");
	}
	static void staticMethod() {
		System.out.println("staticMethod() in Parent");
	}
}


interface MyInerface2{
	default void method1() {
		System.out.println("method1() in Parent");
	}
	static void staticMethod() {
		System.out.println("staticMethod() in Parent");
	}
}


