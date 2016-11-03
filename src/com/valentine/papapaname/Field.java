package com.valentine.papapaname;

import java.awt.Font;

public class Field
{
	private int x;
	private int y;
	private int w;
	private int h;
	private String contents;
	private String name;
	private FontData font;
	
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
			.append("FIELD:[")
			.append(name)
			.append(", (x:")
			.append(x)
			.append(",y:")
			.append(y)
			.append(",w:")
			.append(w)
			.append(",h:")
			.append(h)
			.append(")")
			;
		
		if (contents != null)
		stringBuilder
			.append(", {")
			.append(contents)
			.append("}")
			;
		
		if (font != null)
		stringBuilder
			.append(", <")
			.append(font.toString())
			.append(">")
			;
			
		stringBuilder
			.append("]")
			;
			
		return stringBuilder.toString();
	}

	public Font getFont()
	{
		return font.getFont();
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getW()
	{
		return w;
	}

	public int getH()
	{
		return h;
	}

	public String getContents()
	{
		return contents;
	}

	public String getName()
	{
		return name;
	}
	
	
}
