package DO_day2;
import java.util.Random;

public class Insertion_sort {

	    private int comparisonCnt;  //비교 횟수

	    public Insertion_sort() {
	        comparisonCnt = 0;
	    }
	    public static void main(String[] args) {
	    	Insertion_sort insertSort = new Insertion_sort();
	        int data [] = new int[50];
	        Random random = new Random();

	        for(int i = 0; i < 50; i++ ) {
	            data[i] = random.nextInt(1000); //0이상 999이하 난수를 생성해준다.
	        }

	        insertSort.insertSort(data); //삽입정렬 메서드

	        for(int i : data) { //i 에 데이터 대입.
	            System.out.print(i +", ");
	        }
	        System.out.println();
	        System.out.println("비교 횟수: "+insertSort.comparisonCnt); //누적된 비교횟수
	    }

	    public void insertSort(int[] data) { 

	        //배열의 길이 -1 숫자만큼 반복
	        for(int i=1; i < data.length; i++) { //

	            //첫 번째 for문의 i의 위치 => 인덱스, 비교 대상의 값을 선정
	            int key = data[i];
	            //첫 번째 for문의 i의 위치부터 0번째 index까지 비교대상의 변수명
	            // 현재 위치의 i는 비교할 필요가 없다. [ 초기 선언시, 자기 자신 이므로 ]
	            int searchIndex = i - 1;
	            //현재 비교 중인 요소의 인덱스
	            //삽입 정렬의 비교 대상
	            //1. 0 번째 인덱스까지 비교
	            //2. 제일 앞은 최소값이므로, 자신보다 작은 index 나올때까지 찾기 위해 반복문
	            while(0 <= searchIndex && data[searchIndex] > key) {
	                comparisonCnt++;  //삽입정렬 횟수 Count
	                
	                data[searchIndex+1] = data[searchIndex];    //첫 번째 조건의 값이 자기보다 크다면 index 한칸씩 뒤로 미루기.
	                searchIndex--;                              //반복을 위한 증감값 설정 ( while 탈출 용)
	            }

	            data[searchIndex+1] = key; //while이 끝날 경우, 해당 index에 값 생성, + 위에서 index가 --되었으므로 다시 +1 하기
	        }
	    }
	}

