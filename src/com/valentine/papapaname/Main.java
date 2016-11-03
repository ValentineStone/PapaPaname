package com.valentine.papapaname;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class Main
{
	public static void main(String[] _args) throws IOException
	{
		Path homePath = Paths.get(System.getProperty("user.home") + "/PapaPaname");
		
		Utils.exitIfPathDoesNotExist(homePath);
		//Desktop.getDesktop().open();
		
		Path formImagePath = homePath.resolve("form.png");
		Path formImagePathDest = homePath.resolve("dest.png");
		
		Utils.exitIfPathDoesNotExist(formImagePath);
		
		BufferedImage formImage = ImageIO.read(formImagePath.toFile());
		
		Graphics g = formImage.getGraphics();
		g.setColor(Color.GREEN);
	    g.setFont(g.getFont().deriveFont(30f));
	    g.drawString("Hello World!", 100, 100);
	    g.dispose();

	    ImageIO.write(formImage, "png", formImagePathDest.toFile());
	}

}
