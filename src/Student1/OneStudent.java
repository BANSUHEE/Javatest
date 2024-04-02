//한사람 성적관리
// !!! 짝꿍 없음 단독 실행 !!!

package Student1;
import java.util.*;

import Student_Linkedlist.Name;
import Student_Linkedlist.Subject;

public class OneStudent {
		Name name; // Name 클래스의 형식을 가진 객체
		Subject kor;// Subject 클래스의 형식을 가진 객체
		Subject eng;// Subject 클래스의 형식을 가진 객체
		Subject mat;// Subject 클래스의 형식을 가진 객체
		int total;// int의 형식을 가진 객체
		float avg;// float의 형식을 가진 객체

		// 첫번째 기본 생성자 : 클래스의 인스턴스가 생성될 때 호출 !

		// 역할:클래스의 인스턴스를 생성할 때 각 필드를 초기화하는 것이다.
		public OneStudent() { // 생성자의 역할이며, 클래스의 인스턴스가 생성될 때 호출
			// 인스턴스는 
			//클래스로부터 생성되고,각 인스턴스는 고유한 상태(state)을 가질 수 있다.
			// 즉, 인스턴스는 클래스에서 정의된 속성과 동작을 가질 뿐만 아니라 고유한 데이터 값을 가질 수 있다.
			name = new Name(); // 클래스의 필드를 초기화하는 역할
			kor = new Subject();
			eng = new Subject();
			mat = new Subject();
		}

		// 두번째 생성자 :외부에서 제공된 값으로 인스턴스 초기화 !
		public OneStudent(Name name, Subject kor, Subject eng, Subject mat) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
		}

		public void setName(String name) {
			this.name.setName(name);
		}

		public void setKor(int kor) {
			this.kor.setSubject(kor);
		}

		public void setEng(int eng) {
			this.eng.setSubject(eng);
		}

		public void setMat(int mat) {
			this.mat.setSubject(mat);
		}

		public String getName() {
			return name.getName();
		}

		public int getKor() {
			return kor.getSubject();
		}

		public int getEng() {
			return eng.getSubject();
		}

		public int getMat() {
			return mat.getSubject();
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public int getTotal() {
			return total = getKor() + getEng() + getMat();
		}

		public float getAvg() {
			return avg = total / 3.0f;
		}

	public static void main(String[] args) {
		OneStudent stu = new OneStudent();
	    stu.setName("superman");
	    stu.setKor(90);
	    stu.setMat(100);
	    stu.setEng(70);
	    
	    System.out.println(stu.getName());
	    System.out.println(stu.getKor());
	    System.out.println(stu.getMat());
	    System.out.println(stu.getEng());
	    System.out.println(stu.getTotal());
	     System.out.println(stu.getAvg());
	 }
	}
			
			//학생 수와 상관없이 학생의 수 맞게 국어,영어,수학,총합,평균을 계산해서 산출을 해줘야 한다.
			//배열을 만든다.

		
//		public static void main(String[] args) {
	//
//			Scanner sc = new Scanner(System.in);
//			System.out.println("이름,국어,영어,수학을 순서대로 입력해주세요 :");
//			int num = sc.nextInt(); //num 숫자만큼 반복문 실행
//			student_me [] stu = new student_me[num]; 
//			// 배열은 객체가 아니라 주소를 담는 변수이기 때문에, 배열을 생성할 때 배열의 각 요소는 초기화된다.
//			//System.out.println("이름,국어,영어,수학을 순서대로 입력해주세요 :");
//			for (int i = 0; i < num; i++) {
//				stu[i].setName(sc.next());
//				stu[i].setKor(sc.nextInt());
//				stu[i].setEng(sc.nextInt());
//				stu[i].setMat(sc.nextInt());
//				
//			}
	//
//			for (int p = 0; p < num; p++) {
	//
//				System.out.println(stu[p].getName());
//				System.out.println(stu[p].getKor());
//				System.out.println(stu[p].getEng());
//				System.out.println(stu[p].getMat());
//				System.out.println(stu[p].getTotal());
//				System.out.println(stu[p].getAvg());
//				
//			} 
//		}  
	//}

