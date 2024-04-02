package DBDB;

import java.util.Scanner;

//LinkedList 자체 관리하는 클래스
public class Student_list {

	Scanner sc = new Scanner(System.in);
	Student1 Newst;
	Student1 Head;
	Student1 Cur;
	Student1 Del;
	// Node head;

	Student1 stu = new Student1();

	public Student_list() {

	}

	public void mainDisplay() {
		System.out.println("=============== 학생 성적 관리 프로그램 ===============" + '\n' + "1. 학생 성적 입력" + '\n' + "2. 학생 성적 수정"
				+ '\n' + "3. 학생 성적 검색" + '\n' + "4. 학생 성적 출력" + '\n' + "5. 프로그램 종료" + '\n'
				+ "=================================================");
	}
	
	public void addData() {
	    System.out.println("이름, 국어, 영어, 수학 점수를 순서대로 입력해주세요.");
	    Student1 newStudent = new Student1();
	    newStudent.setName(sc.next());
	    newStudent.setKor(sc.nextInt());
	    newStudent.setEng(sc.nextInt());
	    newStudent.setMat(sc.nextInt());
	    newStudent.getTotal(); // 합계로 정렬하기 위한 준비
	    addSortedList(newStudent);
	}

	public void addSortedList(Student1 newStudent) {
	    //head가 null 이거나 첫번째 학생 총합보다 새로운 학생 총합이 크다면 새로운 학생를 head로 지정하겠다.
	    if (Head == null || newStudent.getTotal() > Head.getTotal()) {
	        newStudent.next = Head; //현재 학생의 다음 노드로 현재 head 지정.
	        Head = newStudent;  //head 초기화
	    } else {
	        Student1 cur = Head; //현재 위치를 표현해주는 cur 변수를 head로 초기화.
	        //포인터의 다음 주소가 null이 아니고 새로운 학생의 총합이 다음 학생의 총합보다 작다는 조건.
	        while (cur.next != null && newStudent.getTotal() < cur.next.getTotal()) {
	            // 포인터는 포인터의 다음주소를 가리킨다.
	            cur = cur.next;
	        }
	        //새로운 학생의 노드 주소로 포인터의 다음 주소를 가리킨다.
	        newStudent.next = cur.next;
	        //포인터의 다음 노드를 새로운 학생으로 변경.
	        cur.next = newStudent;
	    }
	}

		
		

	public void allView() { //전체 학생 성적 출력해주는 함수
		System.out
				.println("================ 모든 학생들의 성적표 =================" + '\n' + "이름　　　　국어　　　　영어　　　　수학　　　　총합　　　　평균");
		Cur = Head;
		while (Cur != null) {
			Cur.print();
			Cur = Cur.next;
		}
	}


	public void nameCur(String name) { // 학생 이름을 검색해주는 함수 
		Cur = Head;
		while (Cur.next != null) {
			if (Cur.getName().equals(name)) {
				break;
			} else {
				Cur = Cur.next;
			}
		}
	}

	public void modifyStudent() {  //학생 성적을 수정하는 함수
		System.out.print("수정할 학생의 이름을 입력해주세요 : ");
		String name = sc.next();

		// 학생 이름으로 검색하여 해당 학생을 찾습니다.
		nameCur(name);

		// 학생이 존재하지 않는 경우 메시지를 출력하고 종료합니다.
		if (Cur == null) {
			System.out.println("학생 정보를 찾을 수 없습니다.");
			return;
		}
		
		System.out.println("수정할 과목을 선택해주세요:");
		System.out.println("1. 국어");
		System.out.println("2. 영어");
		System.out.println("3. 수학");
		
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.print("국어 성적 수정 (현재: " + Cur.getKor() + "): ");
			Cur.setKor(sc.nextInt());
			break;
		case 2:
			System.out.print("영어 성적 수정 (현재: " + Cur.getEng() + "): ");
			Cur.setEng(sc.nextInt());
			break;
		case 3:
			System.out.print("수학 성적 수정 (현재: " + Cur.getMat() + "): ");
			Cur.setMat(sc.nextInt());
			break;
		default:
			System.out.println("올바른 선택이 아닙니다.");
			return;
		}
		// 수정된 학생의 정보로 새로운 Student 객체를 생성합니다.
	    Student1 modifiedStudent = new Student1();
	    modifiedStudent.setNext(null);  // 새로운 학생의 next 필드를 null로 초기화합니다.

	    // 수정된 학생을 정렬된 위치에 삽입 
	    addSortedList(modifiedStudent);

	    System.out.println("수정되었습니다.");

	}
	
	

	public void selectView() { //학생 이름을 검색해주는 함수
		System.out.println("1. 이름검색  2. 평균 검색");
		int type = sc.nextInt();

		if (type == 1) {
			System.out.println("검색할 학생의 이름을 입력해주세요 : ");
			nameCur(sc.next());

			System.out.println("이름　　　　국어　　　　영어　　　　수학　　　　총합　　　　평균");
			Cur.print();

		} else if (type == 2) {
			System.out.println("평균 몇점 이상의 학생을 조회할까요?");
			avgCur(sc.nextInt());

		} else {
			System.out.println("1 ~ 2 사이의 숫자로 입력해주세요.");
		}
	}
	

	public void avgCur(int avg) {  //평균 값을 찾아주는 함수
		Cur = Head;
		while (Cur != null) {
			if (Cur.getAvg() >= avg) { 
	//평균은 소수점을 가질 수도 있으므로 평균 이상의 평균을 가진 학생을 찾아야 할 때도 있을 수 있다.
				Cur.print();
			}
			Cur = Cur.next;
		}
	}
}
