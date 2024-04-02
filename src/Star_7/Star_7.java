package Star_7;

import java.util.Scanner;

public class Star_7 {
	public static void main(String[] args) {
	      System.out.println("홀수 숫자를 입력해주세요");
	      Scanner sc = new Scanner(System.in);
	      int num = sc.nextInt();
	      if ((num % 2) == 0) {
	         System.out.println("홀수 숫자를 입력해주세요. 종료합니다.");
	      } else {
	         for (int i = 0; i < num; i++) {
	            for (int j = 0; j < num; j++) {
	               if (i <= num / 2) {
	                  if (i + j <= num / 2 - 1)
	                     System.out.print(" ");
	                  else if (j - i >= num / 2 + 1)
	                     System.out.print(" ");
	                  else
	                	  
	                     System.out.print("*");
	               } else if (i > num / 2) {
	                  if (i - j >= num / 2 + 1)
	                     System.out.print(" ");
	                  else if (i + j >= num / 2 * 3 + 1)
	                     System.out.print(" ");
	                  else
	                     System.out.print("*");
	               }
	            }
	            System.out.println();
	         }
	      }

	   }
}
