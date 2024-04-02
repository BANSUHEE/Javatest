package Calculator_Method;

import java.util.Scanner;

public class Calculator1 {
	   
	   //field 
	   private int num1;   //field 는 class 안에서 선언된 변수들로 지속적으로 사용되어지는 변수이다.
	   private int num2;
	   private String op;
	   private double result;
	   
	   //constructor(생성자) 
	   //접근 지정자(public)로 지정.
	    //디폴트 지정자를 명시적으로 만들 경우, 숨어 있는 디폴트는 제공하지 않는다.
	   
	      public Calculator1() {
	      }
	      
	      public Calculator1(int n,int n2, String op1) {
	         
	         num1=n; //this.num1=n; 사용만 가능하다
	         num2=n2;
	         op=op1;
	      }
	      
	   // method : setter(외부에서 주는 데이터를 입력하는 함수), getter(외부에서 필드값을 얻어가는 함수) 
	   // 외부에서 메소드를 통해 데이터에 접근하도록 유도하는 set 
	   // 외부에서 객체의 데이터를 읽을 때, 필드값을 가공하고 외부로 전달하는 get
	   
	      public void setNum1(int n) {
	         num1 = n; 
	      }
	      public int getNum1() {
	         return num1;
	      }
	      public void setNum2(int n2) {
	         num2 = n2;
	      }
	      public int getNum2() {
	         return num2;
	      }
	      public void setOp(String op1) {
	         String op = op1;
	      }
	      public String getOp() {
	         return op;
	      }
	      
	      public double plus(int n, int n2) {
	         return result = n + n2;
	      }
	      

	   public static int plu(int num1,int num2) { //더하기 연산 함수
	      return  num1+num2; //result라는 변수에다가 저장도 가능 result = num1+num2
	   }
	   public static int min(int num1,int num2) { //마이너스 함수
	      return num1-num2;
	   }
	   public static int dli(int num1,int num2) { //나눗셈 함수
	      return num1/num2;
	   }
	   public static double mul(int num1,int num2) { //곱셈 함수
	      return num1*num2;
	   }

	   
	   
	   public static void main(String[] args) {
	         
	      Scanner sc = new Scanner(System.in);
	      
	      int n = sc.nextInt();
	      
	      String op = sc.next();
	      
	      int n2 = sc.nextInt();
	      
	      Calculator1 calc = new Calculator1(n,n2,op);
	      
	      System.out.println(calc.getNum1()+" "+calc.getOp()+" "+calc.getNum2()+"");
	      System.out.println(Calculator1.plu(n,n2));
	   }    
	}
