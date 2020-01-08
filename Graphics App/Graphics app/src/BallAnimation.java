import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


public class BallAnimation extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	AnimationPanel animationPanelPtr = new AnimationPanel();
	
	//start stop buttons
	JButton startBTN = new JButton("Start");
	JButton stopBTN = new JButton("Stop");
	
	//setting south panel 
	JPanel southPanel = new JPanel();
	
	//constructor 
	public BallAnimation() { //we have to add this panel to the east of main panel
		
		//setting the layout
		this.setLayout(new BorderLayout());
		
		//making stop button not enable as default until start
		stopBTN.setEnabled(false);
		
		//adding buttons 
		southPanel.add(startBTN);
		southPanel.add(stopBTN);
		
		animationPanelPtr.setBackground(Color.WHITE);
		
		
		add(animationPanelPtr, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		
	}
	
	//listener function
	public void addListeners() {
		
		//adding listeners
		startBTN.addActionListener(this);
		stopBTN.addActionListener(this);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == startBTN) {
			//enabling stop btn 
			stopBTN.setEnabled(true);
			startBTN.setEnabled(false);
			animationPanelPtr.start();
			//animationPanelPtr.run();

			//animation panel start() 
			
		}
		
		else if(e.getSource() == stopBTN) {
			//flip flop enable 
			startBTN.setEnabled(true);
			stopBTN.setEnabled(false);
			animationPanelPtr.stop();
			
			//stop balls
		}
		
	}

}




