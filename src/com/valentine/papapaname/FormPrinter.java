package com.valentine.papapaname;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class FormPrinter
{
	private FontData defaultFont;
	
	private Field[] fields;
	
	private transient JFrame jFrame = null;
	
	public void assebmle()
	{
		if (jFrame != null) return;
		
		jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLayout(null);
		jFrame.setSize(500, 500);
		jFrame.setLocationRelativeTo(null);
		
		for (Field field : fields)
		{
			JTextField jTextField = new JTextField();
			jTextField.setSize(field.getW(), field.getH());
			jTextField.setLocation(field.getX(), field.getY());
			jFrame.add(jTextField);
		}
		
		jFrame.setVisible(true);
	}
	
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder
		.append("FORMPRINTER:\n[\n")
		;
	
	if (defaultFont != null)
	stringBuilder
		.append("\tDEFAULTFONT:<")
		.append(defaultFont.toString())
		.append(">\n")
		;
	
	for (Field field : fields)
	stringBuilder
		.append("\t")
		.append(field.toString())
		.append("\n")
		;	
		
	stringBuilder
		.append("]")
		;
	
	return stringBuilder.toString();
	}
}
