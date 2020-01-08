
import java.awt.BorderLayout;

import javax.swing.JFrame;

/*********************************************************************
PROGRAM:    CSCI 470 Assignment 6
PROGRAMMER: Cristian Aguirre
LOGON ID:   Z1824863
DUE DATE:   12/09/19

FUNCTION:   This assignment practices using paint 
and different panels plus using mouse clicking. 
*********************************************************/


public class GraphicsFrame extends JFrame{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//here is main 
	public static void main(String[]args) {
		GraphicsFrame main = new GraphicsFrame();
		main.createAndShowGUI();

	}
	
	//function to show gui
	void createAndShowGUI() {

		GraphicsFrame frame = new GraphicsFrame(); //create the master frame
		frame.pack();
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
			
		//graphics frame to add listeners and create main panel 
		public GraphicsFrame() { //contructor
			  super();
			  MainPanel mainPanelPtr = new MainPanel();//create mainpanel that overwrites the frame
			  BallAnimation ballAnimationPtr = new BallAnimation();
			  	mainPanelPtr.addListeners();
			  	ballAnimationPtr.addListeners();
			  	//ballAnimationPtr.setSize(350, 350);
			  	
			     this.add(mainPanelPtr,BorderLayout.CENTER); //main panel covers entire frame
			     this.add(ballAnimationPtr, BorderLayout.EAST); //adding balls to the east
			     
			     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing on exit
			     
			     
		}
}





