import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/*********************************************************************
PROGRAM:    CSCI 470 Assignment 6
PROGRAMMER: Cristian Aguirre
LOGON ID:   Z1824863
DUE DATE:   12/09/19

FUNCTION:   This programs uses the functionallity of 
paint and threads working together using various classes
and integrated functions withing the Java library
*********************************************************/


public class AnimationPanel extends JPanel implements Runnable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	


	
	//all my variables
	ArrayList<Ball> ballPtr = new ArrayList<>();
	
	Dimension dimensionObjPtr = null;
	
	//Runnable runnable = new AnimationPanel();
	//AnimationPanel runnable = new AnimationPanel();
	
	Thread threadObjPtr = null;
	
	Ball ballObj1, ballObj2, ballObj3, ballObj4, ballObj5;
	
	//constructor
	public AnimationPanel() {
		
		this.setLayout(new BorderLayout());
		//this.setSize(350, 350);
		Dimension dimensionObjPtrs = new Dimension(350,350);         //maybe here is the problem ????
		this.setPreferredSize(dimensionObjPtrs);
		//run();

	}
	
	
	@Override
    public void run() {         //Overriden run so that Runnable works and that the threads can function.
        while(threadObjPtr != null)      //While the thread is active...
        {
            try         //Try/catch to make sure that if there is an issue, it is caught by the system.
            {
				Thread.sleep(2);       //10 milisecond wait time. Very quick to make the animation seem seamless.
                //System.out.print("New thread\n ");
            }
            catch (InterruptedException ex)     //Catch for the interupt.
            {
                ex.printStackTrace();
            } 
            
            repaint();      //Repaints everything when it needs to be refreshed.
        }
    }
	
	
	public void start() {
		
		//making it runnable
		if(threadObjPtr == null) {
			threadObjPtr = new Thread(this);
			threadObjPtr.start();
			//this.repaint();
			//run();
		}
		
		
	}
	
	public void stop() {
		//terminating the threadPtr
		threadObjPtr = null;
		
	}
	

	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		
		//colors 
		Color blue = new Color(0,0,251);
		Color red = new Color(255,11,19);
		Color green = new Color(0,255,44);
		Color gold = new Color(255,201,40);
		Color pink = new Color(255,0,252);
		
		super.paintComponent(g);
		
		if(dimensionObjPtr == null) {
			
			this.dimensionObjPtr = this.getSize();
			System.out.print("\n heree is the size " + dimensionObjPtr);
			
								//(Color col, int rad, int x, int y, int dx, int dy)
			//ballObj1 = new Ball(blue, (dimensionObjPtr.width * 2 / 3), (dimensionObjPtr.height - 28), -2, -4, 20);  
			
			ballObj1 = new Ball(Color.RED, 10, dimensionObjPtr.width - 100, dimensionObjPtr.height - 100, -1, -4);
			ballObj2 = new Ball(pink, 13, dimensionObjPtr.width - 160, dimensionObjPtr.height - 160, -3, -3);
			ballObj3 = new Ball(Color.ORANGE, 20, dimensionObjPtr.width - 200, dimensionObjPtr.height - 200, -4, -3);
			ballObj4 = new Ball(Color.YELLOW, 8, dimensionObjPtr.width - 30, dimensionObjPtr.height - 30, -2, -1);
			ballObj5 = new Ball(Color.GREEN, 5, dimensionObjPtr.width - 50, dimensionObjPtr.height - 50, 3, 5);

		}

		ballPtr.add(ballObj1);
		ballPtr.add(ballObj2);
		ballPtr.add(ballObj3);
		ballPtr.add(ballObj4);
		ballPtr.add(ballObj5);
		
		for(Ball b: ballPtr)      //For all of the balls in the ArrayList...
        {
            b.move(dimensionObjPtr);       //... move the balls, but make sure that they are not outside of the passed in parameter.
            b.draw(g);      //Redraw the balls in their new position while erasing the old ones.
        }
		
		
	}//end of paint component 
	

	
	

}//end of class
