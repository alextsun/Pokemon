import javax.swing.*;


public class Pokemon 
{
	private JFrame frame; //the jframe object
	private MainPanel mainPanel; //contains all of the panels with cardlayout
	private boolean isBoy;
	private String playerName = "Player";
	private String pkmn1, pkmn2, pkmn3, pkmn4, pkmn5, pkmn6;
	private int currentPokemon = 0, currentRivalPokemon = 0;
	private String[] playerPokemon = new String[6];
	private String[] rivalPokemon = new String[6];
	private int[] playerPokemonHP = new int[6];
	private int[] playerPokemonMAXHP = new int[6];
	private int[] rivalPokemonHP = new int[6];
	private int[] rivalPokemonMAXHP = new int[6];

	public static void main (String[] args)
	{
		Pokemon game = new Pokemon();
		game.run();
	}

	public void run()
	{
		frame = new JFrame("Pokemon"); //new jframe with game title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stop program when exit
		frame.setSize(900, 700); //size of jframe
		frame.setLocation(25, 15); //location of jframe
		mainPanel = new MainPanel(this); //new mainPanel object (has cardlayout)
		frame.add(mainPanel); //add mainpanel to frame
		frame.setVisible(true); //make it visible

		playerPokemonMAXHP[0] = 1227;
		playerPokemonMAXHP[1] = 1317;
		playerPokemonMAXHP[2] = 1453;
		playerPokemonMAXHP[3] = 1537;
		playerPokemonMAXHP[4] = 1643;
		playerPokemonMAXHP[5] = 2566;
		playerPokemonHP[0] = 1227;
		playerPokemonHP[1] = 1317;
		playerPokemonHP[2] = 1453;
		playerPokemonHP[3] = 1537;
		playerPokemonHP[4] = 1643;
		playerPokemonHP[5] = 2566;

	}

	public void switchToNextAlivePokemon()
	{
		for(int i = 0; i < 6; i++)
		{
			if(playerPokemonHP[i]>0)
			{
				setCurrentPokemon(i);
				break;
			}
		}
	}

	public void setPaulPokemon(int i)
	{
		//rayquaza, giratina, arcmaster
		//torterra, ursaring, garchomp
		//electivire, drapion, magmortar

		if(i==1) 
		{
			rivalPokemon[0] = "garchomp"; 
			rivalPokemon[1] = "electivire";
			rivalPokemon[2] = "drapion";
			rivalPokemon[3] = "ursaring";
			rivalPokemon[4] = "magmortar";
			rivalPokemon[5] = "torterra";
			rivalPokemonMAXHP[0] = 976;
			rivalPokemonMAXHP[1] = 1184;
			rivalPokemonMAXHP[2] = 1399;
			rivalPokemonMAXHP[3] = 1547;
			rivalPokemonMAXHP[4] = 1716;
			rivalPokemonMAXHP[5] = 6922;
			rivalPokemonHP[0] = 976;
			rivalPokemonHP[1] = 1184;
			rivalPokemonHP[2] = 1399;
			rivalPokemonHP[3] = 1547;
			rivalPokemonHP[4] = 1716;
			rivalPokemonHP[5] = 6922;
		}
		else if(i==2)
		{
			//magnegross, inferzard, charenite, freezeoark, torfreeza, torflara (blazetile)
			rivalPokemon[0] = "blazetile"; //charenite
			rivalPokemon[1] = "magnegross"; 
			rivalPokemon[2] = "inferzard"; 
			rivalPokemon[3] = "freezeoark";
			rivalPokemon[4] = "charenite"; //torfreeze
			rivalPokemon[5] = "torflara"; 
			rivalPokemonMAXHP[0] = 1676;
			rivalPokemonMAXHP[1] = 1884;
			rivalPokemonMAXHP[2] = 2199;
			rivalPokemonMAXHP[3] = 2237;
			rivalPokemonMAXHP[4] = 2801;
			rivalPokemonMAXHP[5] = 3501;
			rivalPokemonHP[0] = 1676;
			rivalPokemonHP[1] = 1884;
			rivalPokemonHP[2] = 2199;
			rivalPokemonHP[3] = 2237;
			rivalPokemonHP[4] = 2801;
			rivalPokemonHP[5] = 3501;
		}
		else if(i==3)
		{
			//latiaos, raytina, lugioh, kyodon, dialkia, zekhiram
			rivalPokemon[0] = "zekhiram";
			rivalPokemon[1] = "latiaos"; 
			rivalPokemon[2] = "dialkia"; 
			rivalPokemon[3] = "lugioh";
			rivalPokemon[4] = "kyodon"; 
			rivalPokemon[5] = "raytina"; 
			rivalPokemonMAXHP[0] = 1876;
			rivalPokemonMAXHP[1] = 2084;
			rivalPokemonMAXHP[2] = 2399;
			rivalPokemonMAXHP[3] = 2437;
			rivalPokemonMAXHP[4] = 3601;
			rivalPokemonMAXHP[5] = 5952;
			rivalPokemonHP[0] = 1876;
			rivalPokemonHP[1] = 2084;
			rivalPokemonHP[2] = 2399;
			rivalPokemonHP[3] = 2437;
			rivalPokemonHP[4] = 3601;
			rivalPokemonHP[5] = 5952;
		}
	}

	public void restoreRivalPokemonHP(int i)
	{
		rivalPokemonHP[i] = rivalPokemonMAXHP[i];
	}

	public void restorePlayerPokemonHP(int i)
	{
		playerPokemonHP[i] = playerPokemonMAXHP[i];
	}

	public boolean playerWin()
	{
		for(int i = 0; i < 6; i++)
		{
			if(rivalPokemonHP[i]!=0)
				return false;
		}
		return true;
	}

	public boolean rivalWin()
	{
		for(int i = 0; i < 6; i++)
		{
			if(playerPokemonHP[i]!=0)
				return false;
		}
		return true;
	}

	public boolean gameOver()
	{
		if(playerWin()||rivalWin())
			return true;
		return false;
	}

	public void setPlayerPokemonHP(int i)
	{
		playerPokemonHP[currentPokemon]-=i;
		if(playerPokemonHP[currentPokemon]<0)
			playerPokemonHP[currentPokemon] = 0;
	}

	public void decPlayerPokemonHP(int i)
	{
		playerPokemonHP[currentPokemon]-=i;
		if(playerPokemonHP[currentPokemon]<0)
			playerPokemonHP[currentPokemon] = 0;
	}

	public void decRivalPokemonHP(int i)
	{
		rivalPokemonHP[currentRivalPokemon]-=i;
		if(rivalPokemonHP[currentRivalPokemon]<0)
			rivalPokemonHP[currentRivalPokemon] = 0;
	}

	public boolean rivalPokemonAlive()
	{
		if(rivalPokemonHP[currentRivalPokemon]==0)
		{
			if(currentRivalPokemon<5)
				currentRivalPokemon++;
			return false;
		}
		return true;
	}

	public boolean playerPokemonAlive()
	{
		if(playerPokemonHP[currentPokemon]==0)
		{
			return false;
		}
		return true;
	}

	public int getPlayerPokemonMAXHP(int i)
	{
		return playerPokemonMAXHP[i];
	}

	public int getRivalPokemonMAXHP(int i)
	{
		return rivalPokemonMAXHP[i];
	}

	public int getPlayerPokemonHP(int i)
	{
		return playerPokemonHP[i];
	}

	public int getRivalPokemonHP(int i)
	{
		return rivalPokemonHP[i];
	}

	public String[] getRivalPokemon()
	{
		return rivalPokemon;
	}

	public String[] getPlayerPokemon()
	{
		return playerPokemon;
	}

	public int getCurrentRivalPokemon()
	{
		return currentRivalPokemon;
	}

	public void setRivalPokemon(int i)
	{
		currentRivalPokemon = i;
	}

	public int getCurrentPokemon()
	{
		return currentPokemon;
	}

	public int getPlayerPokemonHP(String name)
	{
		if(name.substring(10).equalsIgnoreCase(playerPokemon[0]))
		{
			return playerPokemonHP[0];
		}
		else if(name.substring(10).equalsIgnoreCase(playerPokemon[1]))
		{
			return playerPokemonHP[1];
		}
		else if(name.substring(10).equalsIgnoreCase(playerPokemon[2]))
		{
			return playerPokemonHP[2];
		}
		return 0;
	}

	public void setCurrentPokemon(String name)
	{
		if(name.substring(10).equalsIgnoreCase(playerPokemon[0]))
		{
			currentPokemon = 0;
		}
		else if(name.substring(10).equalsIgnoreCase(playerPokemon[1]))
		{
			currentPokemon = 1;
		}
		else if(name.substring(10).equalsIgnoreCase(playerPokemon[2]))
		{
			currentPokemon = 2;
		}
		else if(name.substring(10).equalsIgnoreCase(playerPokemon[3]))
		{
			currentPokemon = 3;
		}
		else if(name.substring(10).equalsIgnoreCase(playerPokemon[4]))
		{
			currentPokemon = 4;
		}
		else if(name.substring(10).equalsIgnoreCase(playerPokemon[5]))
		{
			currentPokemon = 5;
		}
	}

	public void setCurrentPokemon(int i)
	{
		currentPokemon = i;
	}

	public String getPlayerPokemon(int pkmn)
	{
		if(pkmn==1)
			return pkmn1;
		else if(pkmn==2)
			return pkmn2;
		else
			return pkmn3;
	}

	public void setPlayerPokemon(String name, int pkmn)
	{
		if(pkmn==1)
			pkmn1 = name;
		else if(pkmn==2)
			pkmn2 = name;
		else if(pkmn==3)
			pkmn3 = name;
		else if(pkmn==4)
			pkmn4 = name;
		else if(pkmn==5)
			pkmn5 = name;
		else if(pkmn==6)
			pkmn6 = name;
		if(pkmn==6)
		{
			playerPokemon[0] = pkmn1;
			playerPokemon[1] = pkmn2;
			playerPokemon[2] = pkmn3;
			playerPokemon[3] = pkmn4;
			playerPokemon[4] = pkmn5;
			playerPokemon[5] = pkmn6;
		}
	}

	public void setPlayerName(String name)
	{
		playerName = name;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public void setIsBoy(boolean b)
	{
		isBoy = b;
	}

	public boolean getIsBoy()
	{
		return isBoy;
	}

	public void showClassPanel() //switch to class panel
	{
		mainPanel.showClassPanel();
	}

	public void showPokemonPanel()
	{
		mainPanel.showPokemonPanel();
	}

	public void showActionPanel() //switch to action panel
	{
		mainPanel.showActionPanel();
	}

	public void showIntroPanel() //switch to intro panel
	{
		mainPanel.showIntroPanel();
	}
}
