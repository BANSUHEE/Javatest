package Gui;

import java.awt.*;

public class FrameEx6 {
	public static void main(String[] args) {
		      Frame f = new Frame("Apeach World");
		      Panel p = new Panel();
		      
		      CheckboxGroup group = new CheckboxGroup();
		      Checkbox radio1 = new Checkbox("pipi",group,false);
		      Checkbox radio2 = new Checkbox("cici",group,true);
		      Checkbox radio3 = new Checkbox("popo",group,false);
		      
		      p.add(radio1);
		      p.add(radio2);
		      p.add(radio3);
		      
		      f.add(p);
		      
		      f.setSize(300,100);
		      f.setVisible(true);
		   }

		}

