import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/*********************************************************************
 PROGRAM:    CSCI 470 Assignment 6
 PROGRAMMER: Cristian Aguirre
 LOGON ID:   Z1824863
 DUE DATE:   12/09/19
 
 FUNCTION:   This assignment practices using paint 
 and different panels plus using mouse clicking. 
*********************************************************/



public class MainPanel extends JPanel implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String[] imageStringNameA = {"pat1.gif","pat2.gif","pat3.gif","pat4.gif","pat5.gif"};	

	final static Image[] imageA = new Image[5];//image arr holds 5 images we load using toolkit code
	
	JFrame frame; 
	
	//panels 
	JPanel topPanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	

	JToolBar MainPanelToolBar = new JToolBar(); //pointer to toolbar for main panel
	TileGridPanel tileGridPanelPtr=new TileGridPanel(); //pointer to area where we will “paint” itmes on a tile Grid
	
	//adding ball panel
	BallAnimation ballPanelPtr = new BallAnimation();

	//paint buttons
	JButton patch1btn, patch2btn, patch3btn, patch4btn, patch5btn; //need to declare 5 buttons….and a reset button
	JButton resetBTN = new JButton("Reset"); //adding reset button
	
	
	
	

	public MainPanel(){		//code the toolkit code that I have shown earlier that loads the images into the one dimensional imagaA
	
		//adding colors
		//Color cGreen = new Color(0,216,40);
		Color cOrange = new Color(255,201,40);
		Color cYellow = new Color(255,255,50);
		Color cPink = new Color(255,175,176);
		
		//setting the top orange
		this.setBackground(cOrange);
		
		//to add the images to an array of images 
		for(int i = 0; i<imageA.length; i++) {
			imageA[i] = (Image) Toolkit.getDefaultToolkit().getImage(imageStringNameA[i]);
		}
		
		this.setLayout(new BorderLayout()); //we will add items to north, center south on main panel
		
	    //prepare north area of main panel 
		patch1btn = new JButton(new ImageIcon(imageA[0]));  //this how you get a button with an image
		patch2btn = new JButton(new ImageIcon(imageA[1]));
		patch3btn = new JButton(new ImageIcon(imageA[2]));
		patch4btn = new JButton(new ImageIcon(imageA[3]));
		patch5btn = new JButton(new ImageIcon(imageA[4]));
		
		//preparing and adding toolbar
		MainPanelToolBar.add(patch1btn); //add 1 button to toolbar, do this for 5 buttons
		MainPanelToolBar.add(patch2btn);
		MainPanelToolBar.add(patch3btn);
		MainPanelToolBar.add(patch4btn);
		MainPanelToolBar.add(patch5btn);
		

		
		//adding to the panels north
		this.add(MainPanelToolBar,BorderLayout.NORTH);
		
		//prepare center area of panel
		tileGridPanelPtr.setBackground(cYellow);
		add(tileGridPanelPtr, BorderLayout.CENTER); //Adding centerPanel to mainPanel.
		
		
		
		//bottom panel
		resetBTN.addActionListener((ActionListener) this);
		bottomPanel.add(resetBTN);
		bottomPanel.setBackground(cPink);
		add(bottomPanel, BorderLayout.SOUTH);

		//tileGridPanelPtr.ResetGridTile(); //reset grid and and paint empty center area		
		}//end constructor

	//adding listeners
		public void addListeners() {
			
			//adding listeners to the image buttons 
			patch1btn.addActionListener(this);
			patch2btn.addActionListener(this);
			patch3btn.addActionListener(this);
			patch4btn.addActionListener(this);
			patch5btn.addActionListener(this);
			
			//reset btn 
			resetBTN.addActionListener(this);

		}
		int selected;

	//also add panel with reset button to the south
	public void actionPerformed(ActionEvent e) {  //put in listener method for button clicks on toolbar
		   
		if (e.getSource() == patch1btn) {  //was  button A  clicked in toolbar?
			
			//imageA[0];
			
			System.out.print("first button click\n");
			
			tileGridPanelPtr.selectedTile = 0;
			
	    tileGridPanelPtr.setSelectedTitle(selected);  //this sets the variable in tileGridPanel object, need to check for the 5 button clicks
	    //tileGridPanelPtr.paintComponent(null);
		}
		else if(e.getSource() == patch2btn) { 
		    tileGridPanelPtr.selectedTile = 1;
		}
		
		else if(e.getSource() == patch3btn) { 
		    tileGridPanelPtr.selectedTile = 2;
		}
		else if(e.getSource() == patch4btn) { 
		    tileGridPanelPtr.selectedTile = 3;
		}
		else if(e.getSource() == patch5btn) { 
		    tileGridPanelPtr.selectedTile = 4;
		}
		else if(e.getSource() == resetBTN) { 
		    tileGridPanelPtr.ResetGridTile();
		 
		}
	
	
	}
}
