import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class PokemonPanel extends JPanel implements ActionListener
{
	private Pokemon game;
	private CardLayout cards1;
	private JPanel pPanel1, pPanel2, pPanel3, pPanel4, pPanel5, pPanel6;
	private JButton pkmn1, pkmn2, pkmn3, pkmn4, pkmn5, pkmn6, pkmn7, pkmn8, pkmn9;
	private JButton pkmn10, pkmn11, pkmn12, pkmn13, pkmn14, pkmn15, pkmn16, pkmn17, pkmn18;
	private String[][] pkmn = new String[6][3];
	private JLabel label1, label2, label3, label4, label5, label6;
	private int currentSlide = 1;

	public PokemonPanel(Pokemon p)
	{
		game = p;
		cards1 = new CardLayout();
		this.setLayout(cards1); //set layout to cardlayout
		
		pkmn[0][0] = "chartoise";
		pkmn[0][1] = "venuizard";
		pkmn[0][2] = "blastusaur";
		pkmn[1][0] = "tentaeot";
		pkmn[1][1] = "nidoeot";
		pkmn[1][2] = "Hopurple";
		pkmn[2][0] = "startly";
		pkmn[2][1] = "rhydrio";
		pkmn[2][2] = "dewchan";
		pkmn[3][0] = "Aggroblack";
		pkmn[3][1] = "Dragphlosion";
		pkmn[3][2] = "Mamofire";
		pkmn[4][0] = "tentanine";
		pkmn[4][1] = "maroizard";
		pkmn[4][2] = "dewkazam";
		pkmn[5][0] = "rhyking";
		pkmn[5][1] = "blastnine";
		pkmn[5][2] = "cubra";
		
		
		label1 = new JLabel((pkmn[0][0]+"              " + pkmn[0][1] + "           " + pkmn[0][2]).toUpperCase());
		label2 = new JLabel((pkmn[1][0]+"            " + pkmn[1][1] + "          " + pkmn[1][2]).toUpperCase());
		label3 = new JLabel(("    "+pkmn[2][0]+"            " + pkmn[2][1] + "            " + pkmn[2][2]).toUpperCase());
		label4 = new JLabel((pkmn[3][0]+"              " + pkmn[3][1] + "           " + pkmn[3][2]).toUpperCase());
		label5 = new JLabel((pkmn[4][0]+"            " + pkmn[4][1] + "          " + pkmn[4][2]).toUpperCase());
		label6 = new JLabel(("    "+pkmn[5][0]+"            " + pkmn[5][1] + "            " + pkmn[5][2]).toUpperCase());
		
		
		label1.setForeground(Color.white);
		label2.setForeground(Color.white);
		label3.setForeground(Color.white);
		label4.setForeground(Color.white);
		label5.setForeground(Color.white);
		label6.setForeground(Color.white);
		
		label1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label3.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label4.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label5.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label6.setFont(new Font("Times New Roman", Font.BOLD, 28));
		
		label1.setPreferredSize(new Dimension(700,50));
		label2.setPreferredSize(new Dimension(700,50));
		label3.setPreferredSize(new Dimension(880,50));//880
		label4.setPreferredSize(new Dimension(700,50));
		label5.setPreferredSize(new Dimension(700,50));
		label6.setPreferredSize(new Dimension(700,50));//880

		pPanel1 = new JPanel();
		pPanel2 = new JPanel();
		pPanel3 = new JPanel();
		pPanel4 = new JPanel();
		pPanel5 = new JPanel();
		pPanel6 = new JPanel();
		
		pPanel1.setBackground(Color.black);
		pPanel2.setBackground(Color.black);
		pPanel3.setBackground(Color.black);
		pPanel4.setBackground(Color.black);
		pPanel5.setBackground(Color.black);
		pPanel6.setBackground(Color.black);
		
		pkmn1 = new JButton();
		pkmn2 = new JButton();
		pkmn3 = new JButton();
		pkmn4 = new JButton();
		pkmn5 = new JButton();
		pkmn6 = new JButton();
		pkmn7 = new JButton();
		pkmn8 = new JButton();
		pkmn9 = new JButton();
		pkmn10 = new JButton();
		pkmn11 = new JButton();
		pkmn12 = new JButton();
		pkmn13 = new JButton();
		pkmn14 = new JButton();
		pkmn15 = new JButton();
		pkmn16 = new JButton();
		pkmn17 = new JButton();
		pkmn18 = new JButton();
		
		pkmn1.setBackground(Color.black);
		pkmn2.setBackground(Color.black);
		pkmn3.setBackground(Color.black);
		pkmn4.setBackground(Color.black);
		pkmn5.setBackground(Color.black);
		pkmn6.setBackground(Color.black);
		pkmn7.setBackground(Color.black);
		pkmn8.setBackground(Color.black);
		pkmn9.setBackground(Color.black);
		pkmn10.setBackground(Color.black);
		pkmn11.setBackground(Color.black);
		pkmn12.setBackground(Color.black);
		pkmn13.setBackground(Color.black);
		pkmn14.setBackground(Color.black);
		pkmn15.setBackground(Color.black);
		pkmn16.setBackground(Color.black);
		pkmn17.setBackground(Color.black);
		pkmn18.setBackground(Color.black);
		
		pkmn1.setActionCommand(pkmn[0][0]);
		pkmn2.setActionCommand(pkmn[0][1]);
		pkmn3.setActionCommand(pkmn[0][2]);
		pkmn4.setActionCommand(pkmn[1][0]);
		pkmn5.setActionCommand(pkmn[1][1]);
		pkmn6.setActionCommand(pkmn[1][2]);
		pkmn7.setActionCommand(pkmn[2][0]);
		pkmn8.setActionCommand(pkmn[2][1]);
		pkmn9.setActionCommand(pkmn[2][2]);
		pkmn10.setActionCommand(pkmn[3][0]);
		pkmn11.setActionCommand(pkmn[3][1]);
		pkmn12.setActionCommand(pkmn[3][2]);
		pkmn13.setActionCommand(pkmn[4][0]);
		pkmn14.setActionCommand(pkmn[4][1]);
		pkmn15.setActionCommand(pkmn[4][2]);
		pkmn16.setActionCommand(pkmn[5][0]);
		pkmn17.setActionCommand(pkmn[5][1]);
		pkmn18.setActionCommand(pkmn[5][2]);
		
		
		pkmn1.setIcon(ImageIconFactory.getPokemonIcon(pkmn[0][0]));
		pkmn2.setIcon(ImageIconFactory.getPokemonIcon(pkmn[0][1]));
		pkmn3.setIcon(ImageIconFactory.getPokemonIcon(pkmn[0][2]));
		pkmn4.setIcon(ImageIconFactory.getPokemonIcon(pkmn[1][0]));
		pkmn5.setIcon(ImageIconFactory.getPokemonIcon(pkmn[1][1]));
		pkmn6.setIcon(ImageIconFactory.getPokemonIcon(pkmn[1][2]));
		pkmn7.setIcon(ImageIconFactory.getPokemonIcon(pkmn[2][0]));
		pkmn8.setIcon(ImageIconFactory.getPokemonIcon(pkmn[2][1]));
		pkmn9.setIcon(ImageIconFactory.getPokemonIcon(pkmn[2][2]));
		pkmn10.setIcon(ImageIconFactory.getPokemonIcon(pkmn[3][0]));
		pkmn11.setIcon(ImageIconFactory.getPokemonIcon(pkmn[3][1]));
		pkmn12.setIcon(ImageIconFactory.getPokemonIcon(pkmn[3][2]));
		pkmn13.setIcon(ImageIconFactory.getPokemonIcon(pkmn[4][0]));
		pkmn14.setIcon(ImageIconFactory.getPokemonIcon(pkmn[4][1]));
		pkmn15.setIcon(ImageIconFactory.getPokemonIcon(pkmn[4][2]));
		pkmn16.setIcon(ImageIconFactory.getPokemonIcon(pkmn[5][0]));
		pkmn17.setIcon(ImageIconFactory.getPokemonIcon(pkmn[5][1]));
		pkmn18.setIcon(ImageIconFactory.getPokemonIcon(pkmn[5][2]));
		
		pkmn1.addActionListener(this);
		pkmn2.addActionListener(this);
		pkmn3.addActionListener(this);
		pkmn4.addActionListener(this);
		pkmn5.addActionListener(this);
		pkmn6.addActionListener(this);
		pkmn7.addActionListener(this);
		pkmn8.addActionListener(this);
		pkmn9.addActionListener(this);
		pkmn10.addActionListener(this);
		pkmn11.addActionListener(this);
		pkmn12.addActionListener(this);
		pkmn13.addActionListener(this);
		pkmn14.addActionListener(this);
		pkmn15.addActionListener(this);
		pkmn16.addActionListener(this);
		pkmn17.addActionListener(this);
		pkmn18.addActionListener(this);
		
		pkmn1.setPreferredSize(new Dimension(280,600));
		pkmn2.setPreferredSize(new Dimension(280,600));
		pkmn3.setPreferredSize(new Dimension(280,600));
		pkmn4.setPreferredSize(new Dimension(280,600));
		pkmn5.setPreferredSize(new Dimension(280,600));
		pkmn6.setPreferredSize(new Dimension(280,600));
		pkmn7.setPreferredSize(new Dimension(280,600));
		pkmn8.setPreferredSize(new Dimension(280,600));
		pkmn9.setPreferredSize(new Dimension(280,600));
		pkmn10.setPreferredSize(new Dimension(280,600));
		pkmn11.setPreferredSize(new Dimension(280,600));
		pkmn12.setPreferredSize(new Dimension(280,600));
		pkmn13.setPreferredSize(new Dimension(280,600));
		pkmn14.setPreferredSize(new Dimension(280,600));
		pkmn15.setPreferredSize(new Dimension(280,600));
		pkmn16.setPreferredSize(new Dimension(280,600));
		pkmn17.setPreferredSize(new Dimension(280,600));
		pkmn18.setPreferredSize(new Dimension(280,600));
		
		pPanel1.add(pkmn1);
		pPanel1.add(pkmn2);
		pPanel1.add(pkmn3);
		pPanel2.add(pkmn4);
		pPanel2.add(pkmn5);
		pPanel2.add(pkmn6);
		pPanel3.add(pkmn7);
		pPanel3.add(pkmn8);
		pPanel3.add(pkmn9);
		pPanel4.add(pkmn10);
		pPanel4.add(pkmn11);
		pPanel4.add(pkmn12);
		pPanel5.add(pkmn13);
		pPanel5.add(pkmn14);
		pPanel5.add(pkmn15);
		pPanel6.add(pkmn16);
		pPanel6.add(pkmn17);
		pPanel6.add(pkmn18);
		
		pPanel1.add(label1);
		pPanel2.add(label2);
		pPanel3.add(label3);
		pPanel4.add(label4);
		pPanel5.add(label5);
		pPanel6.add(label6);
		
		//pPanel1.setLayout(null);
		
		this.add(pPanel1, "Panel 1");
		this.add(pPanel2, "Panel 2");
		this.add(pPanel3, "Panel 3");
		this.add(pPanel4, "Panel 4");
		this.add(pPanel5, "Panel 5");
		this.add(pPanel6, "Panel 6");
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String name = e.getActionCommand();
		if(currentSlide==1)
			game.setPlayerPokemon(name,1);
		else if(currentSlide==2)
			game.setPlayerPokemon(name,2);
		else if(currentSlide==3)
			game.setPlayerPokemon(name,3);
		else if(currentSlide==4)
			game.setPlayerPokemon(name,4);
		else if(currentSlide==5)
			game.setPlayerPokemon(name,5);
		else if(currentSlide==6)
			game.setPlayerPokemon(name,6);
		System.out.println("player pkmn " + currentSlide + " = " + name);
		currentSlide++;
		
		if(currentSlide<7)
			cards1.next(this);
		else
			game.showActionPanel();
	}

}
