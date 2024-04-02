package salarymanagement;

public class Kpi {
    private String kpi; // 성과점수 객체 생성 
    private double kpiRate; // 지급률을 담을 객체 생성 ((get만 필요하다.))

    public Kpi() { // 생성자
    }
    
    public Kpi(String kpi) { // 생성자
        this.kpi = kpi; // 객체를 생성자로 변환
        kpiRateResult(kpi);
    }

    public String getKpi() { // kpi 값을 가져올거임
        return kpi;
    }
    public void setKpi(String kpi) {
    	this.kpi = kpi;
    	kpiRateResult(kpi);
    }
    
    public double getKpiRate() {
        return kpiRate;
    }

    // 문자열의 kpi를 넣으면 kpi 형식에 맞춰서 제어문 실행.
        
    	
   public void kpiRateResult(String kpi) {
    	switch (kpi) {
            case "탁월":
            	kpiRate = 2;
                break;

            case "우수":
            	kpiRate = 1.5;
                break;

            case "양호":
            	kpiRate = 1;
                break;

            case "보통":
            	kpiRate = 0.5;
                break;

            case "미흡":
            	kpiRate = 0.25;
                break;
        }
    }
}
