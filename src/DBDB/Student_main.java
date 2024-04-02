package DBDB;
import java.util.Scanner;

public class Student_main {
	   public static void main(String[] args) {

	         Scanner sc = new Scanner(System.in);
	         Student_list allstu = new Student_list(); //
	         int num = 0;
	         int selectNum = 0;

	         do {
	            allstu.mainDisplay(); //홈화면 문구 
	            num = sc.nextInt(); //메뉴 숫자 입력 

	            switch (num) { 
	            case 1:
	               allstu.addData(); // 학생 성적 입력 
	               break;
	            case 2:
	               allstu.modifyStudent(); //학생 성적 수정 
	               break;
	            case 3:
	               allstu.selectView (); // 학생 성적 검색 
	               break;
	            case 4:
	            	 allstu.allView(); // 학생 성적 출력 
	               break;
	            case 5:  // 프로그램 종료 
	               num = 5;
	               break;
	            default:
	               System.out.println("1 ~ 5의 숫자로 입력해주세요.");
	               break;
	            }
	         } while (num != 5);
	         System.out.println("프로그램을 종료합니다.");

	      }
	   }


