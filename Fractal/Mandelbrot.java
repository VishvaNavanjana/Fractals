import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.Random;



public class Mandelbrot extends Panel {
	
	//Region of interest default values
	private double realMin=-1;
	private double realMax=1;
	private double ImagneryMin=-1;
	private double ImagneryMax=1;
	
	private int Iterations=1000;


	//constructors
	public Mandelbrot() {
		super();
	}
	
	public Mandelbrot(double realMin, double realMax, double imagneryMin, double imagneryMax) {
		super();
		this.realMin = realMin;
		this.realMax = realMax;
		this.ImagneryMin = imagneryMin;
		this.ImagneryMax = imagneryMax;
	}

	public Mandelbrot(double realMin, double realMax, double imagneryMin, double imagneryMax, int iterations) {
		super();
		this.realMin = realMin;
		this.realMax = realMax;
		this.ImagneryMin = imagneryMin;
		this.ImagneryMax = imagneryMax;
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
				double cReal = realMin + i*((realMax-realMin)/800);
				double cImg = ImagneryMax - j*((ImagneryMax-ImagneryMin)/800);
				
				double x=0,y=0;
				
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
