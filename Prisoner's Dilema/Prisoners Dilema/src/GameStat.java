
/********************************************************************
 This GameStat class represents the game itself and controls the 
 logic for it. It contains an ArrayList for keeping the 
 user history, an array or ArrayList of strings for each 
 of the strategies you implement below, a GameStat null 
 reference object that when filled in will record the 
 game stats, a Scanner, and an integer to determine the 
 strategy the computer is using. 
********************************************************************/

public class GameStat{

    private int userDecision, compDecison ,user;
    private int computer, flag;
    String currentStart, winner, stats, finalWinner;
    //this one increments the stats of the players 
    public void update(int userSentence, int compSentence)
    {
        //1 = remain in silent, 2 = betray
        //If both the players remain silent, both get 2 years in prison.
        if ((userSentence == 1) && (compSentence == 1))
        {
            user = user + 2;
            computer = computer + 2;
        }

        //If the player betrays and the computer remains silent, the 
        //player gets 1 year in prison and the computer gets 5 years in prison. 
        else if ((userSentence == 2) && (compSentence == 1))
        {
            user = user + 1;
            computer = computer + 5;
        }

        //If the player stays silent and the computer betrays, the 
        //player gets 5 years in prison and the computer gets 1 year in prison. 
        else if ((userSentence == 1) && (compSentence == 2))
        {
            user = user + 5;
            computer = computer + 1;
        }

        //If both the player and the computer betray, both get 3 years in prison.
        else if ((userSentence == 2) && (compSentence == 2))
        {
            user = user + 3;
            computer = computer + 3;
        }
        else if((userSentence == 0) || (compSentence == 0))
        {
            //dont do anything I'm just using input from the computer
        }
        else
        {
            
            System.out.println("\nINCORRECT INPUT!"); //never will get here 
        }

        userDecision = userSentence;
        compDecison = compSentence;
        

    }

    public String getWinner()
    {
        //whoever gets the least amount of years wins 
        if (user < computer)
        {
            winner = "Player";
        }
        else if (user == computer)
        {
            winner = "It's a Draw!";
        }
        else 
        {
            winner = "Your Partner";
        }
        return winner;
    }

    public void setround(int roundFlag)
    {
         flag = roundFlag;
    }

    public int getRound()
    {
        return flag;
    }

    public int getUserDecision()
    {
        return userDecision;
    }

    public String getGameStats()
    {
        //1 = remain in silent, 2 = betray
        if ((userDecision == 1) && (compDecison ==1))
        {
            stats = "\nYou and your partner remain silent.\nYou both get 2 years in prison.\n";
        }

        //If the player betrays and the computer remains silent, the 
        //player gets 1 year in prison and the computer gets 5 years in prison. 
        else if ((userDecision == 2) && (compDecison == 1))
        {
            stats = "\nYou testify against your partner and they remain silent.\nYou get 1 year in prison and they get 5.\n";
        }

        //If the player stays silent and the computer betrays, the 
        //player gets 5 years in prison and the computer gets 1 year in prison. 
        else if ((userDecision == 1) && (compDecison == 2))
        {
            stats = "\nYou remained silent and your partner testify against you.\nYou get 5 years in prison and they get 1.\n";
            user = user + 5;
            computer = computer + 1;
        }

        //If both the player and the computer betray, both get 3 years in prison.
        else if ((userDecision == 2) && (compDecison == 2))
        {
            stats = "\nYou both testify against each other you both get 3 yeasrd in prison.\n";
            user = user + 3;
            computer = computer + 3;
        }
        else if((userDecision == 0) || (compDecison == 0))
        {
        	stats = "theres nothing here";
            //dont do anything I'm just using input from the computer
        }
        else
        {
            
            System.out.println("\nINCORRECT INPUT!"); //never will get here 
        }
        

        return stats;
    }
    
    public void setStrat(int Strategy)
    {
    	if (Strategy == 1) {
    		currentStart = "Computer Reads Strategy From Input File";
    	}
    	
    	else if (Strategy == 2){
    		currentStart = "Tit-For-Tat";
    	}
    	
    	else if (Strategy == 3){
    		currentStart = "Tit-For-Two-Tats";
    	}
    	else if (Strategy == 4)
    	{
    		currentStart = "Random";
    	}

    }
    
    public String getStrat(){	
    	return currentStart;
    }
    
    
    
    public int getUserTotalYrs()
    {
    	return user;
    }
    
    public int getComputerTotalYrs()
    {
    	return computer;
    }
    

}











