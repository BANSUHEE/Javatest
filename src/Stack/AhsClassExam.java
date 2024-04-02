package Stack;

//public class AhsClassExam {
	abstract class Area{
		/*추상 클래스는 추상메서드를 하나 이상 가지고 있다.
		*추상 클래스는 객체 생성을 할 수는 없고, 상속을 해주는 목적을 사용한다.
		*추상메서드는 서브클래스에 강제성을 부여(오버라이딩)
		*오버라이딩을 하지 않을 경우 서브 클래스도 추상클래스화 되서 객체를 생성할 수 없다.
		*
		*상속관계시 항상 공통된 것은 수퍼클래스에 정의
		*개념적으로는 수퍼에 있어야 하지만 기능적으로 수퍼에 정의할 수 없을 때 만든다.
		*/
		public abstract void draw(); //abstract 추상정의
		}

	class Rect extends BBBB{ //Area 상속 extends  받음.
		public void draw() {
			System.out.println("Rect");
		}
	}
	class Circle extends BBBB{
		
		public void draw() {
			System.out.println("Circle");
		}
	}
	class Tri extends BBBB{
		public void draw() {
			System.out.println("Tri");
		}
	}
	public class AhsClassExam {
		public static void main(String[]ar) {
			Tri tri= new Tri();
			tri.draw();
			Rect rect= new Rect();
			rect.draw();
			Circle circle= new Circle();
			circle.draw();
		}

	}

}
