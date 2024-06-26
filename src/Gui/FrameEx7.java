package Gui;
import java.awt.*;

public class FrameEx7 extends Frame {

	   FrameEx7 card;
	   Panel first_panel, second_panel, third_panel;
	   
	   public FrameEx7() {
	      super("Apeach World");
	      
	      card = new FrameEx7();
	      setLayout(card);
	      
	      first_panel = new Panel();
	      first_panel.add(new Button("1"));
	      first_panel.add(new Button("2"));
	      
	      second_panel = new Panel();
	      second_panel.add(new Button("3"));
	      second_panel.add(new Button("4"));
	      
	      third_panel = new Panel();
	      third_panel.add(new Button("5"));
	      third_panel.add(new Button("6"));
	      
	      add("1", first_panel);
	      add("2", second_panel);
	      add("3", third_panel);
	      
	      
	      public void rotate() {
	         for(int i=0; i<2; i++) {
	            try {
	               Thread.sleep(3000);
	            } catch(Exception e) {
	               e.printStackTrace();
	            }
	            
	            card.next(this);
	         }
	      
	      
	   
	   public static void main(String[] args) {
		   FrameEx7 cl = new FrameEx7();
	      
	      cl.setBounds(200,200,200,100);
	      cl.setVisible(true);
	      
	      cl.rotate();
	   }
	}
}