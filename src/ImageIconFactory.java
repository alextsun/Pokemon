import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ImageIconFactory 
{
	private static String addPrefix(String name) //prefix needed for my computer
	//on other computers, change the prefix as needed
	{
		return ("src/Images/"+name);
	}
	
	public static ImageIcon getPokemonIcon(String poke)
	{
		ImageIcon pokemon = new ImageIcon(addPrefix(poke+".gif"));
		return pokemon;
	}
	
	public static Image getImage(String name) //returns any image with the provided name
    {
		String imageName = ImageIconFactory.addPrefix(name); //add prefix to the name
		Image image = null;
		
        try
        {
           image = ImageIO.read(new File(imageName)); //try reading the image with the name
        }
        catch (IOException e)
        {
        	//if no image has that name, print error/exit
            System.out.println("ERROR: "+name+" IMAGE NOT FOUND");
            System.exit(1);
        }
        return image; //returns the image
    }
	
	public static Image getBackgroundImage() //returns background
    {
		return getImage("dojo.jpg"); //gets the image named "dojo.jpg"
    }
}
