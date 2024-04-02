package Calculator_Method;

// 추상메소드 


class A{
	private int a; // 이 클래스 내에서만 a를 선언하겠다 ! field
	
	//public A() {
	//	System.out.println("A");
	//}
	public A() { //디폴트 지정자를 명시적으로 만들 경우, 숨어 있는 디폴트는 제공하지 않는다.
		
	}
	public void setA(int a) {this.a = a ;} //
	public int getA() {return a; } //
	
}



 public class Abstract {
	 private String name;    //field 객체생성함.
	 private A age;          // A라는 클래스를 불러오는 age 객체를 만듦.
	
	 
	 public Abstract () {// 생성자 프로젝트 이름이 동일하다. 
		 //생성자 라인디폴트 지정자를 명시적으로 만들 경우, 숨어 있는 디폴트는 제공하지 않는다.
		 name = ""; //공백을 두겠다
		 age = new A (); //A 라는 새로운 객체를 만들어서 클래스의 age에 대입.
	 }
	 public void setName(String name ) {this.name = name;} 
	 //생성자의 name은 class의 name에 대입해서 가져온다.
	 public void setAge(int age) {this.age.setA(age);} //this.age =age; 
	                               //this.age.a =age;
	 
	//
	 public String getName() {return name;}
	 public int getAge() {return this.age.getA();} 
	 
	 
	 
	 public static void main(String[] arge) {
		 Abstract has = new Abstract ();
		 has.setName("Superman");
		 
		 has.setAge(100000);
		 
		 System.out.println(has.getName());
		 System.out.println(has.getAge());
	 }
	 
}

