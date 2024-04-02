package DBDB;
import java.util.Scanner;
// 학생의 데이터가 담겨있는 클래스 (get + set)
public class Student1 {
	    private Name name;
	    private Subject kor;
	    private Subject mat;
	    private Subject eng;
	    private float avg;
	    private int total;
	    Student1 next;  //다음 노드를 가리키는 포인터
	   
	    //기본 생성자
	    public Student1() {
	       this(new Name(), new Subject(),new Subject(),new Subject());
	    }
	   
	    public Student1(Name name) {
	       this(name, new Subject(),new Subject(),new Subject());
	    }
	   
	    public Student1(Name name, Subject kor) {
	       this(name, kor ,new Subject(),new Subject());
	    }
	   
	    public Student1(Name name, Subject kor, Subject mat) {
	       this(name, kor ,mat,new Subject());
	    }
	 
	    public Student1(Name name, Subject kor,Subject mat,Subject eng) {
	        this.name = name;
	        this.kor = kor;
	        this.eng = eng;
	        this.mat = mat;
	        this.next = null; // 초기에는 다음 노드가 없으므로 null로 초기화
	    }
	   
	    //과목 getter setter
	    public String getName() {
	       return this.name.getName();
	    }
	    public void setName(String name) {
	       this.name.setName(name);
	    }
	    public int getKor() {
	       return this.kor.getScore();
	    }
	    public void setKor(int kor) {
	       this.kor.setScore(kor);
	    }
	    public int getMat() {
	       return this.mat.getScore();
	    }
	   
	    public void setMat(int mat) {
	       this.mat.setScore(mat);
	    }
	    public int getEng() {
	       return this.eng.getScore();
	    }
	    public void setEng(int eng) {
	       this.eng.setScore(eng);
	    }
	   
	   
	    //총 합계 + 평균
	    public int getTotal() {
	       total = total();
	       return total;
	    }
	   
	    public float getAvg() {
	       avg = avg();
	       return avg;
	    }
	    public void print() {
	       System.out.println(getName()+'\t'+
	        getKor()+'\t'+
	        getEng()+'\t'+
	        getMat()+'\t'+
	        getTotal()+'\t'+
	        getAvg());
	    }
	   
	    public int total() {
	       total = this.kor.getScore()+this.eng.getScore()+ this.mat.getScore();
	       return total;
	    }
	    public float avg() {
	       avg = total()/3.f;
	      
	       return avg;
	      
	    }
	    public void setNext(Student1 next) {
	        this.next = next;
	    }
		public Student1 getNext() {
			return next;
		}
	}