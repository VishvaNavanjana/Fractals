import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.Random;


public class Julia extends Panel {
	
	//Region of interest 
	//these values are always default
	private static double realMin=-1;
	private static double realMax=1;
	private static double ImagneryMin=-1;
	private static double ImagneryMax=1;
	
	//default values
	private int Iterations=1000;
	
	double cReal=-0.4;
	double cImg=0.6;
	
	//constructors
	public Julia() {
		super();
	}
	
	public Julia(double cReal, double cImg, int iterations) {
		super();
		this.cReal = cReal;
		this.cImg = cImg;
		this.Iterations = iterations;
	}



	public void paintComponent(Graphics g) { 
		// call paintComponent from parent class 
		super.paintComponent(g); 
		
		int iter,i,j;
		double real,imagenery;
		float Saturation = 1f;
		
		for(i=0;i<800;i++) {
			for(j=0;j<800;j++) {
				
				//calculating the point in the complex plane
				double x = realMin + i*((realMax-realMin)/800);
				double y = ImagneryMax - j*((ImagneryMax-ImagneryMin)/800);
				
				//doing given number of iterations for the point
				for(iter=0;iter <= Iterations;iter++) {
					real = x*x-y*y+cReal;
					imagenery = 2*x*y+cImg;
					
					//check whether ABS(Zn) > 2
					if((real*real + imagenery*imagenery) > 4) {
						float Brightness=1f;
						float Hue = (iter%256)/255.0f;
						g.setColor(Color.getHSBColor(Hue, Saturation, Brightness));
						g.drawLine(i, j, i, j);
						break;
						
					}
					else{
						x=real;
						y=imagenery;
					}
					
				}
				
				//if given number of iterations has completed
				if(iter==Iterations+1) {
					g.setColor(Color.BLACK);
					g.drawLine(i, j, i, j);
				}
				
			}
		}
		
	
	}

}
