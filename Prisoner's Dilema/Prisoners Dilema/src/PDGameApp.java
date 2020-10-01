import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*********************************************************************
 PROGRAM:    Prisoners Dillema
 PROGRAMMER: Cristian Aguirre
 
 FUNCTION:   This assignment practices writing multiple Java classes, 
 and using several Java library classes to do I/O and simple collection 
 operation, such as Scanner, ArrayList and HashMap. 
*********************************************************/



public class PDGameApp extends JFrame implements ActionListener, ListSelectionListener{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//instance variables for PDGameApp, all methods can access here
	
	//Default list model is the standard "mode for how a JList will be operated, will put in next statements bellow
	private final DefaultListModel<String>listModelPtr = new DefaultListModel<String>();
	
	//this is list on top left side and will show times of games played that users will click to see stats of the game 
	private JList<String>finishedGamesList = new JList<String>(listModelPtr);
	
	//combo box on right side, pointer will be filled in constructor
	private JComboBox<Object>computerStrategyCB = null;
	
	private final JTextArea gameResultsTA = new JTextArea(15,30); //this is large text on the right side
	
	//PDGame object 
	private PDGame currentPDGame = null;
	
	private String gameStartTimeStr = null;
	private final HashMap<String, GameStat> stats = new HashMap<>();
	
	public int computerStrategy = 1;//this will be filed by the choice made by the user in the combo box
	
	//below are some sample text fields, more are needed…….
	private final JLabel roundsPlayedLB = new JLabel("Rounds Played");
	private final JTextField roundsTF = new JTextField(10);
	
	private final JLabel computerStrategyLB = new JLabel("Computer Strategy");
	private final JTextField computerStrategyTF = new JTextField(10);
	
	private final JLabel playerSentence = new JLabel("Player Sentence");
	private final JTextField playerSentenceTF = new JTextField(10);
	
	private final JLabel computerSentenceLB = new JLabel("Computer Sentence");
	private final JTextField ComputerSentenceTF = new JTextField(10);
	
	private final JLabel winnerLB = new JLabel("Winner");
	private final JTextField winnerTF = new JTextField(10);
	
	
	
	//right hand 
	private final JLabel computerStrategyL = new JLabel("Computer Strategy");
	private final JButton startB = new JButton("Start New Game");
	private final JLabel decisionL = new JLabel("Your decision this round?");
	private final JButton remainSilentBTN = new JButton("Ramain Silent");
	private final JButton testifyBTN = new JButton("Testify");

	public String decisionST = "\n\nWhat is your decision this round?\n";

	
	
	
	public static void main(String[] args) {
		PDGameApp game = new PDGameApp();
		createAndShowGUI(); //start the program
		
	
		
    }
	
	
	public static void createAndShowGUI(){  //class so we can work on
		
		//calling constructor bellow to set the window to user
		PDGameApp pdg1 = new PDGameApp();
		pdg1.addListeners(); //method will add listeners to buttons
		
		
	}
	
	
	//constructor where I build the SWING Interface
	public PDGameApp() {
		
		//super("Prisoner"); //fills in the menu of JFrame with message 
		currentPDGame = new PDGame("/Users/cristianaguirre/Documents/pdGame/ComputerOutput.txt");
		
		//setting the frame first 
		JFrame framePtr = new JFrame("Prisioners Dilema Game");

		
		
		
		setLayout(new BorderLayout());
		
		//set up the left and right panels
		JPanel panel1 = new JPanel(new BorderLayout());
		Color cBlue = new Color(147,173,196); //blue color
		
		
		//panel 2
		JPanel panel2 = new JPanel(new BorderLayout());

		

		
		finishedGamesList.setFont(new Font("SansSerif", Font.BOLD, 24));
		finishedGamesList.setVisibleRowCount(10);
		finishedGamesList.setFixedCellWidth(350);
		finishedGamesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//adding JPanel to the South of left
		GridLayout layout = new GridLayout(5,2,5,5);
		JPanel statusPanel = new JPanel(layout);
		
		//adding the color blue 
		statusPanel.setBackground(cBlue);
		panel1.setBackground(cBlue);
		
		//setting all text fields to not editable
		roundsTF.setEditable(false);
		computerStrategyTF.setEditable(false);
		playerSentenceTF.setEditable(false);
		ComputerSentenceTF.setEditable(false);
		winnerTF.setEditable(false);
		
		
		
		//adding everything to the panel
		statusPanel.add(roundsPlayedLB);
		statusPanel.add(roundsTF);
		statusPanel.add(computerStrategyLB);
		statusPanel.add(computerStrategyTF);
		statusPanel.add(playerSentence);
		statusPanel.add(playerSentenceTF);
		statusPanel.add(computerSentenceLB);
		statusPanel.add(ComputerSentenceTF);
		statusPanel.add(winnerLB);
		statusPanel.add(winnerTF);
		
		
		//title border    
		//for more of these go to https://docs.oracle.com/javase/tutorial/uiswing/components/border.html
		//
		Border loweredetched;
		loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder title;
		title = BorderFactory.createTitledBorder(loweredetched, "List of Games");
		title.setTitleJustification(TitledBorder.LEFT);
		panel1.setBorder(title);
		
		//adding stuff to the left panel
		panel1.add(new JScrollPane(finishedGamesList), BorderLayout.NORTH);
		panel1.add(statusPanel, BorderLayout.SOUTH);
	    //fill in other panels grids etc

		//Two statements below prepare the combo box with computer strategies, need to convert the strategies array list to an array , and then it gets placed in combo box
	   Object[] strategyArray = currentPDGame.GetStrategies().toArray();//convert AL to array
	      computerStrategyCB = new JComboBox<Object>(strategyArray);   //place array in combo box
	      computerStrategyCB.setEditable(false);
	      computerStrategyCB.setSelectedIndex(0); //this sets starting value to first string in array
	      
	      //adding stuff to right panel
	      GridLayout layout2 = new GridLayout(2,1,5,5);
	      JPanel buttonsPanel = new JPanel(layout2);
	      
	      Color cOrange = new Color(202,176,152); //orange color 
	      buttonsPanel.setBackground(cOrange);
	      
	      buttonsPanel.add(computerStrategyL);
	      buttonsPanel.add(computerStrategyCB);
	      buttonsPanel.add(startB);
	      buttonsPanel.add(decisionL);
	      remainSilentBTN.setEnabled(false);
	      buttonsPanel.add(remainSilentBTN);
	      testifyBTN.setEnabled(false);
	      buttonsPanel.add(testifyBTN);
	      
	      //bottom part of panel2
	      gameResultsTA.setRows(15);
	      gameResultsTA.setColumns(35);
	      gameResultsTA.setEditable(false);
	      
	      //adding the flow panels
	      JPanel flowPanelTop = new JPanel(new FlowLayout());
	      JPanel flowPanelBottom = new JPanel(new FlowLayout());
	      
	      //flowPanelTop.add(comp)
	      
	      panel2.setBackground(cOrange);
	      //panel2.add(flowPanelTop.add(buttonsPanel));

	      panel2.add(buttonsPanel,BorderLayout.NORTH );
	      panel2.add(new JScrollPane(gameResultsTA),BorderLayout.SOUTH);
	      

	      //adding to the frame
	      framePtr.add(panel1, BorderLayout.WEST); //add to the frame
	      framePtr.add(panel2, BorderLayout.EAST); //add to the frame

	      //frame constrains
	      framePtr.pack();
	    //  framePtr.setSize(800, 600);
	      framePtr.setVisible(true);
	      
	      

	      

	      
	         

	}
	
    int computerGame = 5, rounds = 5 ;
	
	//hook up listeners to buttons
	public void addListeners(){
		
		startB.addActionListener(this); //doing this for all the buttons 
		remainSilentBTN.addActionListener(this);
		testifyBTN.addActionListener(this);
		
		
		finishedGamesList.addListSelectionListener(this);//the JList event listener code is addListSelectionListener
	}
	
	
	//handler for what buttons where clicked and what was chosen by the combo box
	public void actionPerformed(ActionEvent event) {

		if(event.getSource() == startB){
			startGame();
		}
		else if(event.getSource() == remainSilentBTN){
			cooperate();
			
		}
		else if(event.getSource() == testifyBTN){
			betray();
		}
		
		else if (event.getSource() == computerStrategyCB) {  //when user chooses an item in combo box, this handles it
	         computerStrategy = computerStrategyCB.getSelectedIndex() + 1; //fills in this variable up top
	      }
	
	}//end of actionPerformed

	//function for start Game button 
	public void startGame() {
		
		computerGame = 0;
		remainSilentBTN.setEnabled(true);
		currentPDGame.setStrategy(computerStrategy);
		
		gameStartTimeStr = (new Date()).toString();
		stats.put(gameStartTimeStr, currentPDGame.gameStat);
		
		promptPlayer();
		playGame();
		//currentPDGame = new PDGame("/Users/cristianaguirre/Documents/pdGame/ComputerOutput.txt");
	}

	
	
	public void cooperate() {

		currentPDGame.playRound(1);
		gameResultsTA.append(currentPDGame.getCurrentStat());
		gameResultsTA.append(decisionST);
		computerGame++;
		
		playGame();
	}
	
	public void betray() {
		currentPDGame.playRound(2);
		gameResultsTA.append(currentPDGame.getCurrentStat());
		gameResultsTA.append(decisionST);
		computerGame++;
		
		playGame();
	}
	
	public void playGame() {
		
	      if (computerGame < 4)
	      {
	    	  remainSilentBTN.setEnabled(true);
	    	  testifyBTN.setEnabled(true);
	    	  
	      }
	      else if (computerGame > 4)
	      {
	    	  remainSilentBTN.setEnabled(false);
	    	  testifyBTN.setEnabled(false);
	    	  
	    	  computerStrategyL.setEnabled(true);
	    	  computerStrategyCB.setEnabled(true);
	    	  startB.setEnabled(true);
	    	  
	    	  gameResultsTA.append("Your total prison sentence is: "+ String.format("%d", currentPDGame.getCurrentUserYrs()) + " years\n");
	    	  gameResultsTA.append("Your partner's prison sentence is: "+ String.format("%d", currentPDGame.getCurrentCompYrs()) + " years\n");
	    	  
	    	 // rounds++;
	    	  //currentPDGame.setRound(rounds);
	    	  
	    	  listModelPtr.addElement(gameStartTimeStr);
	    	  
	    	  currentPDGame = new PDGame("/Users/cristianaguirre/Documents/pdGame/ComputerOutput.txt");
	      }
	      
	      
	      else if (computerGame > 5)
	      {
	    	 // currentPDGame = new PDGame("/Users/cristianaguirre/Documents/pdGame/ComputerOutput.txt");
	      }
	      
	      
	      
	      
	      
	      
	      
	}
	
	
	
	
	
	public void promptPlayer() {
		//disable startB and combo box and first label button until finished game 
		computerStrategyL.setEnabled(false);
		computerStrategyCB.setEnabled(false);
		startB.setEnabled(false);
		
		String promptST, choiceST;
		promptST = "\n***Prisoner's Dilemma***\n";
		choiceST = "1. Cooperate with your partner and remain silent.\n2. Betray and testify against your partner.\n";
		//decisionST = "\n\nWhat is your decision this round?\n";
		
		
		gameResultsTA.append(promptST);  
		gameResultsTA.append(choiceST);
		gameResultsTA.append(decisionST);
		
	}
	
	GameStat gameStat = new GameStat();
	
	
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		GameStat gsPtr;
		
	      if (!finishedGamesList.isSelectionEmpty()) {
	          gameStartTimeStr = (String) finishedGamesList.getSelectedValue(); //get out time of game and look up in hash map
	          //hash map games info 
	          gsPtr = stats.get(gameStartTimeStr);
	          
	                  
	          roundsTF.setText(String.format("%d", rounds));
	          roundsTF.setFont( new Font("SansSerif", Font.BOLD, 20));
	          
	          computerStrategyTF.setFont( new Font("SansSerif", Font.BOLD, 20));
	          computerStrategyTF.setText(gsPtr.getStrat());

	          playerSentenceTF.setFont( new Font("SansSerif", Font.BOLD, 20));
	          playerSentenceTF.setText(String.format("%d %s", gsPtr.getUserTotalYrs(), ((gsPtr.getUserTotalYrs() > 1) ? " years" : " year")));
	          
	          ComputerSentenceTF.setFont( new Font("SansSerif", Font.BOLD, 20));
	          ComputerSentenceTF.setText(String.format("%d %s", gsPtr.getComputerTotalYrs(), ((gsPtr.getComputerTotalYrs() > 1) ? " years" : " year")));
	          
	          winnerTF.setFont( new Font("SansSerif", Font.BOLD, 20));
	          winnerTF.setText(gsPtr.getWinner());
	      }

		
	}
}


/*


//setting all text fields to not editable
roundsTF.setEditable(false);
computerStrategyTF.setEditable(false);
playerSentenceTF.setEditable(false);
ComputerSentenceTF.setEditable(false);
winnerTF.setEditable(false);
*/







