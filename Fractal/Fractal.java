import java.awt.*; /* java abstract window toolkit */
import java.awt.event.*; 
import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.Random;

public class Fractal {

	public static void main(String[] args) {
		
		String Command=null;
		
		//check arguments
		try {
			Command=args[0];
		}
		catch(IndexOutOfBoundsException ex){
			System.out.println("Wrong Argument");
		}finally {
			
			if(Command.equals("Mandelbrot")) {
				
				//check if the arguments count is 1,5,6
				if(args.length==1 || args.length==5 || args.length==6) {
					//argument number for Mandelbrot is correct
					if(args.length==1) {
						Mandelbrot mSet=new Mandelbrot();
						Mandelbrot.createFrame("Mandelbrot", mSet);
					}
					else if(args.length==5) {
						Mandelbrot mSet=new Mandelbrot(Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]));
						Mandelbrot.createFrame("Mandelbrot", mSet);
					}
					else if(args.length==6) {
						Mandelbrot mSet=new Mandelbrot(Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Integer.parseInt(args[5]));
						Mandelbrot.createFrame("Mandelbrot", mSet);
					}
				}
				else {
					System.out.println("Wrong Number of Arguments");
				}
				
			}
			else if(Command.equals("Julia")) {
				
				//check if the arguments count is 1,4
				if(args.length==1 || args.length==4 ) {
					//argument number for Julia is correct
					if(args.length==1) {
						Julia jSet=new Julia();
						Julia.createFrame("Julia",jSet);
							
					}
					else if(args.length==4 ) {
						//Julia.createFrame("Julia");
						Julia jSet = new Julia(Double.parseDouble(args[1]),Double.parseDouble(args[2]),Integer.parseInt(args[3]));
						Julia.createFrame("Julia",jSet);
					}
				}
				else {
					System.out.println("Wrong Number of Arguments");
				}
				
			}
			else {
				System.out.println("Wrong Argument");
			}
			
		}
		
		
		

	}

}
