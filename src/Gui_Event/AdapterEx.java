package Gui_Event;

import java.awt.*;
import java.awt.event.*;


public class AdapterEx extends Frame implements ActionListener { 
	 Panel p,p1,p2;
	 
	 Button b1,b2; //버튼
	 TextField tf; //텍스트 입력 받는 변수
	 TextArea ta; // 여러줄의 텍스트를 표시할 수 있는 객체를 참조한 변수
	 
	 public AdapterEx() {
		 
	 super("Adapter Exam");
	 
	 p  = new Panel ();
	 p1 = new Panel ();
	 p2 = new Panel ();
	 
	 tf = new TextField(35);
	 ta = new TextArea(10,35);
	 
	 
	 b1 = new Button("Clear");
	 b2 = new Button("Exit");
	 p.add(tf);
	 p1.add(ta);
	 p2.add(b1);
	 p2.add(b2);
	 
	 add("North",p);
	 add("Center",p1);
	 add("South",p2);
	 
	 setBounds(300,300,300,200);
	 setVisible(true);
	 
	 b1.addActionListener(this);
	 b2.addActionListener(this);
	 
	 
	 tf.addKeyListener(new KeyEventHandler(tf,ta));
	 
	 addWindowListener(new WindowEventHandler());
	 }
	
	 } 
	 public void actionPerformed(ActionEvent e) {
		 //사용자가 버튼을 클릭했을 때 실행되는 동작
		 String str = e.getActionCommand();
		 if(str.equals("clear")) {
			 ta.setText(""); //ta의 텍스트를 지웁니다.
			 tf.setText(""); //tf의 텍스트를 지웁니다.
			 tf.requestFocus(); //tf에 포커스를 설정하고 사용자가 다시 입력할 수 있게 해줍니다.
		 }
			 else if(str.equals("Exit")) {
				System.exit(0);
			 }
	 }
	 
	 public static void main(String[] args){
			new AdapterEx();
			//AdapterEx 클래스의 새로운 인스턴스를 만들어서 해당 클래스의 생성자를 호출 !
		}
	}
	
	class KeyEventHandler extends KeyAdapter{
		TextField tf;
		TextArea ta;
		
		publis KeyEventHandler(TextFild tf, TextArea ta) {
			this.tf=tf;
			this.ta=ta;
		}
		
		publi
		 
		
		 String name;
		 name = ae.getActionCommand();
		 //이벤트 발생한 요소에 대한 명령 문자열을 가져와서 변수에 할당
		 
		 if(name.equals("clear")){
			 ta.setText("");
		 }else {
			 ta.append("");
			 
		 }
		 	
		 
	 }
	 
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
