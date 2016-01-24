import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ActionPanel extends JPanel implements ActionListener, KeyListener
{
	private Pokemon game;
	private JPanel panel, optionsPanel, attackPanel, bagPanel, pkmnPanel;
	private CardLayout cards;
	private JButton attack, bag, pkmn1, pkmn2, pkmn3, pkmn4, pkmn5, pkmn6;
	private JButton atk1, atk2, atk3, atk4;
	private int currentPokemonAttacks;
	private Dimension gameD = new Dimension(225,100);
	private Dimension pkmnButtonD = new Dimension(150,33);
	private String[] playerPokemon = new String[6]; //added now
	private String[] rivalPokemon = new String[6]; //added now
	private JProgressBar playerHPBar, rivalHPBar;
	private boolean prologue = true;
	private PrologueListener prologueListener = new PrologueListener();
	private Timer prologueTimer = new Timer(20, prologueListener);
	private PokeballListener pokeballListener = new PokeballListener();
	private Timer pokeballTimer = new Timer(20, pokeballListener);
	private int timesPrologueLeft = 40;
	private int rivalX = 485;
	private int playerX = 180; //110
	private int rivalBallX = 900, rivalBallY = 100;
	private int playerBallX = 0, playerBallY = 300;
	private int bounceCount = 0;
	private boolean isRivalBall = false, isPlayerBall = false;
	private PokemonListener pokemonListener = new PokemonListener();
	private Timer pokemonTimer = new Timer(350,pokemonListener);
	private int playerPokemonY = 200, rivalPokemonY = 5;
	private int moveUpDown = 0;
	private TrapezoidListener tListener = new TrapezoidListener();
	private Timer trapezoidTimer = new Timer(30,tListener);
	private int trapezoids = 0, leftTopX = 480, leftBottomX = 402, rightTopX = 480, rightBottomX = 402;
	private String[][] attacks = new String[9][4];
	private Color[][] attackColor = new Color[9][4];
	private int currentAttack;
	private AttackListener attackListener = new AttackListener();
	private Timer attackTimer = new Timer(50,attackListener);
	private int ballX = 280, ballY = 250, attackCount = 0;
	private ShadowListener shadowListener = new ShadowListener();
	private Timer shadowTimer = new Timer(70,shadowListener); //70
	private int shadowStep = 0, giratinaX = 435, giratinaY = 5;
	private HeavenlyListener heavenlyListener = new HeavenlyListener();
	private Timer heavenlyTimer = new Timer(50,heavenlyListener);
	private int heavenlyStep = 0;
	private FlyListener flyListener= new FlyListener();
	private Timer flyTimer = new Timer(50,flyListener);
	private int flyStep, rayquazaX = 435, rayquazaY = 5, pPokemonX = 40, pPokemonY = 200;
	private JButton[] fr = new JButton[6];
	private JButton toAttack, toBag, toOptions1, toOptions2;
	private boolean playerSwitched = false;
	private boolean[] frUsed = new boolean[6];
	private PlayerHPListener playerHPListener = new PlayerHPListener();
	private Timer playerhpTimer = new Timer(20,playerHPListener);
	private int numTimes = 0, totalDmg = 0, hpStep = 0;
	private String rivalAttack = "";
	private DracoListener dracoListener = new DracoListener();
	private Timer dracoTimer = new Timer(50,dracoListener);
	private int dracoStep = 0, dracoX = 435, dracoY = 85;
	private FusionListener fusionListener = new FusionListener();
	private Timer fusionTimer = new Timer(30,fusionListener);
	private int fusionStep;


	public ActionPanel(Pokemon p)
	{
		game = p;
		this.setBackground(Color.black);
		addKeyListener(this);
		requestFocus();

		attacks[0][0] = "Fire Ball";  //chartoise
		attackColor[0][0] = Color.red;
		attacks[0][1] = "Hydro Cannon";
		attackColor[0][1] = Color.blue;
		attacks[0][2] = "Shadow Ball";
		attackColor[0][2] = Color.black;
		attacks[0][3] = "Ice Ball";
		attackColor[0][3] = Color.cyan;
		attacks[1][0] = "Fire Ball"; //Venuizard
		attackColor[1][0] = Color.red;
		attacks[1][1] = "Energy Ball";
		attackColor[1][1] = Color.green;
		attacks[1][2] = "Shadow Ball";
		attackColor[1][2] = Color.black;
		attacks[1][3] = "Electro Ball";
		attackColor[1][3] = Color.yellow;
		attacks[2][0] = "Hydro Cannon";//blastusaur
		attackColor[2][0] = Color.blue;
		attacks[2][1] = "Energy Ball";
		attackColor[2][1] = Color.green;
		attacks[2][2] = "Shadow Ball";
		attackColor[2][2] = Color.black;
		attacks[2][3] = "Ice Ball";
		attackColor[2][3] = Color.cyan;
		attacks[3][0] = "Hydro Cannon"; //gyarakarp
		attackColor[3][0] = Color.blue;
		attacks[3][1] = "Shadow Ball";
		attackColor[3][1] = Color.black;
		attacks[3][2] = "Electro Ball";
		attackColor[3][2] = Color.yellow;
		attacks[3][3] = "Ice Ball";
		attackColor[3][3] = Color.cyan;
		attacks[4][0] = "Shadow Ball"; //blackhawk
		attackColor[4][0] = Color.black;
		attacks[4][1] = "Fire Ball";
		attackColor[4][1] = Color.red;
		attacks[4][2] = "Purple Ball";
		attackColor[4][2] = Color.magenta;
		attacks[4][3] = "Ice Ball";
		attackColor[4][3] = Color.cyan;
		attacks[5][0] = "Electro Ball"; //hopurple
		attackColor[5][0] = Color.yellow;
		attacks[5][1] = "Ice Ball";
		attackColor[5][1] = Color.cyan;
		attacks[5][2] = "Purple Ball";
		attackColor[5][2] = Color.magenta;
		attacks[5][3] = "Fire Ball";
		attackColor[5][3] = Color.red;
		attacks[6][0] = "Shadow Ball"; //aggroblack
		attackColor[6][0] = Color.black;
		attacks[6][1] = "Electro Ball";
		attackColor[6][1] = Color.yellow;
		attacks[6][2] = "Dragon Ball";
		attackColor[6][2] = Color.DARK_GRAY;
		attacks[6][3] = "Metal Ball";
		attackColor[6][3] = Color.LIGHT_GRAY;
		attacks[7][0] = "Fire Ball"; //dragphlosion
		attackColor[7][0] = Color.red;
		attacks[7][1] = "Dragon Ball";
		attackColor[7][1] = Color.DARK_GRAY;
		attacks[7][2] = "Shadow Ball";
		attackColor[7][2] = Color.black;
		attacks[7][3] = "Electro Ball";
		attackColor[7][3] = Color.yellow;
		attacks[8][0] = "Fire Ball"; //mamofire
		attackColor[8][0] = Color.red;
		attacks[8][1] = "Ice Ball";
		attackColor[8][1] = Color.cyan;
		attacks[8][2] = "Shadow Ball";
		attackColor[8][2] = Color.black;
		attacks[8][3] = "Hydro Cannon";
		attackColor[8][3] = Color.blue;

		playerHPBar = new JProgressBar(JProgressBar.HORIZONTAL,0,game.getPlayerPokemonHP(game.getCurrentPokemon()));
		rivalHPBar = new JProgressBar(JProgressBar.HORIZONTAL,0,game.getRivalPokemonHP(game.getCurrentRivalPokemon()));

		trapezoidTimer.setInitialDelay(2500);

		rivalHPBar.setBackground(Color.red);
		playerHPBar.setBackground(Color.red);

		rivalHPBar.setForeground(Color.green);
		playerHPBar.setForeground(Color.green);

		rivalHPBar.setBounds(55,90,240,25);
		playerHPBar.setBounds(555,310,240,25);

		rivalHPBar.setStringPainted(true);
		playerHPBar.setStringPainted(true);

		rivalHPBar.setVisible(false);
		playerHPBar.setVisible(false);

		cards = new CardLayout();

		this.setLayout(null);
		this.add(rivalHPBar);
		this.add(playerHPBar);

		optionsPanel = new JPanel();
		attackPanel = new JPanel();
		bagPanel = new JPanel();
		pkmnPanel = new JPanel();

		panel = new JPanel();
		panel.setLayout(cards);

		attack = new JButton("");
		bag = new JButton("");
		pkmn1 = new JButton("");
		pkmn2 = new JButton("");
		pkmn3 = new JButton("");
		pkmn4 = new JButton("");
		pkmn5 = new JButton("");
		pkmn6 = new JButton("");
		
		atk1 = new JButton("Attack 1");
		atk2 = new JButton("Attack 2");
		atk3 = new JButton("Attack 3");
		atk4 = new JButton("Attack 4");
		
		toAttack = new JButton("Attack");
		toBag = new JButton("Bag");
		toOptions1 = new JButton("Back");
		toOptions2 = new JButton("Back");

		bagPanel.setLayout(new GridLayout(4,2));
		for(int i = 0; i < 6; i++)
		{
			fr[i] = new JButton("Full Restore");
			fr[i].setActionCommand("fr"+i);
			fr[i].addActionListener(this);
			bagPanel.add(fr[i]);
			fr[i].setPreferredSize(gameD);
		}
		bagPanel.add(toAttack);
		bagPanel.add(toOptions1);

		attack.setActionCommand("Attack");
		toAttack.setActionCommand("Attack");
		bag.setActionCommand("Bag");
		toBag.setActionCommand("Bag");
		pkmn1.setActionCommand("Pokemon 1");
		pkmn2.setActionCommand("Pokemon 2");
		pkmn3.setActionCommand("Pokemon 3");
		pkmn4.setActionCommand("Pokemon 4");
		pkmn5.setActionCommand("Pokemon 5");
		pkmn6.setActionCommand("Pokemon 6");

		atk1.setActionCommand("Attack 1");
		atk2.setActionCommand("Attack 2");
		atk3.setActionCommand("Attack 3");
		atk4.setActionCommand("Attack 4");
		toOptions1.setActionCommand("back");
		toOptions2.setActionCommand("back");

		attack.addActionListener(this);
		bag.addActionListener(this);
		pkmn1.addActionListener(this);
		pkmn2.addActionListener(this);
		pkmn3.addActionListener(this);
		pkmn4.addActionListener(this);
		pkmn5.addActionListener(this);
		pkmn6.addActionListener(this);

		atk1.addActionListener(this);
		atk2.addActionListener(this);
		atk3.addActionListener(this);
		atk4.addActionListener(this);
		
		toAttack.addActionListener(this);
		toBag.addActionListener(this);
		toOptions1.addActionListener(this);
		toOptions2.addActionListener(this);

		optionsPanel.setLayout(new GridLayout(4,2));
		optionsPanel.add(attack);
		optionsPanel.add(bag);
		optionsPanel.add(pkmn1);
		optionsPanel.add(pkmn2);
		optionsPanel.add(pkmn3);
		optionsPanel.add(pkmn4);
		optionsPanel.add(pkmn5);
		optionsPanel.add(pkmn6);

		attackPanel.setLayout(new GridLayout(3,2));
		attackPanel.add(atk1);
		attackPanel.add(atk2);
		attackPanel.add(atk3);
		attackPanel.add(atk4);
		attackPanel.add(toBag);
		attackPanel.add(toOptions2);

		attack.setPreferredSize(new Dimension(150,101));
		bag.setPreferredSize(new Dimension(150,101));
		pkmn1.setPreferredSize(pkmnButtonD);
		pkmn2.setPreferredSize(pkmnButtonD);
		pkmn3.setPreferredSize(pkmnButtonD);
		pkmn4.setPreferredSize(pkmnButtonD);
		pkmn5.setPreferredSize(pkmnButtonD);
		pkmn6.setPreferredSize(pkmnButtonD);

		atk1.setPreferredSize(gameD);
		atk2.setPreferredSize(gameD);
		atk3.setPreferredSize(gameD);
		atk4.setPreferredSize(gameD);

		panel.setBounds(427,457,450,200);

		panel.add(optionsPanel, "Options");
		panel.add(attackPanel, "Attacks");
		panel.add(bagPanel, "Bag");
		panel.add(pkmnPanel, "Pokemon");

		this.add(panel);
	}

	public void keyPressed(KeyEvent e)
	{
		char ch = e.getKeyChar();
		if(ch=='e')
		{
			prologue = false;
			if(prologueTimer.isRunning())
				prologueTimer.stop();
			if(pokeballTimer.isRunning())
			{
				pokeballTimer.stop();
				leavePokeball();
			}
		}
	}

	public void keyTyped(KeyEvent e)
	{

	}

	public void keyReleased(KeyEvent e)
	{

	}

	public void updateBagButtons()
	{
		for(int i = 0; i < 6; i++)
		{
			fr[i].setText("Full Restore " + playerPokemon[i].toUpperCase());
			if(frUsed[i] || game.getPlayerPokemonHP(i)==0)
				fr[i].setBackground(Color.black);
		}
	}

	public void updateAttackButtons()
	{
		if(game.getCurrentPokemon()==0)
		{
			if(playerPokemon[0].equalsIgnoreCase("chartoise"))
				currentPokemonAttacks = 0;
			else if(playerPokemon[0].equalsIgnoreCase("venuizard"))
				currentPokemonAttacks = 1;
			else
				currentPokemonAttacks = 2;
		}
		else if(game.getCurrentPokemon()==1)
		{
			if(playerPokemon[1].equalsIgnoreCase("gyarakarp"))
				currentPokemonAttacks = 3;
			else if(playerPokemon[1].equalsIgnoreCase("blackhawk"))
				currentPokemonAttacks = 4;
			else
				currentPokemonAttacks = 5;
		}
		else
		{
			if(playerPokemon[2].equalsIgnoreCase("aggroblack"))
				currentPokemonAttacks = 6;
			else if(playerPokemon[2].equalsIgnoreCase("dragphlosion"))
				currentPokemonAttacks = 7;
			else
				currentPokemonAttacks = 8;
		}
		System.out.println("currentpokemonattacks = " + currentPokemonAttacks);
		atk1.setText(attacks[currentPokemonAttacks][0]);
		atk2.setText(attacks[currentPokemonAttacks][1]);
		atk3.setText(attacks[currentPokemonAttacks][2]);
		atk4.setText(attacks[currentPokemonAttacks][3]);
	}

	public void updatePokemonButtons()
	{
		System.out.println("updating pkmn buttons");
		attack.setText("Attack");
		bag.setText("Bag");
		pkmn1.setText("Switch to " + playerPokemon[0].toUpperCase());
		pkmn2.setText("Switch to " + playerPokemon[1].toUpperCase());
		pkmn3.setText("Switch to " + playerPokemon[2].toUpperCase());
		pkmn4.setText("Switch to " + playerPokemon[3].toUpperCase());
		pkmn5.setText("Switch to " + playerPokemon[4].toUpperCase());
		pkmn6.setText("Switch to " + playerPokemon[5].toUpperCase());

		if(game.getCurrentPokemon()==0)
			pkmn1.setBackground(Color.black);
		else
			pkmn1.setBackground(null);
		if(game.getCurrentPokemon()==1)
			pkmn2.setBackground(Color.black);
		else
			pkmn2.setBackground(null);
		if(game.getCurrentPokemon()==2)
			pkmn3.setBackground(Color.black);
		else
			pkmn3.setBackground(null);
		if(game.getCurrentPokemon()==3)
			pkmn4.setBackground(Color.black);
		else
			pkmn4.setBackground(null);
		if(game.getCurrentPokemon()==4)
			pkmn5.setBackground(Color.black);
		else
			pkmn5.setBackground(null);
		if(game.getCurrentPokemon()==5)
			pkmn6.setBackground(Color.black);
		else
			pkmn6.setBackground(null);

		for(int i = 0; i < 6; i++)
		{
			if(game.getPlayerPokemonHP(i)==0)
			{
				if(i==0)
				{
					pkmn1.setBackground(Color.black);
					pkmn1.setForeground(Color.black);
				}
				if(i==1)
				{
					pkmn2.setBackground(Color.black);
					pkmn2.setForeground(Color.black);
				}
				if(i==2)
				{
					pkmn3.setBackground(Color.black);
					pkmn3.setForeground(Color.black);
				}
				if(i==3)
				{
					pkmn4.setBackground(Color.black);	
					pkmn4.setForeground(Color.black);
				}
				if(i==4)
				{
					pkmn5.setBackground(Color.black);
					pkmn5.setForeground(Color.black);
				}
				if(i==5)
				{
					pkmn6.setBackground(Color.black);
					pkmn6.setForeground(Color.black);
				}
			}
		}
	}

	public boolean okayToClickButtons()
	{
		return !(pokeballTimer.isRunning()||prologue||attackTimer.isRunning()||
				trapezoidTimer.isRunning()||shadowTimer.isRunning()||
				heavenlyTimer.isRunning()||flyTimer.isRunning()||
				playerhpTimer.isRunning()||game.gameOver());
	}

	public void actionPerformed(ActionEvent e)
	{
		if(okayToClickButtons())
		{
			String m = e.getActionCommand();
			if(m.equals("Attack"))
			{
				updateAttackButtons();
				cards.show(panel,"Attacks");
			}
			else if(m.equals("Bag"))
			{
				updateBagButtons();
				cards.show(panel, "Bag");
			}
			else if(m.equals("Pokemon 1") && pkmn1.getBackground()!=Color.black)
			{
				switchPokemon(pkmn1.getText());
			}
			else if(m.equals("Pokemon 2") && pkmn2.getBackground()!=Color.black)
			{
				switchPokemon(pkmn2.getText());
			}
			else if(m.equals("Pokemon 3") && pkmn3.getBackground()!=Color.black)
			{
				switchPokemon(pkmn3.getText());
			}
			else if(m.equals("Pokemon 4") && pkmn4.getBackground()!=Color.black)
			{
				switchPokemon(pkmn4.getText());
			}
			else if(m.equals("Pokemon 5") && pkmn5.getBackground()!=Color.black)
			{
				switchPokemon(pkmn5.getText());
			}
			else if(m.equals("Pokemon 6") && pkmn6.getBackground()!=Color.black)
			{
				switchPokemon(pkmn6.getText());
			}
			else if(m.equals("Attack 1"))
			{
				System.out.println(attacks[currentPokemonAttacks][0]);
				currentAttack = 0;
				attackTimer.start();
				cards.show(panel, "Options");
			}
			else if(m.equals("Attack 2"))
			{
				System.out.println(attacks[currentPokemonAttacks][1]);
				currentAttack = 1;
				attackTimer.start();
				cards.show(panel, "Options");
			}
			else if(m.equals("Attack 3"))
			{
				System.out.println(attacks[currentPokemonAttacks][2]);
				currentAttack = 2;
				attackTimer.start();
				cards.show(panel, "Options");
			}
			else if(m.equals("Attack 4"))
			{
				System.out.println(attacks[currentPokemonAttacks][3]);
				currentAttack = 3;
				attackTimer.start();
				cards.show(panel, "Options");
			}
			else if(m.equals("fr0"))
			{
				useFullRestore(0);
			}
			else if(m.equals("fr1"))
			{
				useFullRestore(1);
			}
			else if(m.equals("fr2"))
			{
				useFullRestore(2);
			}
			else if(m.equals("fr3"))
			{
				useFullRestore(3);
			}
			else if(m.equals("fr4"))
			{
				useFullRestore(4);
			}
			else if(m.equals("fr5"))
			{
				useFullRestore(5);
			}
			else if(m.equals("back"))
			{
				cards.show(panel, "Options");
			}
		}
	}
	
	public void useFullRestore(int i)
	{
		if(!frUsed[i])
		{
			if(game.getPlayerPokemonHP(i)>0)
			{
				game.restorePlayerPokemonHP(i);
				frUsed[i] = true;
				updateHPBars();
				cards.show(panel,"Options");
				rivalMove();
			}
		}
	}

	public void switchPokemon(String name)
	{
		game.setCurrentPokemon(name);
		updatePokemonButtons();
		playerSwitched = true;
		enterPokeball(true,false);
		updatePokemonButtons();
		repaint();
	}

	public int getRandom(String b)
	{
		int random;
		if(b.equals("heavenly"))
			random = (int)(1500*Math.random()+1);
		else if(b.equals("fly"))
			random = (int)(350+600*Math.random());
		else if(b.equals("shadow"))
			random = (int)(500*Math.random()+700);
		else if(b.equals("fusion"))
			random = (int)(700*Math.random()+400);
		else if(b.equals("draco"))
			random = (int)(300*Math.random()+700);
		else
			random = (int)(450+650*Math.random());
		System.out.println(b+" does " + random + " dmg!");
		return random;
	}

	public void damagePlayer(String attackers)
	{
		rivalAttack = attackers;
		totalDmg = getRandom(rivalAttack);
		if(totalDmg>game.getPlayerPokemonHP(game.getCurrentPokemon()))
			totalDmg = game.getPlayerPokemonHP(game.getCurrentPokemon());
		if(game.getPlayerPokemonHP(game.getCurrentPokemon())<17)
			numTimes = totalDmg/(game.getPlayerPokemonHP(game.getCurrentPokemon())-1);
		else
			numTimes = totalDmg/17; //5
		if(numTimes==0)
			numTimes = 1;
		playerhpTimer.start();
		if(game.gameOver())
		{
			attack.setBackground(Color.black);
			bag.setBackground(Color.black);
		}
		updateBagButtons();	
	}

	class FusionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			fusionStep++;
			if(fusionStep>50)
			{
				fusionTimer.stop();
				fusionStep = 0;
				damagePlayer("fusion");
			}
			repaint();
		}
	}

	class DracoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			dracoStep++;
			if(dracoStep<8)
			{
				dracoY-=10;
			}
			else if(dracoStep<30)
			{
				dracoY+=20;
				dracoX-=20;
			}
			if(dracoStep>30)
			{
				dracoTimer.stop();
				dracoX = 435;
				dracoY = 85;
				dracoStep = 0;
				damagePlayer("draco");	
			}
			repaint();
		}
	}

	class PlayerHPListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int remainder = totalDmg-(totalDmg/numTimes)*numTimes;
			if(hpStep<numTimes)
			{
				if(game.getPlayerPokemonHP(game.getCurrentPokemon())!=0)
				{
					if(hpStep!=numTimes-1)
						game.decPlayerPokemonHP(totalDmg/numTimes);
					else
						game.decPlayerPokemonHP(totalDmg/numTimes+remainder);
					updateHPBars();
					hpStep++;
				}
				else
				{
					playerhpTimer.stop();
					hpStep = 0;
					numTimes = 0;
					totalDmg = 0;
				}
			}
			else
			{
				playerhpTimer.stop();
				hpStep = 0;
				numTimes = 0;
				totalDmg = 0;
			}
		}
	}

	class FlyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(flyStep<60)
			{
				if(flyStep<10)
				{
					rayquazaX-=35;
					rayquazaY+=14;
				}
				else if(flyStep<35)
				{
					rayquazaY-=20;
					pPokemonY-=20;
				}
				else
				{
					rayquazaY+=20;
					pPokemonY+=20;
				}
				flyStep++;
			}
			else
			{
				flyTimer.stop();
				flyStep = 0;
				rayquazaX = 435; 
				rayquazaY = 5;
				pPokemonX = 40;
				pPokemonY = 200;
				damagePlayer("fly");
			}
			repaint();
		}
	}

	class HeavenlyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(heavenlyStep<30) //23
				heavenlyStep++;
			else
			{
				heavenlyTimer.stop();
				heavenlyStep = 0;
				damagePlayer("heavenly");
			}
			repaint();
		}
	}

	class ShadowListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(shadowStep<20)
				shadowStep++;
			if(shadowStep<8)
			{
				if(shadowStep%2==0)
					giratinaX-=500;
				else
					giratinaX+=500;
			}
			else if(shadowStep<12)
			{
				giratinaX = 1000;
			}
			else if(shadowStep<20)
			{
				giratinaX = 70; //40
				giratinaY = 200;
			}
			else
			{
				giratinaX = 435;
				giratinaY = 5;
				shadowStep = 0;
				shadowTimer.stop();
				damagePlayer("shadow");
			}
			repaint();
		}
	}

	class AttackListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(attackCount<35)
			{
				if(attackCount<25)
				{
					ballX+=10;
					ballY-=5;

				}
				attackCount++;
			}
			else
			{
				ballX = 280;
				ballY = 250;
				attackCount = 0;
				attackTimer.stop();
				game.decRivalPokemonHP(getRandom("a"));
				updateHPBars();
				if(game.gameOver())
				{
					attack.setBackground(Color.black);
					bag.setBackground(Color.black);
				}
				else
				{
					if(game.rivalPokemonAlive())
					{
						rivalMove();
					}
					else
					{
						enterPokeball(false,true);
						pokeballTimer.start();
					}
				}
			}
			repaint();
		}
	}

	public void rivalMove()
	{
		String rivalPkmn = rivalPokemon[game.getCurrentRivalPokemon()];
		if(rivalPkmn.equalsIgnoreCase("raytina")||rivalPkmn.equalsIgnoreCase("torfreeza")
				||rivalPkmn.equalsIgnoreCase("torflara"))
		{
			shadowTimer.start();
		}
		else if(rivalPkmn.equalsIgnoreCase("latiaos")||rivalPkmn.equalsIgnoreCase("charenite")
				||rivalPkmn.equalsIgnoreCase("inferzard"))
		{
			flyTimer.start();
		}
		else if(rivalPkmn.equalsIgnoreCase("lugioh"))
		{
			heavenlyTimer.start();
		}
		else if(rivalPkmn.equalsIgnoreCase("kyodon")||rivalPkmn.equalsIgnoreCase("dialkia")
				||rivalPkmn.equalsIgnoreCase("magnegross"))
		{
			dracoTimer.start();
		}
		else if(rivalPkmn.equalsIgnoreCase("zekhiram")||rivalPkmn.equalsIgnoreCase("freezeoark"))
		{
			fusionTimer.start();
		}
		else //to be done
		{
			heavenlyTimer.start();
		}
		repaint();
	}

	public void updateHPBars()
	{
		playerHPBar.setValue(game.getPlayerPokemonHP(game.getCurrentPokemon()));
		playerHPBar.setString(game.getPlayerPokemonHP(game.getCurrentPokemon())+" / " +
				game.getPlayerPokemonMAXHP(game.getCurrentPokemon()));
		rivalHPBar.setValue(game.getRivalPokemonHP(game.getCurrentRivalPokemon()));
		rivalHPBar.setString(game.getRivalPokemonHP(game.getCurrentRivalPokemon())+" / " +
				game.getRivalPokemonMAXHP(game.getCurrentRivalPokemon()));
		repaint();
	}

	class TrapezoidListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			trapezoids++;
			if(trapezoids==1)
				updatePokemonButtons();
			repaint();
			if(trapezoids>50)
			{
				trapezoidTimer.stop();
				prologueTimer.start();
			}
		}
	}

	class PokeballListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			bounceCount++;
			if(isRivalBall)
			{
				rivalBallX-=8;
				if(bounceCount<20)
					rivalBallY-=10;
				else
					rivalBallY+=10;
			}
			if(isPlayerBall)
			{
				playerBallX+=5;
				if(bounceCount<20)
					playerBallY-=10;
				else
					playerBallY+=10;
			}
			if(bounceCount>40)
			{
				leavePokeball();
				enterNormal();

			}
			repaint();
		}
	}

	class PrologueListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			timesPrologueLeft--;
			if(timesPrologueLeft>0)
			{
				rivalX+=10;
				playerX-=10;
			}
			else
			{
				prologueTimer.stop();
				prologue = false;
				enterPokeball(true,true);
			}
			repaint();
		}
	}

	class PokemonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			moveUpDown++;
			moveUpDown%=8;
			if(moveUpDown<=3)
			{
				playerPokemonY-=2;
				rivalPokemonY-=2;
			}
			else
			{
				playerPokemonY+=2;
				rivalPokemonY+=2;
			}
			repaint();
		}
	}

	public void enterPokeball(boolean b, boolean c)
	{

		rivalBallY = 100;
		playerBallY = 300;
		rivalHPBar.setVisible(false);
		playerHPBar.setVisible(false);
		pokeballTimer.start();
		bounceCount = 0;
		isPlayerBall = b;
		isRivalBall = c;
	}

	public void leavePokeball()
	{
		updatePokemonButtons();
		updateHPBars();
		pokeballTimer.stop();
		if(playerSwitched)
		{
			rivalMove();
			playerSwitched = false;
		}
		isRivalBall = false;
		isPlayerBall = false;
		rivalBallX = 900;
		playerBallX = 0;
		bounceCount = 0;
	}

	public void enterNormal()
	{
		playerHPBar.setMaximum(game.getPlayerPokemonMAXHP(game.getCurrentPokemon())); //normal
		rivalHPBar.setMaximum(game.getRivalPokemonMAXHP(game.getCurrentRivalPokemon())); //wout max
		updateHPBars();
		rivalHPBar.setVisible(true);
		playerHPBar.setVisible(true);
		pokemonTimer.start();
	}

	public void startPrologue()
	{
		prologueTimer.start();
	}

	public void startTrapezoid()
	{
		trapezoidTimer.start();
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		requestFocus();

		g.setColor(Color.black);
		g.fillRect(0,0,1000,1000);

		g.drawImage(ImageIconFactory.getImage("battlefield.png"),0,0,885,453,this);

		playerPokemon = game.getPlayerPokemon();
		rivalPokemon = game.getRivalPokemon();

		g.setColor(Color.white);
		g.fillRoundRect(0,453,884,210,20,20);
		g.setColor(Color.black);
		g.fillRoundRect(5,458,874,200,20,20);



		if(trapezoidTimer.isRunning())
		{
			g.setColor(Color.red);
			int[] leftX = new int[4];
			int[] leftY = new int[4];
			leftX[0] = 0;
			leftX[1] = 0;
			leftX[2] = leftBottomX-10*trapezoids;
			leftX[3] = leftTopX-10*trapezoids;
			leftY[0] = 0; //150
			leftY[1] = 452; //230
			leftY[2] = 452; //230
			leftY[3] = 0; //150
			g.fillPolygon(leftX, leftY, 4);
			g.setColor(Color.blue);
			int[] rightX = new int[4];
			int[] rightY = new int[4];
			rightX[0] = rightTopX+10*trapezoids;
			rightX[1] = rightBottomX+10*trapezoids;
			rightX[2] = 900;
			rightX[3] = 900;
			rightY[0] = 0; //150
			rightY[1] = 452; //230
			rightY[2] = 452; //230
			rightY[3] = 0; //150
			g.fillPolygon(rightX, rightY, 4);
			g.setColor(Color.white);
			g.setFont(new Font("Times New Roman", Font.BOLD, 40));
			g.drawString(game.getPlayerName(),50,200);
			g.drawString("Paul",750,200);
		}

		if(prologue)
		{
			paintPrologue(g);
		}
		else if(isPlayerBall||isRivalBall)
		{
			paintPokeball(g);
			paintNormal(g, !isPlayerBall, !isRivalBall);
		}
		else
		{
			paintNormal(g, !isPlayerBall, !isRivalBall);
		}

		if(attackTimer.isRunning())
		{
			g.setColor(attackColor[currentPokemonAttacks][currentAttack]);
			g.fillOval(ballX, ballY, 75,75);
			//g.fillOval(ballX,ballY,20+4*attackCount,20+4*attackCount);
		}

	}

	public void paintPrologue(Graphics g)
	{
		g.drawImage(ImageIconFactory.getImage("rival.png"),rivalX,5,210,230,this);
		if(game.getIsBoy())
			g.drawImage(ImageIconFactory.getImage("boy.png"),playerX,190,210,270,this);
		else
			g.drawImage(ImageIconFactory.getImage("girl.png"),playerX,190,210,270,this);

		g.setFont(new Font("Times New Roman", Font.BOLD, 30));
		g.setColor(Color.white);
		g.drawString("Rival Paul would like to battle!",10,540);
	}

	public void paintPokeball(Graphics g)
	{
		if(isRivalBall)
			g.drawImage(ImageIconFactory.getImage("pokeballleft.png"),rivalBallX,rivalBallY,20,20,this);
		if(isPlayerBall)
			g.drawImage(ImageIconFactory.getImage("pokeballright.png"),playerBallX,playerBallY,20,20,this);

		g.setFont(new Font("Times New Roman", Font.BOLD, 27));
		g.setColor(Color.white);
		if(isRivalBall)
		{
			int c = game.getCurrentRivalPokemon();
			g.drawString("Paul: "+rivalPokemon[c].toUpperCase()+", stand by", 10, 540);
			g.drawString("for battle!", 10, 575);
		}
		if(isRivalBall&&isPlayerBall)
		{
			g.drawString("Paul: "+rivalPokemon[game.getCurrentRivalPokemon()].toUpperCase()+", stand by", 10, 540);
			g.drawString("for battle!", 10, 575);
			g.drawString("Go, "+playerPokemon[game.getCurrentPokemon()].toUpperCase()+"!", 10, 610);
		}
		else if(isPlayerBall)
			g.drawString("Go, "+playerPokemon[game.getCurrentPokemon()].toUpperCase()+"!", 10, 540);
	}

	public void paintNormal(Graphics g, boolean b, boolean c)
	{
		if(b)
		{
			if(game.playerPokemonAlive())
			{
				if(!flyTimer.isRunning())
					g.drawImage(ImageIconFactory.getImage(playerPokemon[game.getCurrentPokemon()]+".gif"),40,playerPokemonY,270,270,this);
				else if(flyTimer.isRunning()&&flyStep<35)
					g.drawImage(ImageIconFactory.getImage(playerPokemon[game.getCurrentPokemon()]+".gif"),pPokemonX,pPokemonY,270,270,this);
				else if(flyTimer.isRunning()&&flyStep>=35)
					g.drawImage(ImageIconFactory.getImage(playerPokemon[game.getCurrentPokemon()]+"down.gif"),pPokemonX,pPokemonY,270,270,this);
				g.setColor(Color.white);
				g.fillRoundRect(550,270,250,75,15,15);
				g.setColor(Color.black);
				g.setFont(new Font("Times New Roman", Font.BOLD, 16));
				g.drawString(playerPokemon[game.getCurrentPokemon()].toUpperCase()+"   LV. 100",560,290);
				g.setFont(new Font("Times New Roman", Font.BOLD, 13));
				g.drawString("HP:",560,307);
				playerHPBar.setVisible(true);
			}
			else
			{
				if(!game.gameOver())
				{
					isPlayerBall = true;
					game.switchToNextAlivePokemon();
					enterPokeball(true,false);
					paintPokeball(g);
				}
			}

		}

		if(c)
		{
			if(game.rivalPokemonAlive())
			{
				if(!shadowTimer.isRunning())
				{
					if(!flyTimer.isRunning())
					{
						g.drawImage(ImageIconFactory.getImage(rivalPokemon[game.getCurrentRivalPokemon()]+".png"),435,rivalPokemonY,300,230,this);
						if(dracoTimer.isRunning())
						{
							g.setColor(Color.orange);
							g.fillOval(dracoX, dracoY, 40, 40);
							g.fillOval(dracoX+45, dracoY, 40, 40);
							g.fillOval(dracoX+90, dracoY, 40, 40);
							g.fillOval(dracoX+135, dracoY, 40, 40);
							g.fillOval(dracoX+170, dracoY, 40, 40);
						}
						else if(fusionTimer.isRunning())
						{
							g.setColor(Color.blue);
							int delta = 5*fusionStep;
							int diameter = 125 + 2*delta;
							int copyX = 435;
							int copyY = 5;
							copyX-=delta;
							copyY-=delta;
							int copyFusionStep = fusionStep;
							if(fusionStep<12)
							{
								g.fillOval(copyX, copyY, diameter, diameter);
							}
							else if (fusionStep<46)
							{
								diameter-=(2*delta);
								copyY+=delta;
								copyX+=delta;
								g.fillOval(copyX-5*fusionStep, copyY+5*fusionStep, diameter, diameter);
							}
							else
							{
								diameter-=(2*delta);
								copyY+=delta;
								copyX+=delta;
								copyFusionStep--;
								g.fillOval(copyX-5*copyFusionStep, copyY+5*copyFusionStep, diameter, diameter);
							}
						}
					}
					else if(flyTimer.isRunning() && flyStep<35)
						g.drawImage(ImageIconFactory.getImage(rivalPokemon[game.getCurrentRivalPokemon()]+".png"),rayquazaX,rayquazaY,300,230,this);
					else if(flyTimer.isRunning() && flyStep>=35)
						g.drawImage(ImageIconFactory.getImage(rivalPokemon[game.getCurrentRivalPokemon()]+"down.png"),rayquazaX,rayquazaY,300,230,this);
				}
				else
				{
					if(shadowStep>=12)
					{
						int delta = 5*shadowStep;
						int diameter = 175 + 2*delta;
						int copyX = giratinaX+50;
						int copyY = giratinaY+30;
						copyX-=delta;
						copyY-=delta;
						g.fillOval(copyX, copyY, diameter, diameter);
					}
					if(shadowStep%2==0)
						g.drawImage(ImageIconFactory.getImage(rivalPokemon[game.getCurrentRivalPokemon()]+".png"),giratinaX,giratinaY,300,230,this);
				}
				g.setColor(Color.white);
				g.fillRoundRect(50,50,250,75,15,15);
				g.setColor(Color.black);
				g.setFont(new Font("Times New Roman", Font.BOLD, 16));
				g.drawString(rivalPokemon[game.getCurrentRivalPokemon()].toUpperCase()+"   LV. 100",60,70);
				g.setFont(new Font("Times New Roman", Font.BOLD, 13));
				g.drawString("HP:",60,87);
				rivalHPBar.setVisible(true);
			}
			else
			{
				if(!game.gameOver())
				{
					isRivalBall = true;
					enterPokeball(false,true);
					paintPokeball(g);
				}
				/*g.setFont(new Font("Times New Roman", Font.BOLD, 30));
				g.setColor(Color.white);
				g.drawString(rivalPokemon[game.getCurrentRivalPokemon()]+" is unable to battle.", 10,540);
				 */
			}
		}

		if(heavenlyTimer.isRunning())
		{
			if(heavenlyStep%5==0)
				g.setColor(Color.pink);
			else if(heavenlyStep%5==1)
				g.setColor(Color.magenta);
			else if(heavenlyStep%5==2)
				g.setColor(Color.cyan);
			else if(heavenlyStep%5==3)
				g.setColor(Color.red);
			else if(heavenlyStep%5==4)
				g.setColor(Color.yellow);
			if(heavenlyStep<23)
				g.fillRoundRect(107, 0, 135, heavenlyStep*20,20,20);
			else
				g.fillRoundRect(107, 0, 135, 23*20,20,20);

			if(heavenlyStep%5==3)
				g.setColor(Color.pink);
			else if(heavenlyStep%5==4)
				g.setColor(Color.magenta);
			else if(heavenlyStep%5==0)
				g.setColor(Color.cyan);
			else if(heavenlyStep%5==1)
				g.setColor(Color.red);
			else if(heavenlyStep%5==2)
				g.setColor(Color.yellow);
			if(heavenlyStep<23)
				g.fillRoundRect(123, 0, 100, heavenlyStep*20,20,20);
			else
				g.fillRoundRect(123, 0, 100, 23*20,20,20);

			if(heavenlyStep%5==1)
				g.setColor(Color.pink);
			else if(heavenlyStep%5==2)
				g.setColor(Color.magenta);
			else if(heavenlyStep%5==3)
				g.setColor(Color.cyan);
			else if(heavenlyStep%5==4)
				g.setColor(Color.red);
			else if(heavenlyStep%5==0)
				g.setColor(Color.yellow);
			if(heavenlyStep<23)
				g.fillRoundRect(140, 0, 67, heavenlyStep*20,20,20);
			else
				g.fillRoundRect(140, 0, 67, 23*20,20,20);

			if(heavenlyStep%5==2)
				g.setColor(Color.pink);
			else if(heavenlyStep%5==3)
				g.setColor(Color.magenta);
			else if(heavenlyStep%5==4)
				g.setColor(Color.cyan);
			else if(heavenlyStep%5==0)
				g.setColor(Color.red);
			else if(heavenlyStep%5==1)
				g.setColor(Color.yellow);
			if(heavenlyStep<23)
				g.fillRoundRect(157, 0, 33, heavenlyStep*20,20,20);
			else
				g.fillRoundRect(157, 0, 33, 23*20,20,20);
		}

		for(int i = 0; i < 6; i++)
		{
			if(b)
			{
				if(game.getPlayerPokemonHP(i)>0)
				{
					g.setColor(Color.red);
					g.fillArc(550+13*i, 250, 13, 13, 0, 180);
					g.setColor(Color.white);
					g.fillArc(550+13*i, 250, 13, 13, 180, 180);
					g.setColor(Color.black);
					g.fillOval(555+13*i,255, 4, 4);
				}
				else
				{
					g.setColor(Color.gray);
					g.fillOval(550+13*i,250,13,13);
				}
			}

			if(c)
			{
				if(game.getRivalPokemonHP(i)>0)
				{
					g.setColor(Color.red);
					g.fillArc(55+13*i, 30, 13, 13, 0, 180);
					g.setColor(Color.white);
					g.fillArc(55+13*i, 30, 13, 13, 180, 180);
					g.setColor(Color.black);
					g.fillOval(60+13*i,35, 4, 4);
				}
				else
				{
					g.setColor(Color.gray);
					g.fillOval(55+13*i,30,13,13);
				}
			}
		}

		g.setFont(new Font("Times New Roman", Font.BOLD, 30));
		g.setColor(Color.white);
		if(b&&c)
		{
			g.drawString("What would "+playerPokemon[game.getCurrentPokemon()].toUpperCase(),10,540);
			g.drawString("like to do?",10, 570);
		}
	}

}

