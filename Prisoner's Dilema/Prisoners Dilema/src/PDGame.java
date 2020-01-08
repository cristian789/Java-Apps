
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/********************************************************************
This class represents the game itself and controls the logic for it. 
 It contains an ArrayList for keeping the user history, an array or 
 ArrayList of strings for each of the strategies you implement below, 
 a GameStat null reference object that when filled in will record the 
 game stats, a Scanner, and an integer to determine the strategy the 
 computer is using.
********************************************************************/


public class PDGame{

    GameStat gameStat = new GameStat();

    ArrayList<String>Strategies = new ArrayList<>();
    ArrayList<Integer>game = new ArrayList<Integer>();

    private int counterFlag, setInStat;

    Scanner fileScanner = null;
    String prisonTime, inFile, winner;
   
    //PDGame constructor 
    public PDGame(String file)
    {
        inFile = file;
        //empty
    } 

    public String playRound(int decision)
    {
        
        
            if ((decision==1) && (game.get(gameStat.getRound()) == 1))                
            {
                prisonTime = "You both get 2 years in prison.\n";
                gameStat.update(decision, game.get(gameStat.getRound()));
                
                gameStat.setround(counterFlag + 1);
            }

            //If the player betrays and the computer remains silent, the 
            //player gets 1 year in prison and the computer gets 5 years in prison.             
            else if((decision==2) && (game.get(gameStat.getRound()) == 1))
            {
                prisonTime = "You get 1 year in prison and they get 5.\n";
                gameStat.update(decision, game.get(gameStat.getRound()));

                gameStat.setround(counterFlag + 1);
            }
            else if((decision==1) && (game.get(gameStat.getRound()) == 2))
            {
                prisonTime = "You get 5 years in prison and they get 1.\n";
                gameStat.update(decision, game.get(gameStat.getRound()));

                gameStat.setround(counterFlag + 1);
            }
            else if((decision==2) && (game.get(gameStat.getRound()) == 2))
            {
                prisonTime = "You both get 3 years in prison.\n";
                gameStat.update(decision, game.get(gameStat.getRound()));

                gameStat.setround(counterFlag + 1);
            }


        return prisonTime;
    }

    ArrayList<String>GetStrategies()
    {
        Strategies.add("Computer Reads Strategy From Input File");
        Strategies.add("Tit-For-Tat");
        Strategies.add("Tit-For-Two-Tats");
        Strategies.add("Random Choice by Computer");
        return Strategies;
    }

    //we get the scores from the GameStat method
    public String getScores()
    {
        return gameStat.getWinner();
    }

    public ArrayList<String> getStats() 
    {
    	return GetStrategies(); 
    }

    //
    public void setStrategy(int strategy)
    {
        setInStat = strategy;
        gameStat.setStrat(strategy);

        if (strategy == 1)
        {
            try {
                File file1 = new File(inFile); //this should read a file with 1's or 2's in it 
                fileScanner = new Scanner(file1); 
                while(fileScanner.hasNextInt())
    
                {
                    if(fileScanner.hasNextInt())
                    {
                        game.add(fileScanner.nextInt());
                    }
                    
                }
                fileScanner.close(); //close the file if its there 
                
            } catch (FileNotFoundException e) {
                System.out.println("The file was not found... ERRO OPENING FILE \n");
            }

        }

        //tit-for-tat
        else if (strategy == 2)
        {
            //priming the arrayList 
            game.add(1);//index 0
            game.add(1);//index 1
            game.add(1);//index 2
            //tit for tat
            //if round 1 then cooperate
            if (gameStat.getRound() == 0)
            {//add 1 which means cooperate on first round
                //add to index 1 a 1
                game.add(0, 1);
            }

            /////round 2
            else if(gameStat.getRound() == 1)
            {
                if (gameStat.getUserDecision() == 1)
                {
                    //should be in index 2 a 2
                    game.add(1, 2);
                }
                else if(gameStat.getUserDecision() == 2)
                {
                    //add to index 2 a 1 (index, int)
                    game.add(1, 1);
                }
            }

            ////round 3
            else if(gameStat.getRound() ==2)
            {
                if (gameStat.getUserDecision() == 1)
                {
                    //should be in index 3
                    game.add(2, 2);
                }
                else if(gameStat.getUserDecision() == 2)
                {
                    game.add(2, 1);
                }
            }

        }

        //tit-for-two-tats
        else if (strategy == 3)
        {
            //priming arrayList
            game.add(1);
            game.add(1);
            game.add(1);

            //tit for two tats
            //if round 1 then cooperate
            if (gameStat.getRound() == 0)
            {//add 1 which means cooperate on first round with index 0
                game.add(0,1);
            }

            else if (gameStat.getRound() == 1)
            {//add 1 which means cooperate on second round with index 1
                game.add(1,1);
            }

            /////round 3
            else if(gameStat.getRound() == 2)
            {
                if (gameStat.getUserDecision() == 1)
                {
                    //should be in index 3 
                    game.add(2, 1);
                }
                else if(gameStat.getUserDecision() == 2)
                {
                    game.add(2,2);
                }
            }

        }

        //Random 
        else if (strategy == 4)
        {
                        //priming arrayList
            game.add(1);
            game.add(1);
            game.add(1);
            int randomNum = (int)(Math.random() * 2+1);

            //tit for two tats
            //if round 1 then cooperate
            if (gameStat.getRound() == 0)
            {//add 1 which means cooperate on first round with index 0
                
                game.add(0,randomNum);
            }

            else if (gameStat.getRound() == 1)
            {//add 1 which means cooperate on second round with index 1
                game.add(1,randomNum);
            }

            /////round 3
            else if(gameStat.getRound() == 2)
            {
                if (gameStat.getUserDecision() == 1)
                {
                    //should be in index 3 
                    game.add(2, randomNum);
                }
                else if(gameStat.getUserDecision() == 2)
                {
                    game.add(2,randomNum);
                }
            }
        }
        else 
        {
            //error please input 1-4
        }
    }
    
    public void setRound(int round)
    {
    	gameStat.setround(round);
    }
    
    public String getCurrentStat()
    {
        return gameStat.getGameStats();
    }
    
    public int getCurrentUserYrs() {
    	return gameStat.getUserTotalYrs();
    }
    
    public int getCurrentCompYrs() {
    	return gameStat.getComputerTotalYrs();
    }
    
    
    
}