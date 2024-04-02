package Game_ball;
import java.util.Random;
import java.util.Scanner;

public class Baseball {

   
    public static void main(String[] args) {
        Random random = new Random(); //random 
        Boolean gameover = false; //게임의 시작과 끝
        
        int[] ComputerNumbers = new int[3]; //컴퓨터 인자 값 배열
        int[] MyNumbers = new int[3]; //사용자 인자 값 배열
       
        
      
        for (int i = 0; i < 3; i++) {   //컴퓨터 배열 값 
           ComputerNumbers[i] = random.nextInt(10); // 0 ~ 9부터까지 숫자 반복
           for(int j =0; j < i ;j++) { //사용자 배열 값
              --i;
           } 
        }   
        
        for(int d=0 ;d<ComputerNumbers.length;d++) {
       //   System.out.print(ComputerNumbers[d]); //컴퓨터 값 출력
       }
       // System.out.println(); // 컴퓨터 값 출력
        System.out.println("야구 게임을 시작하겠습니다 !");
    
       
        
        while (!gameover) {
            // 숫자를 입력합니다.
            System.out.print("중복되지 않는 숫자 3개를 입력해주세요 : ");
            Scanner scanner = new Scanner(System.in);
            
            for (int i = 0; i < 3; i++) {
               MyNumbers[i] = scanner.nextInt();
            }
           
            int strikes = 0;
            int balls = 0;
            
            for (int i = 0; i < 3; i++) {
                if (MyNumbers[i] == ComputerNumbers[i]) {
                    strikes++;
                } else 
                {
                    for (int j = 0; j < 3; j++) {
                        if (MyNumbers[i] == ComputerNumbers[j]) {
                            balls++;
                            break;
                        }
                    }
                }
            }
            
            //출력 값
            if (strikes == 3) { //strikes 3개가 쌓이면 Game over 
                System.out.println(" 3 strikes! Game over.");
                gameover = true;
            } else { //
                System.out.println("Strikes: " + strikes + ", Balls: " + balls);
            }
        }
    }
}
