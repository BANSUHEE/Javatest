package DBDB;

public class Name {
	private String name;
	
	public Name() { //기본 생성자 : 문자열을 반환
		this(""); 
	}
	
	public Name(String name) { 
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}




/*  <총 5개의 클래스>
 * 
 * 1. Student_list: LinkedList 자체를 관리하는 클래스입니다. 학생의 성적 입력, 수정, 검색, 출력 등을 담당합니다.
   2. Student_main: 프로그램의 실행을 담당합니다.
   3.Subject: 과목을 나타내는 클래스입니다. 점수를 저장하고 반환하는 기능을 제공합니다.
   4.Name: 학생의 이름을 나타내는 클래스입니다.
   5.Student: 학생의 데이터를 담고 있는 클래스로, 학생의 이름과 각 과목의 점수를 저장하고, 총합과 평균을 계산하는 기능을 제공합니다.
 * 
 * 
 */


