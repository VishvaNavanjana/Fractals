import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.Random;


public class Panel extends JPanel {
	
	private int width;
	private int height;
	
	public Panel() {
		// set the panel size 
		this.width=800;
		this.height=800;
		setPreferredSize(new Dimension(width,height));
		
	}
	
	
	// create a frame
	public static void createFrame(String frameName,Panel p ) {
		
		JFrame frame = new JFrame(frameName); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		// set the content of the frame as one of this panel
		frame.setContentPane(p); 

		frame.pack(); 
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true); 
		
	}

}
