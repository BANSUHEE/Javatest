package DO_day2;

public class SortExam {
	public static void main(String[] age) {
		int data[]= {90,78,100,30,55}; //배열을 만들기 
		bubbleSort(data);//버블 정렬 메서드
		for(int i:data) { // i에 반복 순환 후 출력
			System.out.println(i+"\t");
		}
	}
	

	private static int[] bubbleSort(int[] data) { 
		int count = 0; //비교 초기화
		int turn = 0; //교환 초기화
		int index =0; //총 갯수 초기화
		while(index < data.length) { 
		//배열의 길이보다 -1 작게 반복 ex: 배열[5] = 길이 5이지만 0~4까지 (while문 true이면 실행)
	for(int i=0;i<data.length-index-1;i++) { //총 배열의 길이 - index(정렬이 된 수의 집합) - 1(마지막 칸)
		turn++; //비교 증가
		if(data[i]>data[i+1]) { //앞 뒤 비교 
			count++; // 교환 증가
			int c = data[i]; 
			data[i]=data[i+1];
			data[i+1]=c;
		}
	}
	index ++; // 정렬의 수 증가
}
		System.out.println("총 바뀐 횟수 : "+ count);
		System.out.println("총 반복문이 돈 횟수"+ turn);
		return data;
}
}

