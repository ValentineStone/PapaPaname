package com.valentine.papapaname.swing.book;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.List;

import javax.imageio.*;
import javax.swing.*;

public class Form implements Iterable<Field>
{
	public String name;
	public String background;
	public int width;
	public int height;
	public FontData font;
	public List<Field> fields = new ArrayList<>();
	
	private transient JFrame jFrame = null;
	private transient JMenuBar jMenubar = null;
	private transient BufferedImage image;
	private transient Map<String,Field> fieldMap = new HashMap<>();
	
	public void assebmle()
	{
		if (jFrame != null) return;
		

		if (font == null)
		{
			font = FontData.DEFAULT_FONT_DATA;
		}
		
		
		for (Field field : this)
		{
			if (field.font == null)
				field.font = font;
			else
				field.font.underlay(font);
			
			field.assemble();
			fieldMap.put(field.name, field);
		}
		
		jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setTitle(name);
		
		
		jFrame.setResizable(false);
		
		jFrame.setLayout(null);
		
		
		
		for (Field field : this)
		{	
			jFrame.add(field.getjTextField());
		}
		
		
		JLabel jLabel = new JLabel();
		jLabel.setSize(width, height);
		jLabel.setLocation(0, 0);
		
		jFrame.add(jLabel);
		
		jFrame.getContentPane().setComponentZOrder
		(
			jLabel,
			jFrame.getContentPane().getComponentCount() - 1
		);
		
		try
		{
			image =
			ImageIO.read
			(
				Paths
				.get(System.getProperty("PapaPaname.appdata"))
				.resolve(background)
				.toFile()
			);
			
			jLabel.setIcon(new ImageIcon(image));
		}
		catch (Exception _exc)
		{
			image = null;
		}
		
		
		
		
		
		
		
        jMenubar = new JMenuBar();

        JButton jButtonSave = new JButton("Save");
        JButton jButtonClose = new JButton("Close");
        
        jButtonSave.addActionListener
        (
        	(ActionEvent _event) ->
        	{
        		savePicture(true, true);
        	}
        );
        
        jButtonClose.addActionListener
        (
        	(ActionEvent _event) ->
        	{
        		jFrame.dispatchEvent
        		(
        			new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING)
        		);
        	}
        );

        jMenubar.add(jButtonSave);
        jMenubar.add(jButtonClose);

        jFrame.setJMenuBar(jMenubar);
		
		
		
		jFrame.setVisible(true);
		
		Insets insets = jFrame.getInsets();
		
		jFrame.setSize
		(
			width
			+ insets.left
			+ insets.right,
			height
			+ insets.top
			+ insets.bottom
			+ jMenubar.getHeight()
		);
	}
	
	
	

	public Field getField(String _name)
	{
		return fieldMap.get(_name);
	}




	public Iterator<Field> iterator()
	{
		return fields.iterator();
	}
	
	
	
	
	
	public void savePicture(boolean _showSaved, boolean _centerContents)
	{
		BufferedImage renderedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = renderedImage.createGraphics();
		
		if (image != null)
		{
			graphics2d.drawImage(image, 0, 0, null);
		}
		
		for (Field field : this)
		{
			graphics2d.setColor(field.font.getColor());
			graphics2d.setFont(field.font.getFont());
			
			int stringWidth = graphics2d.getFontMetrics().stringWidth(field.getContents());
			int charHeight = graphics2d.getFontMetrics().getAscent();
			
			int stringPosY = (int) (field.y + field.h / 2. + charHeight / 2.);
			int stringPosX = field.x;
			
			if (_centerContents)
			{
				stringPosX = (int) (field.x + field.w / 2. - stringWidth / 2.);
			}
			
			graphics2d.drawString(field.getContents(), stringPosX, stringPosY);
		}
		
		try
		{
			String imageName = "_" + background;
			
			Path imagePath = Paths.get(System.getProperty("PapaPaname.appdata")).resolve(imageName);
			
			ImageIO.write(renderedImage,"png", imagePath.toFile());
			
			if (_showSaved) Desktop.getDesktop().open(imagePath.toFile());
		}
		catch (IOException _e)
		{
			JOptionPane.showMessageDialog(jFrame, "Some error during save,\nplease show that to ye programmer friends:\n" + _e.getMessage());
		}
	}
	
}