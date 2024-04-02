package Inheritance;

import java.util.Scanner;

public class MemoryPlay {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		MemoryObject mo = new MemoryObject();
		int choice = 0;
		int select = 0;
		do {
			mo.mainDisplay();
			choice = sc.nextInt();
			
			switch (choice) {
				case 1: //입력
					mo.memorySelect();
					select = sc.nextInt();
					mo.dynamic(select);
					mo.input();
					break;
				case 2: //출력
					mo.memorySelect();
					select = sc.nextInt();
					mo.dynamic(select);
					mo.pop();
					break;
				case 3: //조회
					mo.memorySelect();
					select = sc.nextInt();
					mo.dynamic(select);
					mo.allView();
					break;
				case 4: // 종료
					break;
			}
		} while (choice !=4);
	}
}		
