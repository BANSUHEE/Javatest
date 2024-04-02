package Student_sb;

import java.util.Scanner;
import java.util.ArrayList;

public class Student_Method {
	//이름 => Name
    //과목 => Subject
    //총점, 평균 : field
    //이름,국어,영어,수학,총점
    private Name name;
    private Subject kor;
    private Subject mat;
    private Subject eng;
    private float avg;
    private int total;

    
    //constructor 생성자 
    public Student_Method() {
       this(new Name(), new Subject(),new Subject(),new Subject());
    }
    
    public Student_Method(Name name) {
       this(name, new Subject(),new Subject(),new Subject());
    }
    
    public Student_Method(Name name, Subject kor) {
       this(name, kor ,new Subject(),new Subject());
    }
    
    public Student_Method(Name name, Subject kor, Subject mat) {
       this(name, kor ,mat,new Subject());
    }
    
    public Student_Method(Name name, Subject kor,Subject mat,Subject eng) {
       this.name = name;
       this.kor = kor; 
       this.mat = mat; 
       this.eng = eng; 
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
       total = this.kor.getScore()+
             this.eng.getScore()+
             this.mat.getScore();
       
       return total;
    }

    public float avg() {
       avg = getTotal()/3.f;
       
       return avg;
       
    }
 }
