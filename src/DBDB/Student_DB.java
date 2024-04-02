package DBDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student_DB {
	private Connection conn;
	private PreparedStatement pstmt;
	private Scanner scanner;

	public Student_DB() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC", "root",
					"qwe123!@#");
			scanner = new Scanner(System.in);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertStudent(String name, int kor, int eng, int mat) {
		try {
			String sql = "INSERT INTO students (name, kor, eng, mat) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, kor);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, mat);
			pstmt.executeUpdate();
			System.out.println("학생 정보가 성공적으로 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(String name) {
	    try {
	        String sql = "DELETE FROM students WHERE name = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, name);
	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("학생 정보가 성공적으로 삭제되었습니다.");
	        } else {
	            System.out.println("해당하는 학생을 찾을 수 없습니다.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void updateStudent(String name, int kor, int eng, int mat) {
		try {
			String sql = "UPDATE students SET kor = ?, eng = ?, mat = ? WHERE name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, kor);
			pstmt.setInt(2, eng);
			pstmt.setInt(3, mat);
			pstmt.setString(4, name);
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("학생 정보가 성공적으로 수정되었습니다.");
			} else {
				System.out.println("학생을 찾을 수 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchStudent(String name) {
		try {
			String sql = "SELECT * FROM students WHERE name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("학생 이름: " + rs.getString("name"));
				System.out.println("국어 성적: " + rs.getInt("kor"));
				System.out.println("영어 성적: " + rs.getInt("eng"));
				System.out.println("수학 성적: " + rs.getInt("mat"));
			} else {
				System.out.println("학생을 찾을 수 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void displayAllStudents() {
	    try {
	        String sql = "SELECT * FROM students ORDER BY (kor + eng + mat) DESC"; // 평균값으로 내림차순 정렬
	        pstmt = conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        System.out.println("=============== 전체 학생 성적 ===============");
	        System.out.println("이름\t\t국어\t\t영어\t\t수학\t\t총점\t\t평균");
	        while (rs.next()) {
	            String name = rs.getString("name");
	            int kor = rs.getInt("kor");
	            int eng = rs.getInt("eng");
	            int mat = rs.getInt("mat");
	            int total = kor + eng + mat;
	            double average = total / 3.0;
	            System.out.printf("%s\t\t%d\t\t%d\t\t%d\t\t%d\t\t%.1f\n", name, kor, eng, mat, total, average);
	            System.out.println("------------------------------------------");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	public void closeConnection() {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	    Student_DB sms = new Student_DB();
	    Scanner scanner = new Scanner(System.in);
	    while (true) {
	        System.out.println("=============== 학생 성적 관리 시스템 ===============");
	        System.out.println("1. 학생 정보 입력");
	        System.out.println("2. 학생 정보 수정");
	        System.out.println("3. 학생 정보 검색");
	        System.out.println("4. 전체 학생 성적 출력");
	        System.out.println("5. 학생 정보 삭제");
	        System.out.println("6. 종료");
	        System.out.print("원하는 기능을 선택하세요: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); // 버퍼 비우기
	        switch (choice) {
	            case 1:
	                System.out.print("이름을 입력하세요: ");
	                String name = scanner.nextLine();
	                System.out.print("국어 성적을 입력하세요: ");
	                int kor = scanner.nextInt();
	                System.out.print("영어 성적을 입력하세요: ");
	                int eng = scanner.nextInt();
	                System.out.print("수학 성적을 입력하세요: ");
	                int mat = scanner.nextInt();
	                sms.insertStudent(name, kor, eng, mat);
	                break;
	            case 2:
	                System.out.print("수정할 학생의 이름을 입력하세요: ");
	                String studentName = scanner.nextLine();
	                System.out.print("새로운 국어 성적을 입력하세요: ");
	                int newKor = scanner.nextInt();
	                System.out.print("새로운 영어 성적을 입력하세요: ");
	                int newEng = scanner.nextInt();
	                System.out.print("새로운 수학 성적을 입력하세요: ");
	                int newMat = scanner.nextInt();
	                sms.updateStudent(studentName, newKor, newEng, newMat);
	                break;

	            case 3:
	                System.out.print("검색할 학생의 이름을 입력하세요: ");
	                String searchName = scanner.nextLine();
	                sms.searchStudent(searchName);
	                break;
	            case 4:
	                sms.displayAllStudents();
	                break;
	            case 5:
	                System.out.print("삭제할 학생의 이름을 입력하세요: ");
	                String deleteName = scanner.nextLine();
	                sms.deleteStudent(deleteName);
	                break;
	            case 6:
	                sms.closeConnection();
	                System.out.println("프로그램을 종료합니다.");
	                System.exit(0);
	            default:
	                System.out.println("올바르지 않은 선택입니다. 다시 선택해주세요.");
	                break;
	        }
	    }
	}


}
