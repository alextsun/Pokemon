import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MenuPanel extends JPanel implements ActionListener
{
	private Pokemon game;
	//private JLabel title;
	private JButton start;
	
	public MenuPanel(Pokemon p)
	{
		game = p;
		setBackground(Color.black);
		this.setLayout(null);
		
		/*title = new JLabel("Pokemon");
		title.setBounds(295,50,500,60);
		title.setForeground(Color.yellow);
		title.setBackground(Color.black);
		title.setFont(new Font("Times New Roman", Font.ITALIC | Font.BOLD, 80));*/
		
		start = new JButton("Start");
		start.setBounds(350,300,200,100);
		start.setForeground(Color.white);
		start.setBackground(Color.black);
		start.addActionListener(this);
		
		//this.add(title);
		this.add(start);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(ImageIconFactory.getImage("background.png"),0,0,885,662,this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		game.showIntroPanel();
	}

}
