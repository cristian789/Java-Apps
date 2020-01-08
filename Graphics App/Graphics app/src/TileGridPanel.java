import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;

import javax.swing.JPanel;

/*********************************************************************
PROGRAM:    CSCI 470 Assignment 6
PROGRAMMER: Cristian Aguirre
LOGON ID:   Z1824863
DUE DATE:   12/09/19

FUNCTION:   This assignment practices using paint 
and different panels plus using mouse clicking. 
*********************************************************/


class TileGridPanel extends JPanel implements MouseListener{
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		public TileGridPanel()
		{
			resetingImage();
			
			
			System.out.print("  running constructor 23 \n");
			CreateMouseListener();
		}
	
		
		
	//initiallizing image 
	String[] imageStringNameA = {"pat1.gif","pat2.gif","pat3.gif","pat4.gif","pat5.gif"};	
	
	static Image[] setImage = new Image[0];
	
	int selectedTile = -1; //this is set to 0-4 when user clicks on a button in toolbar
	
	
	
	//variables 
	static final int squareSide = 25; 
	int GridRow = 5,GridCol=5;	


	//the actual gif array that gets painted 
	Image[][] gif2dArray = new Image[5][5]; //we take gifs in here and draw in tilegrid
	
	public void setSelectedTitle(int selected)
	{
		selectedTile = selected;
		resetingImage();
	}
	
	
	
	
	public void ResetGridTile() {   
		
		//this resets all of the tiles to null 
		for (int j = 0; j < 5;j++)
		  {
			  for (int k=0; k < 5 ; k++)
			  {
			  
				  gif2dArray[j][k] = null;

			  }
		  }
		this.repaint();  //draw empty grid
		
		
	}
	
	//creaeted this function because when reseting we are nulling everything so this restores it
	private void resetingImage() {
		for(int i = 0; i<gif2dArray.length; i++) {
			  gif2dArray[i][i] = (Image) Toolkit.getDefaultToolkit().getImage(imageStringNameA[i]);
			}
	}
	
	//listener
	public void CreateMouseListener() {  //Adds mouseListener to Center panel..need mouse methods at bottom
	      addMouseListener(this);}
	

	
	@Override
	public void mouseClicked(MouseEvent e) { //user has clicked a tile on panel, now has clicked in the center panel
		// TODO Auto-generated method stub
		
		System.out.print("first mouse click\n ");

		
		this.repaint();  //show new grid with your images from 2d array
	}
	

	
	
	@Override
	public void paintComponent(Graphics g)	//paints the center panel with elements in 2darray
	{ 
		super.paintComponent(g);
		  int gridWidth = GridRow*squareSide;  //need to find center area of the center panel
		  int gridHeight = GridCol*squareSide;
		  int panelWidth = getWidth();
		  int panelHeight = getHeight();
		  int startX = (panelWidth-gridWidth)/2;//get starting point to draw grid based 
		  int startY = (panelHeight-gridHeight)/2;


		  
		 //if selected tile is more than or = to 0 paint it 
		if (selectedTile >= 0) {
		  
		  //for loop for painting into the graph
		  for (int j = 0; j < 5;j++)
		  {
			  for (int k=0; k < 5 ; k++)
			  {
			  g.drawImage(gif2dArray[selectedTile][selectedTile], startX+(squareSide*k), startY+(squareSide*j), this);

			  
			  }
		  }
		}
	}//end of paint 
	
	
	
	//mouse functions 
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub	
	}


}