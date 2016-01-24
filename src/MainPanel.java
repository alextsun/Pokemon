//Alex Tsun
//5/24/13
//MainPanel.java
//This panel has a cardlayout and contains all of the
//other panels in it, and switches to the next panel
//when necessary.

//necessary imports
import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel
{
	private CardLayout cards; //the cardlayout
	
	//the different panels
	private MenuPanel menuPanel;
	private IntroPanel introPanel; //first panel, has instructions, new game, resume game, hall of fame
	private PokemonPanel pokemonPanel;
	private ActionPanel actionPanel; //the panel where battling occurs
	private Pokemon game;
	
	public MainPanel(Pokemon p)
	{
		game = p;
		cards = new CardLayout();
		this.setLayout(cards); //set layout to cardlayout

		//pass game to other panels; they need information about player/monster
		menuPanel = new MenuPanel(p);
		introPanel = new IntroPanel(p);
		pokemonPanel = new PokemonPanel(p);
		actionPanel = new ActionPanel(p);
		
		//add panels to cardlayout
		this.add(menuPanel, "Menu Panel");
		this.add(introPanel, "Intro Panel");
		this.add(pokemonPanel,"Pokemon Panel");
		this.add(actionPanel, "Action Panel");
	}
	
	
	public void showClassPanel() //switch to class panel
	{
		cards.show(this, "Class Panel");
	}
	
	public void showPokemonPanel()
	{
		cards.show(this, "Pokemon Panel");
	}
	
	public void showActionPanel() //switch to action panel
	{
		actionPanel.startTrapezoid();
		cards.show(this, "Action Panel");
	}
	
	public void showIntroPanel() //switch to intro panel
	{
		cards.show(this, "Intro Panel");
	}
}