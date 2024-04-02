// < 쓰레드 구현>


package Synchronized;

class ATMTwo implements Runnable {
	  private long depositeMoney = 10000; 
	   public void run(){
	      synchronized(this){ 
	         notify();
	         for(int i=0;i<10;i++){ 
	            try {
	               if(getDepositeMoney()<=0) break;  
	               withDraw(1000);
	               wait();
	               notify();
	            } catch (InterruptedException e) {}
	         }
	         
	         
	      } 
	   } 
	   public void withDraw(long howMuch){ 
	      if(getDepositeMoney() >0){ 
	         depositeMoney -= howMuch; 
	         System.out.print(Thread.currentThread().getName()+" , "); 
	         System.out.printf("%d %n",getDepositeMoney()); 
	      }else{ 
	         System.out.print(Thread.currentThread().getName()+" , "); 
	         System.out.println("End."); 
	      } 
	   } 
	   public long getDepositeMoney(){ 
	      return depositeMoney; 
	   } 
	} 
class WaitNotifyEx{ 
	   public static void main(String[] args){ 
	      ATMTwo atm = new ATMTwo(); 
	      Thread mother = new Thread(atm,"mother"); 
	      Thread son = new Thread(atm,"son"); 
	      mother.start(); 
	      son.start(); 
	   } 
	} 
