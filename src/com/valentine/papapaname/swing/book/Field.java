package com.valentine.papapaname.swing.book;

import javax.swing.*;
import javax.swing.event.*;

public class Field
{
	public String name;
	public int x;
	public int y;
	public int w;
	public int h;
	public FontData font;
	
	private String contents = "";
	private transient JTextField jTextField;
	
	
	
	public void assemble()
	{
		if (jTextField != null) return;
		

		if (font == null)
		{
			font = FontData.DEFAULT_FONT_DATA;
		}
		
		font.craft();
		
		jTextField = new JTextField();
		
		jTextField.setBorder
		(
			BorderFactory.createCompoundBorder
			(
				BorderFactory.createRaisedBevelBorder(),
				BorderFactory.createLoweredBevelBorder()
			)
		);
		
		jTextField.setLocation(x, y);
		jTextField.setSize(w, h);
		jTextField.setForeground(font.getColor());
		jTextField.setFont(font.getFont());
		
		jTextField.getDocument().addDocumentListener
		(
			new DocumentListener()
			{
				public void removeUpdate(DocumentEvent _e)
				{
					edited();
				}
				
				public void insertUpdate(DocumentEvent _e)
				{
					edited();
				}
				
				public void changedUpdate(DocumentEvent _e)
				{
					edited();
				}
				
				private void edited()
				{
					contents = jTextField.getText();
				}
			}
		);
	}
	

	public String getContents()
	{
		return contents;
	}
	
	public void setContents(String _contents)
	{
		contents = _contents;
		
		if (jTextField != null)
		{
			jTextField.setText(_contents);
		}
	}


	public JTextField getjTextField()
	{
		return jTextField;
	}
}
