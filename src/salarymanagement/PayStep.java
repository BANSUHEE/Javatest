package salarymanagement;


public class PayStep { //호봉 테이블 => 직급,근속연수,호봉,호봉급이 필요하다.
        private String position; //직급이기 때문에 문자열
        private int stepSalary; //호봉 -> 반복문에 사용
        private int tenure; //근속연수 -> 반복문에 사용
        private int payStep; //호봉급
        
        public PayStep () {
        }
        
        public PayStep (String position,int tenure) {
                this.position = position;
                this.tenure = tenure;
                StepSalaryResult();
        }


        public String getPosition() {
                return position;
        }


        public void setPosition(String position) {
                this.position = position;
        }


        public int getStepSalary() {
                return stepSalary;
        }


        public void setStepSalary(int stepSalary) {
                this.stepSalary = stepSalary;
        }


        public int getTenure() {
                return tenure;
        }


        public void setTenure(int tenure) {
                this.tenure = tenure;
        }


        public int getPayStep() {
                return payStep;
        }


        public void setPayStep(int payStep) {
                this.payStep = payStep;
        }
        public void StepSalaryResult() {
                switch(position) {
                case "주임" :
                        tenure = 0;
                        payStep =0;
                        break;
                case "임원" :
                        tenure = 0;
                        payStep = 0 ;
                        break;
                case "계장" :
                        if(tenure<=3) {
                        payStep = 1900000;
                        }
                        else {
                                payStep = 2100000;
                        }
                        break;
                case "대리" :
                        if(tenure<=3) {
                        payStep = 2500000;
                        }
                        else {
                                payStep = 2700000;
                        }
                        break;
                case "과장" :
                        if(tenure<=3) {
                        payStep = 3100000;
                        }
                        else {
                                payStep = 3300000;
                        }
                        break;
                case "차장" :
                        if(tenure<=3) {
                        payStep = 3700000;
                        }
                        else {
                                payStep = 3900000;
                        }
                        break;
                case "부장" :
                        if(tenure<=3) {
                        payStep = 4300000;
                        }
                        else {
                                payStep = 4500000;
                        }
                        break;
                        // defult : return;
                }
        }
}


//      public String getStepp_Salary() {
//              return this.Pay_step;
//              
//      }
//
//      public void setStepp_Salary(String paystep,int year) {
//              switch (paystep) {
//              case "계장":
//                      if(year<=3) { 
//                              setYear(1900000);
//                      }
//                      else{ setYear(2100000);
//                      } 
//              case "대리":
//                      if(year<=3) { 
//                              setYear(2500000);
//                      }
//                      else{ setYear(2700000);
//                      } 
//              case "과장":
//                      if(year<=3) { 
//                              setYear(3100000);
//                      }
//                      else{ setYear(3300000);
//                      } 
//              case "차장":
//                      if(year<=3) { 
//                              setYear(3700000);
//                      }
//                      else{ setYear(3900000);
//                      } 
//              case "부장":
//                      if(year<=3) { 
//                              setYear(4300000);
//                      }
//                      else{ setYear(4500000);
//                      } 
//                      
//              }
//              
//      }
//
//      public int getYear() {
//              return Year;
//      }
//
//      public void setYear(int year) {
//              this.Year = year;
//      }
//      
//      
//
//}