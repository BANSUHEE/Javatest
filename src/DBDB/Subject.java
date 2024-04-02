package DBDB;

//점수 클래스 

public class Subject { 
	private int score;
	
	public Subject() {
		this(0);
	}
	
	public Subject(int score) {
		this.score = score;
	}

  public int getScore() {
     // TODO Auto-generated method stub
     return score;
  }
  public void setScore(int score) {
     this.score = score;
     
  }

}


