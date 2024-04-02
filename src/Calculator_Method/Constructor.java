package Calculator_Method;
public class Constructor {
   int a;
   int b;
  //객체 생성
   
   public Constructor() {
      // this.a =0;
	  // this.b =0; 이 부분이 숨겨져 있음.
      this(0,0); //기본 생성자가 호출될 때 내부적으로 'a'와'b'
   }
   public Constructor(int a) {
	   this.a = a;  //받은 값 a - > class Constructor의 필드에 선언된 a 객체 저장
      // this.b=0; 이 부분이 숨겨져 있음.
      //this(a,0);
   }
   public Constructor(int a, int b) {
	  this.a = a ; // 받은 값 a.b -> class Constructor의 필드에 선언된 a.b 객체 저장
      this.b = b;
      
   }
   public int getA() { // set으로 변경된 class Constructor의 필드 a 객체 반환
      return a;
   }

   public void setA(int a) { //받은 값 a -> class Constructor의 필드에 선언된 a 객체 저장
	      this.a = a;
	   }
   
   public int getB() { //set으로 변경된 class Constructor의 필드 b 객체 반환
      return b;
   }

   public void setB(int b) { //받은 값 b -> class Constructor의 필드에 선언된 b 객체 저장
      this.b = b;
   }
   

   public static void main(String[] args) {
	   Constructor th = new Constructor(); //0.0    인스턴스화된 Constructor 객체 생성
	   Constructor th2 = new Constructor(10); //10.0   인스턴스화된 Constructor 객체 생성하고, 생성자에 인자로 10 전달
	   Constructor th3 = new Constructor(20,30); //20.30  인스턴스화된 Constructor 객체 생성하고, 생성자에 인자로 20,30 전달
      
   System.out.println(th.getA()+","+th.getB()); //출력값
   System.out.println(th2.getA()+","+th2.getB());
   System.out.println(th3.getA()+","+th3.getB());
   }
}