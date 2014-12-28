package framework.views;

import javax.swing.JFrame;

public class FrameworkView {
	
	JFrame frame;
	
	public void show(){
		
		this.frame.setVisible(true);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public static void main(String[] args) {
		
	}
	

	
}
