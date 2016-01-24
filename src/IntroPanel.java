import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class IntroPanel extends JPanel implements MouseListener, ActionListener
{
	private Pokemon game;
	private Image professor;
	private String[] lines = new String[7];
	private int currentString = 0;
	private JPanel genderPanel, namePanel, difficultyPanel;
	private JButton easy, hard, evil;
	private JButton boy, girl;
	private JTextField nameField;
	private JButton confirmName;

	public IntroPanel(Pokemon p)
	{
		game = p;
		this.setBackground(Color.black);
		this.addMouseListener(this);
		this.setLayout(null);

		lines[0] = "Hello, and welcome to the world of Pokemon.";
		lines[1] = "My name is Professor Oak.";
		lines[2] = "Can you tell me, what is your name?";
		lines[3] = "Can you tell me, are you a boy, or a girl?";
		lines[4] = "You will have a full battle with Paul, your rival.";
		lines[5] = "Would you like to battle easy, hard, or evil Paul?";
		lines[6] = "All right.  Now please choose six Pokemon to battle with.";

		genderPanel = new JPanel();
		genderPanel.setBounds(330,500,230,37);
		
		difficultyPanel = new JPanel();
		difficultyPanel.setBounds(330,500,230,37);
		difficultyPanel.setVisible(false);

		boy = new JButton("Boy");
		boy.setBackground(Color.blue);
		boy.setForeground(Color.white);
		boy.addActionListener(this);
		boy.setActionCommand("boy");
		boy.setPreferredSize(new Dimension(100,30));
		genderPanel.add(boy);

		girl = new JButton("Girl");
		girl.setBackground(Color.red);
		girl.setForeground(Color.white);
		girl.addActionListener(this);
		girl.setActionCommand("girl");
		girl.setPreferredSize(new Dimension(100,30));
		genderPanel.add(girl);
		
		
		easy = new JButton("Easy");
		easy.setBackground(Color.blue);
		easy.setForeground(Color.white);
		easy.addActionListener(this);
		easy.setActionCommand("easy");
		easy.setPreferredSize(new Dimension(67,30));
		difficultyPanel.add(easy);
		
		hard = new JButton("Hard");
		hard.setBackground(Color.red);
		hard.setForeground(Color.white);
		hard.addActionListener(this);
		hard.setActionCommand("hard");
		hard.setPreferredSize(new Dimension(67,30));
		difficultyPanel.add(hard);


		evil = new JButton("Evil");
		evil.setBackground(Color.black);
		evil.setForeground(Color.white);
		evil.addActionListener(this);
		evil.setActionCommand("evil");
		evil.setPreferredSize(new Dimension(67,30)); //100,30
		difficultyPanel.add(evil);

		genderPanel.setVisible(false);

		confirmName = new JButton("Confirm");
		confirmName.setBackground(Color.black);
		confirmName.setForeground(Color.white);
		confirmName.addActionListener(this);
		confirmName.setActionCommand("confirm");
		confirmName.setPreferredSize(new Dimension(100,30));

		namePanel = new JPanel();
		nameField = new JTextField("Player");
		namePanel.setBounds(350,500,200,50);
		nameField.setPreferredSize(new Dimension(80,40));
		confirmName.setPreferredSize(new Dimension(100,40));
		namePanel.add(nameField);
		namePanel.add(confirmName);
		namePanel.setVisible(false);

		this.add(namePanel);
		this.add(genderPanel);
		this.add(difficultyPanel);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(ImageIconFactory.getImage("spotlight2.jpg"),261,0,350,420,this);
		g.drawImage(ImageIconFactory.getImage("professor.png"),337,50,178,322,this);

		g.setColor(Color.green);
		g.fillRoundRect(0,400,883,200,20,20);
		g.setColor(Color.white);
		g.fillRoundRect(5,405,873,190,20,20);

		g.setFont(new Font("Times New Roman", Font.BOLD, 30));
		g.drawString("Click anywhere to continue...", 280, 640);
		g.setColor(Color.black);
		g.drawString(lines[currentString], 100,450);


	}

	public void actionPerformed(ActionEvent e)
	{
		String m = e.getActionCommand();
		if(m.equalsIgnoreCase("boy"))
		{
			game.setIsBoy(true);
			genderPanel.setVisible(false);
			currentString++;
			System.out.println("gender = boy");
		}
		else if(m.equalsIgnoreCase("girl"))
		{
			game.setIsBoy(false);
			genderPanel.setVisible(false);
			currentString++;
			System.out.println("gender = girl");
		}
		else if(m.equalsIgnoreCase("confirm"))
		{
			if(nameField.getText().trim().length()>0)
			{
				game.setPlayerName(nameField.getText());
				System.out.println("name  = " + game.getPlayerName());
				namePanel.setVisible(false);
				genderPanel.setVisible(true);
				currentString++;
			}
		}
		else if(m.equalsIgnoreCase("easy"))
		{
			currentString++;
			game.setPaulPokemon(1);
			difficultyPanel.setVisible(false);
		}
		else if(m.equalsIgnoreCase("hard"))
		{
			currentString++;
			game.setPaulPokemon(2);
			difficultyPanel.setVisible(false);
		}
		else if(m.equalsIgnoreCase("evil"))
		{
			currentString++;
			game.setPaulPokemon(3);
			difficultyPanel.setVisible(false);
		}
		repaint();


	}

	public void mousePressed(MouseEvent e)
	{
		if(currentString!=6)
		{
			if(currentString<2 || currentString == 4)
				currentString++;
			if(currentString==3)
				genderPanel.setVisible(true);
			else
				genderPanel.setVisible(false);
			if(currentString==2)
				namePanel.setVisible(true);
			else
				namePanel.setVisible(false);
			if(currentString==5)
				difficultyPanel.setVisible(true);
			else
				difficultyPanel.setVisible(false);
			repaint();
		}
		else
		{
			game.showPokemonPanel();
		}
	}

	public void mouseClicked(MouseEvent e)
	{

	}

	public void mouseReleased(MouseEvent e)
	{

	}

	public void mouseEntered(MouseEvent e)
	{

	}

	public void mouseExited(MouseEvent e)
	{

	}

}
