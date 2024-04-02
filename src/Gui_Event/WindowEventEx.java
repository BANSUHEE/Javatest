package Gui_Event;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.*; 
import java.awt.event.*;
class Exit extends WindowEventEx{
	public void windowClosing(WindowEvent e) {
		System.exit(0); 
		}
	
}



public class WindowEventEx extends Frame  {
		   public WindowEventEx() {
		      super("WIndoeEvent 테스트");
		      Label exit = new Label("프로그램 종료");
		      
		      add(exit);
		      
		      setBounds(300,300,300,200);
		      setVisible(true);
		   }
		   void addWindowListener(new Exit());
		   
		   public static void main(String[] args) {
		      new ActionEventEX();
		   }
}
//		@Override
//		
//		public void windowActivated(WindowEvent e) {}
//		@Override
//		public void windowDeactivated(WindowEvent e) {}
//		@Override
//		public void windowClosed(WindowEvent e) {}
//		@Override
//		public void windowIconified(WindowEvent e) {}
//		@Override
//		public void windowDeiconified(WindowEvent e) {}
//		
//		
//		}


