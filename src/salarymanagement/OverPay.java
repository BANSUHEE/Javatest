package salarymanagement; //도움 요청

public class OverPay { 
	private int overTime; //시간외 근무(분)
	private int overPay; //시간외 수당

	public OverPay() { 
		//디폴트 생성자
	}
	
	public OverPay(int overTime) {//객체 생성 동시 overtime
		this.overTime = overTime;
		overPayResult(overTime);
		
	}

	//getter, setter 
	public int getOvertime() { //사용자가 원한다면 시간외근무(분)을 불러올 수 있음.
		return overTime; 
	}

	

	public int getOverPay() { //시간외수당 반환 !
		return overPay;
	}


	public void setOvertime(int overTime) {//overtime입력시 자동으로 overpay 계산.
		this.overTime = overTime;// 안 넣으면 안되려나 ?
		overPayResult(overTime);
	
	}
	
	public void overPayResult(int overTime) {
		overPay = (overTime/30) * 10000; //30분 미만은 버림. int형
	}
	
}
